package elmir.kg;
//На торгах
public class forSale extends State{

    @Override
    public void raisePrice(Product product) throws Exception {
        try {
            Product[] products = JSONFileHandler.getProducts();

            if (products == null) {
                throw new Exception("Список продуктов пустой или не был загружен.");
            }

            for (Product t : products) {
                if (t.getId() == product.getId()) { // Сравнение по идентификатору, а не по цене
                    t.setPrice(t.getPrice() + 50);
                    JSONFileHandler.writeProducts(products);
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception("Возникли проблемы", e);
        }
        // Метод raisePrice - поднимет цену на товар на фиксированное значение и вернёт сообщение
        //об успешном повышении цены.
    }

    @Override
    public void startSale(Product product) throws Exception {
        System.out.println("Товар уже участвует в торгах");
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
