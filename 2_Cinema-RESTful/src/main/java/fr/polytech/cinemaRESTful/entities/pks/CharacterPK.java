package fr.polytech.cinemaRESTful.entities.pks;

import fr.polytech.cinemaRESTful.entities.Actor;
import fr.polytech.cinemaRESTful.entities.Movie;

import java.io.Serializable;

public class CharacterPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Movie movie;

    private Actor actor;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(final Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(final Actor actor) {
        this.actor = actor;
    }
}