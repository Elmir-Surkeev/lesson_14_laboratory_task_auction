package elmir.kg;
//  находится на складе
public class inStock extends State {

    @Override
    public void raisePrice(Product product) throws Exception {
        System.out.println("Ошибка. Так как товар на данный момент на складе "+ "\n" +" Он не может учавствовать в торгах");
    }

    @Override
    public void startSale(Product product) throws Exception {
        try {
            Product[] products = JSONFileHandler.getProducts();
            System.out.println("Товар выставлен на продажу");
            product.setState("forSale");
        }catch (Exception e){
            throw new Exception("Возникла ошибка");
        }
        //Метод startSale - изменит состояние товара на "for_sale", и вернёт сообщение об успешном
        //начале торгов.
    }

    @Override
    public void giveToWinner(Product product) throws Exception {
        System.out.println("Товар находится на складе нельзя будет сразу, отдать товар со склада");
    }

    @Override
    public void withDraw(Product product) throws Exception {
        System.out.println("Нельзя снят товар с торгах, так как товар находится в складе "+"\n"
                            + "Товар на складе не учавствует в торгах");
    }

}
