package elmir.kg;
//  находится на складе
public class inStock extends State {
    @Override
    public void startSale(Product product) throws Exception {
        System.out.println("Ошибка. Так как товар на данный момент на складе "+ "\n" +" Он не может учавствовать в торгах");
    }

    @Override
    public void raisePrice(Product product) throws Exception {

    }

    @Override
    public void withDraw(Product product) throws Exception {

    }

    @Override
    public void giveToWinner(Product product) throws Exception {

    }
}
