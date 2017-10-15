package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Length(max = 100)
    @Column(name = "lastname")
    private String lastname;

    @Length(max = 100)
    @Column(name = "firstname")
    private String firstname;

    @JsonbTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
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