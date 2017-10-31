package fr.polytech.cinemaRESTful.controllers.forms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MovieForm {

    public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

    private int id;

    private String title;

    private int duration;

    private String releaseDate;

    private int budget;

    private int amountOfRevenue;

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
        if (this.releaseDate != null) {
            try {
                return DATE_FORMATTER.parse(this.releaseDate);
            } catch (ParseException e) {
            }
        }

        return null;
    }

    public void setReleaseDate(final String releaseDate) {
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