package elmir.kg;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Action {
    public static void startProgramm(){
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

            switch (toDo) {
                case 0:
                    System.out.println("Выход из программы.");
                    JSONFileHandler.writeProducts(products);
                    scanner.close();
                    return;
                case 1:
                    try {
                        product.getProductState().startSale(product);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        product.getProductState().raisePrice(product);
                        JSONFileHandler.writeProducts(products);
                        System.out.println("Успешно изменилась цена");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        CodeGenerator generator = new CodeGenerator();
                        if (product.getPrice() >= 1000){
                            generator.makeCode("GOLD-" + product.getId());
                        }else if (product.getPrice()>500 && product.getPrice()<1000) {
                            generator.makeCode("Silver-" + product.getId());
                        }else {
                            generator.makeCode("Bronze-" + product.getId());
                        }
                        product.getProductState().giveToWinner(product);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try {
                        product.getProductState().withDraw(product);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    try {
                        System.out.println(product.toString());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Ошибка: Неверное действие.");
            }
            JSONFileHandler.writeProducts(products);
        }
    }
}
