package com.mykh.videolib.service;

import com.mykh.videolib.entities.Actor;
import com.mykh.videolib.entities.Film;
import com.mykh.videolib.entities.Producer;
import com.mykh.videolib.utils.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.mykh.videolib.utils.ColumnConstants.*;

public class FilmService {

    public Film getFilm(ResultSet resultSet) throws SQLException {
        return new Film(resultSet.getString(FILM_NAME), resultSet.getString(FILM_RELEASE), resultSet.getString(FILM_COUNTRY));
    }

    public List<Actor> getActors(ResultSet resultSet) throws SQLException {
        List<Actor> result = new ArrayList<>();
        while (resultSet.next()) {
            Actor actor = new Actor(resultSet.getString(ACTOR_NAME), resultSet.getString(ACTOR_BIRTHDAY));
            result.add(actor);
        }
        return result;
    }

    public List<Film> appendActorsToFilm(List<Film> films, Connection connection) {
        for (Film film : films) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.FIND_ACTORS.getQuery())) {
                preparedStatement.setString(1, film.getName());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Actor> actors = getActors(resultSet);
                film.setActors(actors);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return films;
    }

    public List<Film> appendProducerToFilm(List<Film> films, Connection connection) {
        for (Film film : films) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.FIND_PRODUCER.getQuery());
                preparedStatement.setString(1, film.getName());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Producer producer = new Producer(resultSet.getString(PRODUCER_NAME), resultSet.getString(PRODUCER_BIRTHDAY));
                    film.setProducer(producer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return films;
    }

    public List<Film> uniqueFilms(List<Film> films) {
        Set<Film> temp = new HashSet<>(films);
        return new ArrayList<>(temp);
    }

}
