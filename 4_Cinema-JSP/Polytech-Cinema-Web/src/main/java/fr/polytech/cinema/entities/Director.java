package fr.polytech.cinema.entities;

import java.util.HashSet;
import java.util.Set;

public class Director {

	private int id;

	private String lastname;

	private String firstname;

	private Set<Movie> movies = new HashSet<Movie>();

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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(final Set<Movie> movies) {
		this.movies = movies;
	}
}