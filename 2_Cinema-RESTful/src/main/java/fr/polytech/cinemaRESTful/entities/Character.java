package fr.polytech.cinemaRESTful.entities;

import fr.polytech.cinemaRESTful.entities.pks.CharacterPK;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "characters")
@IdClass(CharacterPK.class)
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_actor")
    private Actor actor;

    @NotNull
    @Length(max = 100)
    @Column(name = "name")
    private String name;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(final Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(final Actor actor) {
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}