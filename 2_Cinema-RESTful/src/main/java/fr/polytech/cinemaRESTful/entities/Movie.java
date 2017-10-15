package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Length(max = 20)
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "duration")
    private int duration;

    @NotNull
    @Column(name = "released_date")
    private Date releaseDate;

    @NotNull
    @Column(name = "budget")
    private int budget;

    @NotNull
    @Column(name = "amount_of_revenue")
    private int amountOfRevenue;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

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
}