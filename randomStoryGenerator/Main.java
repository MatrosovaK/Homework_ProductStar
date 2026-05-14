package org.randomStoryGenerator;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StoryData data = new StoryData();

        data.addCharacter("Гном");
        data.addCharacter("Принцесса");
        data.addCharacter("Робот");
        data.addCharacter("Космонавт");

        data.addAction("летает");
        data.addAction("танцует");
        data.addAction("сражается");
        data.addAction("поёт");

        data.addPlace("в лесу");
        data.addPlace("на цветочной поляне");
        data.addPlace("в космосе");
        data.addPlace("в землянке");

        System.out.println("\n" + "Добро пожаловать в Генератор случайных историй!\n" + "Количество доступных персонажей: " + data.getCharactersQuantity() +
                ". Количество доступных действий: " + data.getActionsQuantity() +
                ". Количество доступных мест: " + data.getPlacesQuantity());



        Scanner in = new Scanner(System. in);
        StorySaver saver = new StorySaver();
        StoryGenerator generator = new StoryGenerator(data);

        int input = 0;
        while(input != 6) {

        System.out.println("Выберите пункт меню: \n"+
                "1 - Добавить персонажа\n" +
                "2 - Добавить действие\n" +
                "3 - Добавить место\n" +
                "4 - Сгенерировать историю\n" +
                "5 - Посмотреть все истории\n" +
                "6 - Выход");

            if(in.hasNextInt()) {
                input = in.nextInt();
                in.nextLine();
            } else {
                System.out.println("Ошибка: введите число от 1 до 6. ");
                in.nextLine();
                continue;
            }



            if (input == 1) {
                System.out.println("Введите персонажа: ");
                String newCharacter = in.nextLine();
                data.addCharacter(newCharacter);

            } else if (input == 2) {
                System.out.println("Введите действие: ");
                String newAction = in.nextLine();
                data.addAction(newAction);

            } else if (input == 3) {
                System.out.println("Введите место : ");
                String newPlace = in.nextLine();
                data.addPlace(newPlace);

            } else if (input == 4) {

                String newStory = generator.generateRandomStory();
                System.out.println("Сгенерированная история: " + newStory);


                saver.saveStory(newStory);

            } else if (input == 5) {
                System.out.println("Список историй: " + saver.getListOfStories());
            } else if(input == 6){
                System.out.println("Завершение программы");

            } else{
                System.out.println("Введите корректное значение");
            }


        }
        in.close();



    }
}