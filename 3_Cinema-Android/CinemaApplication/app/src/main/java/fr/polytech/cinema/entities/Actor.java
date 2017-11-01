package fr.polytech.cinema.entities;

import java.io.Serializable;

public class Actor implements Serializable {

    private int id;

    private String lastname;

    private String firstname;

    private String birthDate;

    private String dateOfDeath;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(final String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}