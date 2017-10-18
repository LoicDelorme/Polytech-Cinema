package fr.polytech.cinema.entities;

public class Character {

    private Movie movie;

    private Actor actor;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}