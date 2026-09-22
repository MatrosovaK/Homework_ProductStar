package org.TripScheduleSerialization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    @JsonIgnore
    private transient String passportNumber;
    private int age;
    private String eMail;


    public User(){}

    public User(String fullName, String passportNumber, int age, String eMail) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.age = age;
        this.eMail = eMail;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    }

