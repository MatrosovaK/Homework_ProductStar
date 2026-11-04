package com.delivery;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeliveryCalculatorTest {

    @Test
    @Tag("basic")
    //минимальная стоимость = 400
    void shouldReturnMinimumCost() {
        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                5, "small", false, "normal");

        assertEquals(400, result, 0.001);
    }

    @Test
    @Tag("basic")
        //расстояние 10-30км
    void shouldCalculateCostForDistanceFrom10To30Km() {
        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                15, "large", false, "high");

        assertEquals(560, result, 0.001);
    }

    @Test
    @Tag("basic")
        //расстояние до 2 км
   void shouldCalculateCostForDistanceUpTo2Km(){
       DeliveryCalculator calculator = new DeliveryCalculator();

       double result = calculator.calculateDeliveryCost(
               1.5, "large", true, "very_high");

       assertEquals(880, result, 0.001);
   }

    @Test
    @Tag("basic")
        //расстояние 2-10км
    void shouldCalculateCostForDistanceFrom2To10Km(){
        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                5, "small", false, "normal");

        assertEquals(400, result, 0.001);
    }

    @Test
    @Tag("basic")
        //расстояние больше 30км
    void shouldCalculateCostForDistanceOver30Km(){
        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                35, "small", false, "normal");

        assertEquals(400, result, 0.001);
    }


    //Проверяем параметры загруженности
    @ParameterizedTest
    @Tag("basic")
    @CsvSource({
            "very_high, 640",
            "high, 560",
            "elevated, 480",
            "normal, 400"
    })
    void shouldApplyCorrectLoadCoefficient(String load, double expected) {

        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                15, "large", false, load);

        assertEquals(expected, result, 0.001);
    }

    //проверяем хрупкий груз на расстоянии более 30 км
    @Test
    @Tag("error")
    void shouldThrowExceptionForFragileCargoOver30Km() {

        DeliveryCalculator calculator = new DeliveryCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDeliveryCost(
                    35, "small", true, "normal");
        });
    }

    //Хрупкий груз на расстоянии до 30 км
    @Test
    @Tag("basic")
    //расстояние больше 30км
    void shouldCalculateCostForFragileCargoWithin30Km(){
        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                15, "small", true, "normal");

        assertEquals(600, result, 0.001);
    }

    //Проверяем граничные значения расстояния
    @ParameterizedTest
    @Tag("edge")
    @CsvSource({
            "0.0, 400",
            "2.0, 400",
            "10.0, 400",
            "30.0, 400",
            "30.1, 500"
    })
    void shouldCalculateCostAtDistanceBoundaries(
            double distance, double expected) {

        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                distance, "large", false, "normal");

        assertEquals(expected, result, 0.001);
    }

    //Проверяем габариты small и large
    @ParameterizedTest
    @Tag("basic")
    @CsvSource({
            "small, 420",
            "large, 560"
    })
    void shouldCalculateCostForDifferentCargoSizes(
            String size, double expected) {

        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                15, size, false, "high");

        assertEquals(expected, result, 0.001);
    }
//Проверяем некорректные габариты
    @Test
    @Tag("error")
    void shouldThrowExceptionForInvalidCargoSize() {

        DeliveryCalculator calculator = new DeliveryCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDeliveryCost(
                    15, "medium", false, "normal");
        });
    }

    @Test
    @Tag("error")
    void shouldThrowExceptionForInvalidLoad() {

        DeliveryCalculator calculator = new DeliveryCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDeliveryCost(
                    15, "small", false, "medium");
        });
    }
//хрупкий груз ровно на 30 км
    @Test
    @Tag("edge")
    void shouldAllowFragileCargoAt30Km() {

        DeliveryCalculator calculator = new DeliveryCalculator();

        double result = calculator.calculateDeliveryCost(
                30, "small", true, "normal");

        assertEquals(600, result, 0.001);
    }


}