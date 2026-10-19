package org.NIOUsers;

import java.io.IOException;
import java.util.Scanner;

public class AddUserCommand implements MenuCommand{
    private final Scanner scanner;
    private final UserManager userManager;

    public AddUserCommand(Scanner scanner, UserManager userManager) {
        this.scanner = scanner;
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите город: ");
        String city = scanner.nextLine();

        try{
            userManager.addUser(new User(name, city));
            System.out.println("Пользователь сохранён!");
        }catch(IOException e){
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
