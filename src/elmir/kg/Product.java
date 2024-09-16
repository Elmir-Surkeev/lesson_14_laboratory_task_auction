package elmir.kg;

public class Product {
    private int id;
    private String name;
    private double price;
    private String honoraryCode;
    private String state;
    private transient State productState;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public Product[] setPrice(double price) {
        this.price = price;
        return new Product[0];
    }

    public String getHonoraryCode() {
        return honoraryCode;
    }

    public void setHonoraryCode(String honoraryCode) {
        this.honoraryCode = honoraryCode;
    }

    public String getState() {
        return state;
    }

    public void setProductState(State productState) {
        this.productState = productState;
    }


    public void raisePrice(){
        try {
            this.productState.raisePrice(this);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void startSale(){
        try {
            this.productState.startSale(this);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void giveToWinner(){
        try {
            this.productState.giveToWinner(this);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void withDraw(){
        try {
            this.productState.withDraw(this);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public State getProductState(){
        return  this.productState;
    }

    public void setProductState(){
         switch (this.state){
             case "inStock" -> this.productState = new InStock();
             case "alreadySolded" -> this.productState = new AlreadySolded();
             case "forSale" -> this.productState = new ForSale();
         }
    }
    public void setState(String state) {
         this.state = state;
    }
    @Override
    public String toString() {
        String stateName = (productState != null) ? productState.getClass().getSimpleName() : "State not set";
        return String.format("| %-5d | %-20s | %-10.2f | %-15s | %-10s | %-30s | \n",
                id, name, price, honoraryCode, state, stateName);
    }

}













