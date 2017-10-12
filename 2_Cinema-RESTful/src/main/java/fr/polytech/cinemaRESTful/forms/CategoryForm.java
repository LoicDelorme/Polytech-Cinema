package fr.polytech.cinemaRESTful.forms;

public class CategoryForm {

    private int id;

    private String restrictedLabel;

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