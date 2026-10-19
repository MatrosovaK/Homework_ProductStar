package org.NIOUsers;

import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        Map<Integer, MenuCommand> commands = Map.of(1, new AddUserCommand(scanner, userManager),
                2, new ShowUsersCommand(userManager));

        while(true){
            System.out.println("Выберите действие: " +
                    "\n1 — Добавить пользователя" +
                    "\n2 — Показать список пользователей" +
                    "\n3 — Выход");
            if(!scanner.hasNextInt()){
                System.out.println("Введите число!");
                scanner.nextLine();
                continue;
            }
            int num = scanner.nextInt();
            scanner.nextLine();

            if(num == 3){
                System.out.println("Выход");
                break;
            }

            MenuCommand command = commands.get(num);
            if(command != null){
                command.execute();
            }else{
                System.out.println("Ошибка.нужно число от 1 до 3");
            }
        }


    }
}