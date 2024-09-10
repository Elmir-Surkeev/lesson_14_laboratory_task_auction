package elmir.kg;
//На торгах
public class forSale extends State{

    @Override
    public void raisePrice(Product product) throws Exception {
        // Метод raisePrice - поднимет цену на товар на фиксированное значение и вернёт сообщение
        //об успешном повышении цены.
    }

    @Override
    public void startSale(Product product) throws Exception {
        System.out.println("Товар уже участвует в торгах");
    }


    @Override
    public void giveToWinner(Product product) throws Exception {
        //Метод giveToTheWinner - Если цена товара равна нулю, то метод вернёт сообщение об
        //ошибке - нельзя отдать товар бесплатно. Если цена больше нуля, то изменить состояние
        //товара на "sold"
    }

    @Override
    public void withDraw(Product product) throws Exception {
        //Метод withdraw - если начальная цена товара не изменилась, то вернёт товар на склад и
        //изменит состояние на "in_stock". Иначе, если текущая цена отличается от начальной, то
        //вернёт сообщение об ошибке - товар уже в резерве, можно только выдать
    }
}
