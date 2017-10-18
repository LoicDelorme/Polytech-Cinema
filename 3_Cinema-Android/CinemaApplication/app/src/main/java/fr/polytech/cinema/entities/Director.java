package fr.polytech.cinema.entities;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private int id;

    private String lastname;

    private String firstname;

    private List<Movie> movies = new ArrayList<Movie>();

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }
}