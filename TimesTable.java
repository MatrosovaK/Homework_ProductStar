package org.example;

import java.util.Scanner;

public class TimesTable {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Введите число от 1 до 9: ");
            number = in.nextInt();
            if (number >= 1 && number <= 9) {
                break;
            } else {
                System.out.println("Ошибка. Введите корректное число");
            }
        }
            for(int i = 1; i <= 10; i++){
                int result = i * number;
                System.out.println(number + "*" + i + " = " + result);
            }
        in.close();
        }



}
