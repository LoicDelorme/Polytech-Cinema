package fr.polytech.cinemaRESTful.controllers.forms;

import java.util.Date;

public class ActorForm {

    private int id;

    private String lastname;

    private String firstname;

    private Date birthDate;

    private Date dateOfDeath;

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
}