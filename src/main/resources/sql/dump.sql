use video_lib;

#create table actors

CREATE TABLE `actors`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `name`     varchar(45) DEFAULT NULL,
    `birthday` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

#insert values into actors

INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('1', 'Jennifer Lawrence', '15.08.1990');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('2', 'Channing Tatum', '26.04.1980');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('3', 'Johnny Depp', '09.06.1963');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('4', 'Jared Leto', '26.12.1971');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('5', 'Ryan Reynolds', '23.10.1976');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('6', 'Scarlett Johansson', '22.11.1984');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('7', 'Will Smith', '25.09.1968');
INSERT INTO `actors` (`id`, `name`, `birthday`)
VALUES ('8', 'Ben Affleck', '15.08.1972');

#create table producers

CREATE TABLE `producers`
(
    `id`       int         NOT NULL AUTO_INCREMENT,
    `name`     varchar(45) NOT NULL,
    `birthday` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

#insert values into producers

INSERT INTO `producers` (`id`, `name`, `birthday`)
VALUES ('1', 'Quentin Tarantino', '27.03.1963');
INSERT INTO `producers` (`id`, `name`, `birthday`)
VALUES ('2', 'Johnny Depp', '09.06.1963');
INSERT INTO `producers` (`id`, `name`, `birthday`)
VALUES ('3', 'Christopher Nolan', '30.07.1970');
INSERT INTO `producers` (`id`, `name`, `birthday`)
VALUES ('4', 'Will Smith', '25.09.1968');


#create table films

CREATE TABLE `films`
(
    `id`           int         NOT NULL AUTO_INCREMENT,
    `name`         varchar(45) NOT NULL,
    `release`      varchar(45) NOT NULL,
    `country`      varchar(45) NOT NULL,
    `producers_id` int         NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_films_producers1_idx` (`producers_id`),
    CONSTRAINT `fk_films_producers1` FOREIGN KEY (`producers_id`) REFERENCES `producers` (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

#insert values into films

INSERT INTO `films` (`id`, `name`, `release`, `country`, `producers_id`)
VALUES ('1', 'Reservoir Dogs', '1992', 'USA', '1');
INSERT INTO `films` (`id`, `name`, `release`, `country`, `producers_id`)
VALUES ('2', 'Dunkirk', '2017', 'France', '2');
INSERT INTO `films` (`id`, `name`, `release`, `country`, `producers_id`)
VALUES ('3', 'Spenser Confidential', '2020', 'USA', '3');
INSERT INTO `films` (`id`, `name`, `release`, `country`, `producers_id`)
VALUES ('4', 'Gemini Man', '2019', 'USA', '4');
INSERT INTO `films` (`id`, `name`, `release`, `country`, `producers_id`)
VALUES ('5', 'Pulp Fiction', '1994', 'USA', '1');

#create table films_has_actors

CREATE TABLE `films_has_actors`
(
    `films_id`  int NOT NULL,
    `actors_id` int NOT NULL,
    PRIMARY KEY (`films_id`, `actors_id`),
    KEY `fk_films_has_actors_actors1_idx` (`actors_id`),
    KEY `fk_films_has_actors_films_idx` (`films_id`),
    CONSTRAINT `fk_films_has_actors_actors1` FOREIGN KEY (`actors_id`) REFERENCES `actors` (`id`),
    CONSTRAINT `fk_films_has_actors_films` FOREIGN KEY (`films_id`) REFERENCES `films` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

#insert values into films_has_actors

INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('1', '1');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('1', '2');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('1', '3');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('2', '3');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('2', '4');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('2', '5');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('2', '6');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('3', '1');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('3', '2');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('3', '3');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('4', '7');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('4', '6');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('4', '8');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('5', '1');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('5', '4');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('5', '8');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('5', '7');
INSERT INTO `films_has_actors` (`films_id`, `actors_id`)
VALUES ('5', '2');

#create users table


CREATE TABLE `users`
(
    `id`       int         NOT NULL AUTO_INCREMENT,
    `login`    varchar(45) NOT NULL,
    `password` int NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

#insert values into users

INSERT INTO `users` (`login`, `password`) VALUES ('user', '1234');
INSERT INTO `users` (`login`, `password`) VALUES ('user2', '4321');










