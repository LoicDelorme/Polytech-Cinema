package fr.polytech.cinema.forms;

public class CategoryForm {

	private Integer id;

	private String restrictedLabel;

	private String fullLabel;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getRestrictedLabel() {
		return restrictedLabel;
	}

	public void setRestrictedLabel(final String restrictedLabel) {
		this.restrictedLabel = restrictedLabel == null || restrictedLabel.isEmpty() ? null : restrictedLabel;
	}

	public String getFullLabel() {
		return fullLabel;
	}

	public void setFullLabel(final String fullLabel) {
		this.fullLabel = fullLabel == null || fullLabel.isEmpty() ? null : fullLabel;
	}
}