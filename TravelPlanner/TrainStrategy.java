package org.TravelPlanner;

public class TrainStrategy implements TravelStrategy{
    @Override
    public String travelPlan(String from, String to) {
        return String.format("Поездом из %s в %s", from, to);
    }
}
