package org.TripScheduleSerialization;

import java.io.*;


public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private User tripForUser;
    private StartingPoint startingPoint;
    private Destination destination;
    private String transportType;

    public Trip() {
    }

    public Trip(int id, User tripForUser, StartingPoint startingPoint, Destination destination, String transportType) {
        this.id = id;
        this.tripForUser = tripForUser;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.transportType = transportType;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        System.out.println("Сериализация трип");
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Десериализация трип");
        in.defaultReadObject();
    }

    public User getTripForUser() {
        return tripForUser;
    }

    public void setTripForUser(User tripForUser) {
        this.tripForUser = tripForUser;
    }

    public StartingPoint getStartingPoint() {
        return startingPoint;
    }


    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartingPoint(StartingPoint startingPoint) {
        this.startingPoint = startingPoint;
    }

    @Override
    public String toString() {
        return "Поездка No " + id +
                ": Пользователь: " + tripForUser +
                ", из " + startingPoint + '\'' +
                ", в " + destination +
                ", (" + transportType + ")";
    }
}
