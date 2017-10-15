USE TP_CinemaRESTful;

/*
  DROP TABLE IF EXISTS characters;
  DROP TABLE IF EXISTS movies;
  DROP TABLE IF EXISTS categories;
  DROP TABLE IF EXISTS directors;
  DROP TABLE IF EXISTS actors;
*/

CREATE TABLE actors (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  lastname VARCHAR(100) NOT NULL,
  firstname VARCHAR(100),
  birth_date DATE,
  date_of_death DATE
);

CREATE TABLE directors (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  lastname VARCHAR(100) NOT NULL,
  firstname VARCHAR(100)
);

CREATE TABLE categories (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  restricted_label VARCHAR(2) NOT NULL UNIQUE,
  full_label VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE movies (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL UNIQUE,
  duration INT NOT NULL,
  released_date DATE NOT NULL,
  budget INT NOT NULL,
  amount_of_revenue INT NOT NULL,
  id_director INT NOT NULL,
  id_category INT NOT NULL,
  FOREIGN KEY (id_director) REFERENCES directors (id),
  FOREIGN KEY (id_category) REFERENCES categories (id)
);

CREATE TABLE characters (
  id_movie INT NOT NULL,
  id_actor INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_movie, id_actor),
  FOREIGN KEY (id_movie) REFERENCES movies (id),
  FOREIGN KEY (id_actor) REFERENCES actors (id)
);