package org.TravelPlanner;

public class AirplaneStrategy implements TravelStrategy{
    @Override
    public String travelPlan(String from, String to) {
        return String.format("Самолетом из %s в %s", from, to);
    }
}
