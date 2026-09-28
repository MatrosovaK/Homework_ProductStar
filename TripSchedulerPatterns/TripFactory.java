package org.TripSchedulerPatterns;

public class TripFactory {

    public Trip createTrip(String type, Trip.Builder builder){

        if("business".equalsIgnoreCase(type)){
            return new BusinessTrip(builder);
        }

        if("tourist".equalsIgnoreCase(type)){
            return new TouristTrip(builder);
        }

        if("educational".equalsIgnoreCase(type)){
            return new EducationalTrip(builder);
        }

        throw new IllegalArgumentException("Неизвестный тип поездки: " + type);
    }
}
