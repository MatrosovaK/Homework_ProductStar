package org.Circle;

import org.junit.jupiter.api.Assertions;

class CircleTest {

    @org.junit.jupiter.api.Test
    void constructorSetsRadiusCorrectly(){
        Circle circle = new Circle(5);
        Assertions.assertEquals(5.0, circle.getRadius());
    }

    @org.junit.jupiter.api.Test
    void constructorThrowsExceptionCorrectly(){
        Circle circle = new Circle(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Circle(-5);
        });

    }


    @org.junit.jupiter.api.Test
    void constructorThrowsExceptionCorrectly2(){
        //используя try-catch
        try {
            new Circle(-5);
            Assertions.fail("тут должно быть исключение");
        } catch (IllegalArgumentException exception){
            Assertions.assertEquals("Радиус должен быть больше нуля", exception.getMessage());
        }


    }


    @org.junit.jupiter.api.Test
    void setterThrowsException() {

        Circle circle = new Circle(5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {circle.setRadius(-5);
        });
        circle.setRadius(5);
        Assertions.assertEquals(5, circle.getRadius());

    }

    @org.junit.jupiter.api.Test
    void setterUpdatesRadiusCorrectly() {
        Circle circle = new Circle(5);
        circle.setRadius(2);
        Assertions.assertEquals(2.0, circle.getRadius());
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        Circle circle = new Circle(5);

        Assertions.assertEquals(Math.PI * 5 * 5, circle.getArea(), 0.0001);
    }
}