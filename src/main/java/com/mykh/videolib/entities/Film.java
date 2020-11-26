package com.mykh.videolib.entities;

import java.util.List;
import java.util.Objects;

public class Film {

    private String name;
    private String filmRelease;
    private String country;
    private Producer producer;
    private List<Actor> actors;

    public Film() {
    }

    public Film(String name, String filmRelease, String country) {
        this.name = name;
        this.filmRelease = filmRelease;
        this.country = country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmRelease() {
        return filmRelease;
    }

    public void setFilmRelease(String filmRelease) {
        this.filmRelease = filmRelease;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return name.equals(film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "\nFilm :\n" +
                "film name - " + name +
                "\nfilm release - " + filmRelease  +
                "\n film country - " + country  +
                "\n film producer - " + producer +
                "\n film actors: " + actors +
                '}';
    }
}
