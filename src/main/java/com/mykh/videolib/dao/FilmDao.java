package com.mykh.videolib.dao;

import com.mykh.videolib.entities.Actor;
import com.mykh.videolib.entities.Film;
import com.mykh.videolib.entities.Producer;

import java.sql.*;
import java.util.*;

import static com.mykh.videolib.utils.QueryConstants.*;
import static com.mykh.videolib.utils.ColumnConstants.*;
import static com.mykh.videolib.connection.ConnectionPool.*;

public class FilmDao implements IFilmDao {

    @Override
    public List<Actor> findActorsInParticularFilm(String film) {
        List<Actor> result = new ArrayList<>();
        String sqlQuery = SEARCH_ACTORS_BY_PARTICULAR_FILM;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, film);
            resultSet = statement.executeQuery();
            result = getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,statement,resultSet);
        return result;
    }

    @Override
    public List<Actor> findActorsByManyFilms(int filmsQuantity) {
        List<Actor> result = new ArrayList<>();
        String sqlQuery = SEARCH_ACTORS_BY_MANY_FILMS;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, filmsQuantity);
            resultSet = statement.executeQuery();
            result = getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,statement,resultSet);
        return result;
    }

    @Override
    public List<Actor> findActorsLikeProducers() {
        List<Actor> result = new ArrayList<>();
        String sqlQuery = SEARCH_ACTORS_LIKE_PRODUCERS;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            result = getActors(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,statement,resultSet);
        return result;
    }

    @Override
    public List<Film> findFilmsByCurrentAndPreviousYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int previousYear = currentYear - 1;
        List<Film> result = new ArrayList<>();
        String sqlQuery = FIND_FILMS_BY_CURRENT_PREVIOUS_YEAR;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, previousYear);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = getFilm(resultSet);
                result.add(film);
                appendProducerToFilm(result, connection);
                appendActorsToFilm(result, connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,statement,resultSet);
        return uniqueFilms(result);
    }

    @Override
    public int removeFilmsByYear(int year) {
        String sqlQuery = DELETE_FILM_BY_YEAR;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, year);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(connection,statement);
        return year;
    }

    private List<Film> appendActorsToFilm(List<Film> films, Connection connection) {
        String sqlQuery = FIND_ACTORS;
        for (Film film : films) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
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

    private List<Film> appendProducerToFilm(List<Film> films, Connection connection) {
        String sqlQuery = FIND_PRODUCER;
        for (Film film : films) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
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

    private Film getFilm(ResultSet resultSet) throws SQLException {
        Film film = new Film(resultSet.getString(FILM_NAME), resultSet.getString(FILM_RELEASE), resultSet.getString(FILM_COUNTRY));
        return film;
    }

    private List<Actor> getActors(ResultSet resultSet) throws SQLException {
        List<Actor> result = new ArrayList<>();
        while (resultSet.next()) {
            Actor actor = new Actor(resultSet.getString(ACTOR_NAME), resultSet.getString(ACTOR_BIRTHDAY));
            result.add(actor);
        }
        return result;
    }

    private List<Film> uniqueFilms(List<Film> films) {
        Set<Film> temp = new HashSet<>(films);
        List<Film> result = new ArrayList<>(temp);
        return result;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection connection, Statement statement) {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
