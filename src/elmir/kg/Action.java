package elmir.kg;

import java.util.Arrays;

public class Action {
    public static void startProgramm() {
        Product[] products = JSONFileHandler.getProducts();
        System.out.println(Arrays.toString(products));
    }
}
