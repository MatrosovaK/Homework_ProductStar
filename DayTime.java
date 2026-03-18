package org.example;

import java.util.Scanner;

public class DayTime {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int hour;

        while (true) {
            System.out.println("Введите час (0-23):");
            hour = in.nextInt();
            if (hour >= 0 && hour <= 23) {
                break;
            } else {
                System.out.println("Введите корректный запрос ");

            }
        }

        if (hour >= 6 && hour <= 11){
            System.out.println("Сейчас  утро");
        } else if (hour >= 12 && hour <= 17) {
            System.out.println("Сейчас  день");
        } else if (hour >= 18 && hour <= 21) {
            System.out.println("Сейчас  вечер");
        } else {
            System.out.println("Сейчас ночь");
        }
        in.close();
    }
}
