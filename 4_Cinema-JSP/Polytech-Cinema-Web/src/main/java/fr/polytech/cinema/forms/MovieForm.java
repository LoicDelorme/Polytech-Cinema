package fr.polytech.cinema.forms;

public class MovieForm {

	private Integer id;

	private String title;

	private Integer duration;

	private String releaseDate;

	private Integer budget;

	private Integer amountOfRevenue;

	private Integer directorId;

	private Integer categoryId;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title == null || title.isEmpty() ? null : title;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(final Integer duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(final String releaseDate) {
		this.releaseDate = releaseDate == null || releaseDate.isEmpty() ? null : releaseDate;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(final Integer budget) {
		this.budget = budget;
	}

	public Integer getAmountOfRevenue() {
		return amountOfRevenue;
	}

	public void setAmountOfRevenue(final Integer amountOfRevenue) {
		this.amountOfRevenue = amountOfRevenue;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(final Integer directorId) {
		this.directorId = directorId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final Integer categoryId) {
		this.categoryId = categoryId;
	}
}