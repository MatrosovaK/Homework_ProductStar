import java.util.Arrays;

public class DeleteSpacesAndLetters {
    public static void main(String[] args) {
        deleteSpacesAndLetters();
    }

    public static void deleteSpacesAndLetters(){
        String str = "Домашнее задание\n" +
                "\n" +
                "В тексте, который вы видите на этом изображении, посчитайте количество букв ‘е’ в каждом слове\n" +
                "\n" +
                "Напишите регулярное выражение для проверки телефона в международном формате \n" +
                "\n" +
                "С помощью регулярного выражения напишите функцию удаления всех букв и пробелов из текста\n";

        String temp = str.replaceAll("[\n, :-[а-яА-Я]]", "");

        System.out.println(temp);

    }



}


