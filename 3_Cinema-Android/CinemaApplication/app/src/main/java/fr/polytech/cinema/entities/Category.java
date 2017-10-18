package fr.polytech.cinema.entities;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;

    private String restrictedLabel;

    private String fullLabel;

    private List<Movie> movies = new ArrayList<Movie>();

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRestrictedLabel() {
        return restrictedLabel;
    }

    public void setRestrictedLabel(final String restrictedLabel) {
        this.restrictedLabel = restrictedLabel;
    }

    public String getFullLabel() {
        return fullLabel;
    }

    public void setFullLabel(final String fullLabel) {
        this.fullLabel = fullLabel;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }
}