package fr.polytech.cinemaRESTful.controllers.forms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActorForm {

    public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

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

    public Date getBirthDate() {
        if (this.birthDate != null) {
            try {
                return DATE_FORMATTER.parse(this.birthDate);
            } catch (ParseException e) {
            }
        }

        return null;
    }

    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDateOfDeath() {
        if (this.dateOfDeath != null) {
            try {
                return DATE_FORMATTER.parse(this.dateOfDeath);
            } catch (ParseException e) {
            }
        }

        return null;
    }

    public void setDateOfDeath(final String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}