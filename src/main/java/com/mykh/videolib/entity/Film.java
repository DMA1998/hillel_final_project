package com.mykh.videolib.entity;

import java.util.List;
import java.util.Objects;

public class Film {

    private String name;
    private String releaseDate;
    private String countryOfOrigin;
    private Producer producer;
    private List<Actor> actors;

    public Film() {
    }

    public Film(String name, String releaseDate, String countryOfOrigin) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
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
                "\nfilm release - " + releaseDate +
                "\n film country - " + countryOfOrigin +
                "\n film producer - " + producer +
                "\n film actors: " + actors +
                '}';
    }
}
