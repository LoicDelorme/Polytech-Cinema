package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "budget")
    private int budget;

    @NotNull
    @Column(name = "amont_of_revenue")
    private int amontOfRevenue;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    private Director director;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
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