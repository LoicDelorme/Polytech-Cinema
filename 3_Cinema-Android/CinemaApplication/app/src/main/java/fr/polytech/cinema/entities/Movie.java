package fr.polytech.cinema.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Movie {

    private int id;

    private String title;

    private int duration;

    private Date releaseDate;

    private int budget;

    private int amountOfRevenue;

    private Director director;

    private Category category;

    private Set<Actor> actors = new HashSet<Actor>();

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(final int budget) {
        this.budget = budget;
    }

    public int getAmountOfRevenue() {
        return amountOfRevenue;
    }

    public void setAmountOfRevenue(final int amountOfRevenue) {
        this.amountOfRevenue = amountOfRevenue;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(final Director director) {
        this.director = director;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(final Set<Actor> actors) {
        this.actors = actors;
    }
}