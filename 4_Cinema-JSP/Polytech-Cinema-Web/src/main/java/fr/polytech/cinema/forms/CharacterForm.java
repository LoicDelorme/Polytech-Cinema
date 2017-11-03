package fr.polytech.cinema.forms;

public class CharacterForm {

	private Integer movieId;

	private Integer actorId;

	private String name;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(final Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(final Integer actorId) {
		this.actorId = actorId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name == null || name.isEmpty() ? null : name;
	}
}