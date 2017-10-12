package fr.polytech.cinemaRESTful.services;

import fr.polytech.cinemaRESTful.entities.Movie;

public class MovieDaoServices extends AbstractDaoServices<Movie> {

    public MovieDaoServices() {
        super(Movie.class);
    }
}