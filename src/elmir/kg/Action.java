package elmir.kg;

import java.util.Arrays;

public class Action {
    public static void startProgramm() {
        Product[] products = JSONFileHandler.getProducts();
        while (true){
            System.out.println(Arrays.toString(products));
        }
    }
}
