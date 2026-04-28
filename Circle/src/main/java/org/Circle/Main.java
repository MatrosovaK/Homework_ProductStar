package org.Circle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(1.5);

        System.out.println("Радиус v1. равен: " + circle.getRadius());
        System.out.printf("Площадь v1. равна: %.2f%n", circle.getArea());

        circle.setRadius(2);
        System.out.println("Радиус v2. равен: " + circle.getRadius());
        System.out.printf("Площадь v2. равна: %.2f%n", circle.getArea());

        circle.setRadius(-2);
        System.out.println("Радиус v3. равен: " + circle.getRadius());


    }
}