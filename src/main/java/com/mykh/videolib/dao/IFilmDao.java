package com.mykh.videolib.dao;

import com.mykh.videolib.entities.Actor;
import com.mykh.videolib.entities.Film;

import java.util.List;

public interface IFilmDao {

    List<Film> findFilmsByCurrentAndPreviousYear();

    List<Actor> findActorsInParticularFilm(String film);

    List<Actor> findActorsByManyFilms(int filmsQuantity);

    List<Actor> findActorsLikeProducers();

    int removeFilmsByYear(int year);


}
