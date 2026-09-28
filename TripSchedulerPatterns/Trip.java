package org.TripSchedulerPatterns;

import java.util.List;

public class Trip {
    private String destination;
    private String startingPoint;
    private int duration;
    private List<String> participants;
    private boolean hotel;
    private String status = "Запланирована";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getDestination() {
        return destination;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public boolean isHotel() {
        return hotel;
    }

    protected Trip(final Builder builder) {
        this.destination = builder.destination;
        this.startingPoint = builder.startingPoint;
        this.duration = builder.duration;
        this.participants = builder.participants;
        this.hotel = builder.hotel;

    }

    public static class Builder{
        private String destination;
        private String startingPoint;
        private int duration;
        private List<String> participants;
        private boolean hotel;


        public Builder destination(String value){
            this.destination = value;
            return this;
        }

        public Builder startingPoint(String value){
            this.startingPoint = value;
            return this;
        }

        public Builder duration(int value) {
            this.duration = value;
            return this;
        }

        public Builder participants(List<String> value) {
            this.participants = value;
            return this;
        }

        public Builder hotel(Boolean value){
            this.hotel = value;
            return this;
        }


        public Trip build(){
            return new Trip(this);
        }
    }




}
