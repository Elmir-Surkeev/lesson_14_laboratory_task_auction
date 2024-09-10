package elmir.kg;
//продан товар
public class alreadySolded extends State {

    @Override
    public void raisePrice(Product product) throws Exception{
        throw new Exception("Нельзя повысить цену товара так как товар уже продан");
    }

    @Override
    public void startSale(Product product) throws Exception{
        throw new Exception("Нельзя начать продажу, так как товар уже продан");
    }

    @Override
    public void giveToWinner(Product product) throws Exception{
        throw new Exception("Нельзя выдать товар покупателю , так как товар уже продан");
    }

    @Override
    public void withDraw(Product product) throws Exception{
        throw new Exception("Нельзя снять товар с торгов, так как товар уже продан");
    }
}
