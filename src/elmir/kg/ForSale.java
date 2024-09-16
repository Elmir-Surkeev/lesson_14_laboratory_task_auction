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
            if (product.getPrice() == 0){
                System.out.println("Нельзя отдать товар бесплатно");
            }


            Product[] products = JSONFileHandler.getProducts();
            product.setState("Sold");

            CodeGenerator generator = new CodeGenerator();
//            for (Product product1 : products) {
//                if (product1.getPrice() >= 1000) {
//                    generator.makeCode("GOLD-" + product1.getId());
//                    break;
//                }
//                else if (product1.getPrice()>500 && product1.getPrice()<1000) {
//                    generator.makeCode("Silver-" + product1.getId());
//                }else {
//                    generator.makeCode("Bronze-" + product1.getId());
//                }
//            }
            CodeGenerator generator1 = new CodeGenerator();

            for (Product t : products) {
                if (t.getPrice() >= 1000) {
                    JSONFileHandler.writeProducts(product.setHonoraryCode(generator1.makeCode("Gold-" + t.getId())));
                    break;
                } else if (t.getPrice() > 500 && t.getPrice() < 1000) {
                    JSONFileHandler.writeProducts(product.setHonoraryCode(generator1.makeCode("Silver-" + t.getId())));
                } else {
                    JSONFileHandler.writeProducts(product.setHonoraryCode(generator1.makeCode("Bronze-" + t.getId())));
                }
            }
            JSONFileHandler.writeProducts(products);
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
