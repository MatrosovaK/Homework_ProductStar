package org.TripSchedulerPatterns;

import java.util.ArrayList;
import java.util.List;

public class TripManager {
    private static TripManager instance;
    private List<Trip> trips;
    private List<TripObserver> observers= new ArrayList<>();

    private TripManager() {
        trips = new ArrayList<>();
    }

    public static TripManager getInstance() {
        if (instance == null) {
            instance = new TripManager();
        }
        return instance;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    public List<Trip> getTrips(){
        return trips;
    }

    public void addObserver(TripObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(Trip trip){
        for(TripObserver observer: observers){
            observer.update(trip);
        }
    }

    public void changeStatus(Trip trip, String newStatus){
        trip.setStatus(newStatus);
        notifyObservers(trip);
    }


}



