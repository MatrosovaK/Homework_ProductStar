package org.TravelPlanner;

public class TravelStrategyFactory {

    public TravelStrategy getTravelStrategy(final String method){
        switch(method){
            case ("train"):
                return new TrainStrategy();
            case ("airplane"):
                return new AirplaneStrategy();
            default:
                throw new IllegalArgumentException("Метод путешествия не определен");
        }
    }
}
