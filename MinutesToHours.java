package org.example;

import java.util.Scanner;

public class MinutesToHours {
    public static void main(String[] args) {
        System.out.println("Введите количество минут: ");
        Scanner in = new Scanner(System.in);
        int minutes = in.nextInt();
        int h = minutes / 60;
        int min = minutes % 60;
        System.out.println("Это равно " + h + " часов " + min + " минут");
        in.close();
    }
}
