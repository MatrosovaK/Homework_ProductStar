package org.AdventurerInventory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InventoryManagement management = new InventoryManagement();

        System.out.println("\n" + "Добро пожаловать в Инвентарь приключенца!");
        Scanner in = new Scanner(System.in);

        int input = 0;
        while(input != 6) {

            System.out.println("Выберите действие: \n" +
                    "1 - Добавить новый предмет\n" +
                    "2 - Изменить количество предметов\n" +
                    "3 - Удалить предмет\n" +
                    "4 - Найти предмет по названию\n" +
                    "5 - Показать весь инвентарь\n" +
                    "6 - Выход");

            if (in.hasNextInt()) {
                input = in.nextInt();
                in.nextLine();
            } else {
                System.out.println("Ошибка ввода. Введите число от 1 до 6. ");
                in.nextLine();
                continue;
            }

            if (input == 1) {
                System.out.println("Введите название предмета: ");
                String itemName = in.nextLine();


                if (management.containsItem(itemName)) {
                    System.out.println("Предмет уже добавлен в инвентарь");
                    boolean correctChoice = false;
                    while (!correctChoice) {
                        System.out.println("Выберите действие: 1 - увеличить количество\n" +
                                "2 - уменьшить количество");
                        int choice = in.nextInt();
                        in.nextLine();

                        if (choice != 1 && choice != 2) {
                            System.out.println("Некорректное значение. Введите 1 или 2: ");
                            correctChoice = false;
                        } else if (choice == 1) {
                            System.out.println("Введите количество: ");
                            int itemQuantity = in.nextInt();
                            in.nextLine();

                            if (management.increaseQuantity(itemName, itemQuantity)) {
                                System.out.println("Количество \"" + itemName + "\" увеличено.");
                                correctChoice = true;
                            } else {
                                System.out.println("Количество должно быть больше нуля. Количество \"" + itemName + "\" не было увеличено.");
                            }
                        } else {
                            System.out.println("Введите количество: ");
                            int itemQuantity = in.nextInt();
                            in.nextLine();

                            if (management.decreaseQuantity(itemName, itemQuantity)) {

                                if (!management.containsItem(itemName)) {
                                    System.out.println("Введенное значение больше или равно значению в инвентаре.");
                                    System.out.println("Предмет \"" + itemName + "\" удален из инвентаря.");
                                } else {
                                    System.out.println("Количество \"" + itemName + "\" уменьшено.");
                                }
                                correctChoice = true;
                            } else {
                                System.out.println("Количество должно быть больше нуля. Количество \"" + itemName + "\" не было уменьшено.");
                            }
                        }


                    }
                } else {
                    System.out.println("Введите количество: ");
                    int itemQuantity = in.nextInt();
                    in.nextLine();

                    if (management.addItem(itemName, itemQuantity)) {
                        System.out.println("Предмет \"" + itemName + "\" успешно добавлен.");
                    } else {
                        System.out.println("Количество должно быть больше нуля. Предмет \"" + itemName + "\" не добавлен.");

                    }
                }
            } else if (input == 2) {
                System.out.println("Изменение количества предметов:\n" + "Введите название предмета.");
                String itemName = in.nextLine();

                if(management.containsItem(itemName)){
                    System.out.println("Введите новое количество: ");
                    int itemQuantity = in.nextInt();
                    in.nextLine();
                    if(management.changeQuantity(itemName, itemQuantity)){

                        if(management.containsItem(itemName)){
                            System.out.println("Количество для  \"" + itemName + "\" обновлено.");
                        } else{
                            System.out.println("Введенное значение равно нулю.");
                            System.out.println("Предмет \"" + itemName + "\" удален из инвентаря.");
                        }

                    } else {
                        System.out.println("Ошибка. Введенное значение меньше нуля. ");
                    }
                } else{
                    System.out.println("Предмет \"" + itemName + "\" не найден в инвентаре.");
                }
            } else if (input == 3) {
                System.out.println("Введите название предмета для удаления");
                String itemName = in.nextLine();

                if(management.removeItem(itemName)){
                    System.out.println("Предмет  \"" + itemName + "\" удален.");
                } else{
                   System.out.println("Ошибка. Предмет  \"" + itemName + "\" не найден в инвентаре");
                }

            } else if (input == 4) {
                System.out.println("Поиск предмета по названию:\n" + "Введите название предмета.");
                String itemName = in.nextLine();
                if(management.containsItem(itemName)){
                    System.out.println("Количество  \"" + itemName + ": " + management.searchForItem(itemName));
                } else{
                    System.out.println("Предмет  \"" + itemName + "\" не найден в инвентаре");

                }

            } else if (input == 5) {
                System.out.println("Текущий инвентарь:" + management.getAllItems());

            } else if (input == 6) {
                System.out.println("Завершение программы");
            } else {
                System.out.println("Введите корректное значение.");
            }
        }
        in.close();



    }
}
