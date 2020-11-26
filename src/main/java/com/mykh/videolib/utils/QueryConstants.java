package com.mykh.videolib.utils;

public class QueryConstants {

    public static final String FIND_ACTORS = "SELECT a.name as actor_name, a.birthday as actor_birthday  FROM films f " +
            " INNER JOIN films_has_actors fha ON f.id = fha.films_id " +
            " INNER JOIN actors a ON fha.actors_id = a.id AND fha.films_id = f.id " +
            " WHERE f.name LIKE ?";

    public static final String FIND_PRODUCER = "SELECT p.name as producer_name,p.birthday as producer_birthday FROM films f " +
            " INNER JOIN producers p ON p.id = f.producers_id " +
            " WHERE f.name LIKE ? ";

    public static final String FIND_FILMS_BY_CURRENT_PREVIOUS_YEAR = "SELECT f.name,f.release,f.country,p.name as producer_name, " +
            " p.birthday as producer_birthday,a.name as actor_name,a.birthday as actor_birthday FROM films f " +
            " INNER JOIN producers p ON f.producers_id = p.id " +
            " INNER JOIN films_has_actors fhs " +
            " INNER JOIN actors a ON fhs.actors_id = a.id AND fhs.films_id = f.id " +
             "WHERE f.release >= ? ";

    public static final String SEARCH_ACTORS_BY_PARTICULAR_FILM =
            "SELECT a.name as actor_name,a.birthday as actor_birthday FROM films f" +
                    " INNER JOIN films_has_actors fha" +
                    " INNER JOIN actors a" +
                    " ON" +
                    " fha.films_id = f.id" +
                    " AND" +
                    " fha.actors_id = a.id" +
                    " where f.name LIKE ? ";

    public static final String SEARCH_ACTORS_BY_MANY_FILMS =
            "SELECT a.name as actor_name,a.birthday as actor_birthday FROM films f " +
                    " INNER JOIN films_has_actors fha " +
                    " INNER JOIN actors a " +
                    " ON " +
                    " fha.films_id = f.id " +
                    " AND " +
                    " fha.actors_id = a.id " +
                    " GROUP BY a.name " +
                    " HAVING COUNT(actors_id) > ? ";

    public static final String SEARCH_ACTORS_LIKE_PRODUCERS =
            "SELECT a.name as actor_name,a.birthday as actor_birthday FROM actors a " +
                    " INNER JOIN producers p " +
                    " ON a.name = p.name " +
                    " AND " +
                    " a.birthday = p.birthday ";

    public static final String DELETE_FILM_BY_YEAR = " DELETE FROM films f " +
            " WHERE f.release >= ?; ";

    public static final String FIND_USERS_IN_DATABASE = " SELECT u.login,u.password from users u ";
}
