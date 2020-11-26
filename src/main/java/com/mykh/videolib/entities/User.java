package com.mykh.videolib.entities;

public class User {

    private String login;
    private int password;

    public User(String login, int password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User:" + "login - " + login + ", password - " + password;
    }
}
