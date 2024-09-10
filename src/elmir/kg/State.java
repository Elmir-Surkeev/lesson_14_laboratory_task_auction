package elmir.kg;

public abstract class State {
    public abstract void startSale(Product product) throws Exception;
    public abstract void raisePrice(Product product) throws Exception;
    public abstract void withDraw(Product product) throws Exception;
    public abstract void giveToWinner(Product product) throws Exception;
}
