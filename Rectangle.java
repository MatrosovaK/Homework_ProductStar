package org.example;

import java.util.Scanner;

public class Rectangle {

    public static void main(String[] args){
        System.out.println("Введите значение для длинной стороны прямоугольника: ");
        Scanner in = new Scanner(System.in);
        Double length = in.nextDouble();
        System.out.println("Введите значение для короткой стороны прямоугольника: ");
        Double width = in.nextDouble();
        Double area = length * width;
        System.out.println("Площадь прямоугольника равна " + area);

    }
}
