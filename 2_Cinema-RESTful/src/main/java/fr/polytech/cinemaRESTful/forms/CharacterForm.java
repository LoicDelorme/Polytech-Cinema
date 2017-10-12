package fr.polytech.cinemaRESTful.forms;

public class CharacterForm {

    private int movieId;

    private int actorId;

    private String name;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(final int movieId) {
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(final int actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}