package fr.polytech.cinemaRESTful.forms;

import java.util.Date;

public class MovieForm {

    private int id;

    private String title;

    private int duration;

    private Date releaseDate;

    private int budget;

    private int amontOfRevenue;

    private int directorId;

    private int categoryId;

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

    public int getAmontOfRevenue() {
        return amontOfRevenue;
    }

    public void setAmontOfRevenue(final int amontOfRevenue) {
        this.amontOfRevenue = amontOfRevenue;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(final int directorId) {
        this.directorId = directorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }
}