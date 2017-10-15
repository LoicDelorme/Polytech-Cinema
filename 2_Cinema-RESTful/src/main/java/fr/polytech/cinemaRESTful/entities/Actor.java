package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private Date birthDate;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @JsonbTransient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actor", orphanRemoval = true)
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
}