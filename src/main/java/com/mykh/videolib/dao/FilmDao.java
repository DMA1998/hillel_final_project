package com.mykh.videolib.dao;

import com.mykh.videolib.entity.Actor;
import com.mykh.videolib.entity.Film;
import com.mykh.videolib.service.FilmService;
import com.mykh.videolib.utils.SqlQuery;

import java.sql.*;
import java.util.*;

import static com.mykh.videolib.connection.ConnectionPool.*;

public class FilmDao implements IFilmDao {

    private static final FilmService filmService = new FilmService();

    @Override
    public List<Film> findFilmsByCurrentAndPreviousYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int previousYear = currentYear - 1;
        List<Film> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.FIND_FILMS_BY_CURRENT_PREVIOUS_YEAR.getQuery());
            statement.setInt(1, previousYear);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = filmService.getFilm(resultSet);
                result.add(film);
                filmService.appendProducerToFilm(result, connection);
                filmService.appendActorsToFilm(result, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmService.close(connection, statement, resultSet);
        return filmService.uniqueFilms(result);
    }

    @Override
    public List<Actor> findActorsInParticularFilm(String film) {
        List<Actor> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.SEARCH_ACTORS_BY_PARTICULAR_FILM.getQuery());
            statement.setString(1, film);
            resultSet = statement.executeQuery();
            result = filmService.getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmService.close(connection, statement, resultSet);
        return result;
    }

    @Override
    public List<Actor> findActorsByManyFilms(int filmsQuantity) {
        List<Actor> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.SEARCH_ACTORS_BY_MANY_FILMS.getQuery());
            statement.setInt(1, filmsQuantity);
            resultSet = statement.executeQuery();
            result = filmService.getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmService.close(connection, statement, resultSet);
        return result;
    }

    @Override
    public List<Actor> findActorsLikeProducers() {
        List<Actor> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.SEARCH_ACTORS_LIKE_PRODUCERS.getQuery());
            resultSet = statement.executeQuery();
            result = filmService.getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmService.close(connection, statement, resultSet);
        return result;
    }

    @Override
    public int removeFilmsByYear(int year) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.DELETE_FILM_BY_YEAR.getQuery());
            statement.setInt(1, year);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmService.close(connection, statement);
        return year;
    }
}
