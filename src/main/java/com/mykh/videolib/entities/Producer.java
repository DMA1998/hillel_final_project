package com.mykh.videolib.entities;

public class Producer {

    private String name;
    private String date;

    public Producer() {
    }

    public Producer(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Producer(" +
                "name - " + name +
                ", birthday - " + date +
                ')';
    }
    public static void s() {

    }
}
