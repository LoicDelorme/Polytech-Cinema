package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor implements Serializable {

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

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "date_of_death")
    private LocalDate dateOfDeath;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "actor")
    private List<Character> characters = new ArrayList<Character>();

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(final LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(final List<Character> characters) {
        this.characters = characters;
    }
}