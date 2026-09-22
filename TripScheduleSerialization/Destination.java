package org.TripScheduleSerialization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Destination implements Serializable {
    private static final long serialVersionUID = 1L;

    private String country;
    private String city;
    @JsonIgnore
    private transient String address;

    public Destination() {
    }

    public Destination(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public String getCountry() {
        return country;
    }


    public String getCity() {
        return city;
    }


    public String getAddress() {
        return address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Поездка в " + country + "( " + city + ") ";
    }
}
