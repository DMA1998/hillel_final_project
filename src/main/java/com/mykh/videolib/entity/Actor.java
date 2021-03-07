package com.mykh.videolib.entity;

public class Actor {

    private String name;
    private String dateOfBirthday;

    public Actor() {
    }

    public Actor(String name, String dateOfBirthday) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    @Override
    public String toString() {
        return
                "Actor(name - " + name +
                ", actor birthday - " + dateOfBirthday + ")";
    }
}
