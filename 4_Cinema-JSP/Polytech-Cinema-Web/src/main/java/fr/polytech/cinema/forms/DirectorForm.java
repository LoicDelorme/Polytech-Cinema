package fr.polytech.cinema.forms;

public class DirectorForm {

	private Integer id;

	private String lastname;

	private String firstname;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname == null || lastname.isEmpty() ? null : lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname == null || firstname.isEmpty() ? null : firstname;
	}
}