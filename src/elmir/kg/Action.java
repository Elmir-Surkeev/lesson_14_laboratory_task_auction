package elmir.kg;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Action {
    public static void startProgramm() throws RuntimeException {
        System.out.println("     id   |"+ "          name        |"+"    price   |"+"      code       |"+"  state "+"    |lastState             |");
        System.out.println("__________|______________________|____________|_________________|____________|______________________|");
        Product[] products = JSONFileHandler.getProducts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Arrays.toString(products));
            System.out.println("Введите идентификатор товара");

            int id = -1;

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное числовое значение.");
                scanner.next();
                continue;
            }

            if (id < 0 || id >= products.length) {
                System.out.println("Неверный идентификатор.");
                continue;
            }

            Product product = products[id];
            product.setProductState();

            System.out.println("Введите действие, которое хотите совершить");
            System.out.println("Введите 1 - Выставить на аукцион, введите 2 - Поднять цену");
            System.out.println("Введите 3 - Выдать победителю, введите 4 - Снять с торгов");
            System.out.println("Введите 5 - Отобразить инфо о товаре, введите 0 - Выйти из программы");

            int toDo = -1;

            try {
                toDo = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное числовое значение.");
                scanner.next();
                continue;
            }
            try{
                switch (toDo) {
                    case 0:
                        System.out.println("Выход из программы.");
                        JSONFileHandler.writeProducts(products);
                        scanner.close();
                        return;
                    case 1:
                            product.getProductState().startSale(product);
                        break;
                    case 2:
                            product.getProductState().raisePrice(product);
                            System.out.println("Успешно изменилась цена");
                        break;
                    case 3:
                            product.getProductState().giveToWinner(product);
                        break;
                    case 4:
                            product.getProductState().withDraw(product);
                        break;
                    case 5:
                            System.out.println(product.toString());
                        break;
                    default:
                        System.out.println("Ошибка: Неверное действие.");
                    }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
