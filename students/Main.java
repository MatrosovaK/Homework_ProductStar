package org.students;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();
    public static void main(String[] args) {


        while(true){
            printMessage();
            Command command = readCommand();
            if(command.getAction() == Action.EXIT){
                return;
            }else if (command.getAction() == Action.ERROR){
                continue;
            } else {

                STUDENT_COMMAND_HANDLER.processCommand(command);
            }




        }
    }

    private static Command readCommand(){
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if (action.isRequireAdditionalData()) {
                String data = scanner.nextLine();
                return new Command(action, data);

            } else {
                return new Command(action);
            }
        } catch(Exception ex){
            System.out.println("Проблема обработки ввода " + ex.getMessage());
            return new Command(Action.ERROR);



        }
    }


    private static void printMessage(){
        System.out.println("--------------------------");
        System.out.println("0 - Выход");
        System.out.println("1 - Создание данных (Введите Фамилию,Имя,Курс,Город,возраст)");
        System.out.println("2 - Обновление данных(Введите id,Фамилию,Имя,Курс,Город,возраст)");
        System.out.println("3 - Удаление данных(Введите id)");
        System.out.println("4 - Вывод статистики по курсам(Введите интересующий вас курс)");
        System.out.println("5 - Вывод статистики по городам(Введите интересующий вас город)");
        System.out.println("6 - Поиск по фамилии(пустая строка - вывод всех студентов, одна фамилия - поиск конктерного студента, две фамилии - поиск промежуточных фамилий");
        System.out.println("--------------------------");



    }


}