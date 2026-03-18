package org.example;

import java.util.Scanner;

public class Temperature {

    public static void main(String[] args){
        System.out.println("Введите температуру в градусах Цельсия: ");
        Scanner in = new Scanner(System.in);
        double temperatureC = in.nextDouble();
        double temperatureF = temperatureC * 9 / 5 + 32;
        System.out.println("Температура в градусах Фаренгейта:" + temperatureF);
        in.close();
    }
}
