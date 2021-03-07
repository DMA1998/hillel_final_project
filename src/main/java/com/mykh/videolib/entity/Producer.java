package com.mykh.videolib.entity;

public class Producer {

    private String name;
    private String dateOfBirthday;

    public Producer() {
    }

    public Producer(String name, String dateOfBirthday) {
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
        return "Producer(" +
                "name - " + name +
                ", birthday - " + dateOfBirthday +
                ')';
    }
    public static void s() {

    }
}
