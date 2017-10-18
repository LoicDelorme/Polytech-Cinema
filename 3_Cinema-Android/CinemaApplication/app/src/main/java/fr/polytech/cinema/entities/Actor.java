package fr.polytech.cinema.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Actor {

    private int id;

    private String lastname;

    private String firstname;

    private Date birthDate;

    private Date dateOfDeath;

    private List<Character> characters = new ArrayList<Character>();

    private Set<Movie> movies = new HashSet<Movie>();

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(final Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(final List<Character> characters) {
        this.characters = characters;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final Set<Movie> movies) {
        this.movies = movies;
    }
}