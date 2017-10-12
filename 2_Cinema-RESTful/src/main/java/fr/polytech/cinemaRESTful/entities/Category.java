package fr.polytech.cinemaRESTful.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "directors")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Length(max = 2)
    @Column(name = "restricted_label")
    private String restrictedLabel;

    @Length(max = 20)
    @Column(name = "full_label")
    private String fullLabel;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getRestrictedLabel() {
        return restrictedLabel;
    }

    public void setRestrictedLabel(final String restrictedLabel) {
        this.restrictedLabel = restrictedLabel;
    }

    public String getFullLabel() {
        return fullLabel;
    }

    public void setFullLabel(final String fullLabel) {
        this.fullLabel = fullLabel;
    }
}