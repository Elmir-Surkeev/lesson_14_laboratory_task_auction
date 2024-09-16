package elmir.kg;
//На торгах
public class ForSale extends State{

    @Override
//    public void raisePrice(Product product) throws Exception {
//        try {
//            Product[] products = JSONFileHandler.getProducts();
//
//            if (products == null) {
//                throw new Exception("Список продуктов пустой или не был загружен.");
//            }
//
//            boolean priceUpdated = false;
//
//            for (Product t : products) {
//                if (t.getId() == product.getId()) {
//                    t.setPrice(t.getPrice() + 100);
//                    priceUpdated = true;
//                    break;
//                }
//            }
//
//            if (priceUpdated) {
//                JSONFileHandler.writeProducts(products);
//                System.out.println("Цена была увеличена, текущая цена составляет: " + product.getPrice());
//            } else {
//                throw new Exception("Продукт не найден.");
//            }
//        } catch (Exception e) {
//            throw new Exception("Возникли проблемы при повышении цены", e);
//        }
//    }
    public void raisePrice(Product product) throws Exception {
        try {
            Product[] products = JSONFileHandler.getProducts();

            if (products == null) {
                throw new Exception("Список продуктов пустой или не был загружен.");
            }

            for (Product t : products) {
                if (t.getId() == product.getId()) {
                    JSONFileHandler.writeProducts(product.setPrice(t.getPrice() + 100));
                    break;
                }
            }


        } catch (Exception e) {
            throw new Exception("Возникли проблемы при повышении цены", e);
        }
    }

    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("Товар уже участвует в торгах");
    }


    @Override
    public void giveToWinner(Product product) throws Exception {
        try {
            Product[] products = JSONFileHandler.getProducts();
            product.setState("alreadySolded");

            if (product.getPrice() == 0){
                System.out.println("Нельзя отдать товар бесплатно");
            }
        }
        catch (Exception e){
            throw new Exception("Возникла ошибка");
        }
        //Метод giveToTheWinner - Если цена товара равна нулю, то метод вернёт сообщение об
        //ошибке - нельзя отдать товар бесплатно. Если цена больше нуля, то изменить состояние
        //товара на "sold"
    }

    @Override
    public void withDraw(Product product) throws Exception {
        try {
            Product[] products = JSONFileHandler.getProducts();
            if (product.getPrice() == product.getPrice()){
                System.out.println("Товар бы отправлен на склад");
                product.setState("inStock");
            }else {
                System.out.println("Товар уже в резерве, можно только выдать");
            }
        }
        catch (Exception e ){
            throw new Exception("Возникла ошибка");
        }
        //Метод withdraw - если начальная цена товара не изменилась, то вернёт товар на склад и
        //изменит состояние на "in_stock". Иначе, если текущая цена отличается от начальной, то
        //вернёт сообщение об ошибке - товар уже в резерве, можно только выдать
    }
}
