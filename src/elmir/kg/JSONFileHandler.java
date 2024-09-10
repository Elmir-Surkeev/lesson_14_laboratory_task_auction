package elmir.kg;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class JSONFileHandler {
    private static final Gson gson = new Gson();

    public static Product[] getProducts() {
        try (Reader reader = new FileReader("products.json")) {
            return gson.fromJson(reader, Product[].class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new Product[0];
    }

    public static void writeProducts(Product[] product) {
        try (Writer writer = new FileWriter("products.json")){
            String json = gson.toJson(product);
            writer.write(json);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}