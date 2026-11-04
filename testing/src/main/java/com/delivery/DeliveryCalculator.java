package com.delivery;

public class DeliveryCalculator {

    public double calculateDeliveryCost(
            double distance,
            String size,
            boolean fragile,
            String workload) {

        double additionalCost;

        if (distance > 30) {
            additionalCost = 300;
        } else if (distance > 10) {
            additionalCost = 200;
        } else if (distance > 2) {
            additionalCost = 100;
        } else {
            additionalCost = 50;
        }

        if (size.equals("large")) {
            additionalCost += 200;
        } else if (size.equals("small")) {
            additionalCost += 100;
        } else {
            throw new IllegalArgumentException("Invalid size");
        }
        if (fragile && distance > 30) {
            throw new IllegalArgumentException("Хрупкий груз нельзя доставлять на расстояние более 30 км");
        }

        if (fragile) {
            additionalCost += 300;
        }

        double workloadCoefficient;

        if (workload.equals("very_high")) {
            workloadCoefficient = 1.6;
        } else if (workload.equals("high")) {
            workloadCoefficient = 1.4;
        } else if (workload.equals("elevated")) {
            workloadCoefficient = 1.2;
        } else if (workload.equals("normal")) {
            workloadCoefficient = 1.0;
        } else {
            throw new IllegalArgumentException("Invalid load");
        }

        additionalCost *= workloadCoefficient;

        return Math.max(additionalCost, 400);
    }
}
