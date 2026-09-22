package org.TripScheduleSerialization;

import java.io.Serializable;

public class StartingPoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String country;
    private String city;



    public StartingPoint() {
    }

    public StartingPoint(String country, String city) {
        this.country = country;
        this.city = city;

    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }




    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }



    @Override
    public String toString() {
        return "Поездка в " + country + "( " + city + ") ";
    }
}
