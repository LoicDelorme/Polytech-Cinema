package fr.polytech.cinema.forms;

public class ActorForm {

	private Integer id;

	private String lastname;

	private String firstname;

	private String birthDate;

	private String dateOfDeath;

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

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(final String birthDate) {
		this.birthDate = birthDate == null || birthDate.isEmpty() ? null : birthDate;
	}

	public String getDateOfDeath() {
		return this.dateOfDeath;
	}

	public void setDateOfDeath(final String dateOfDeath) {
		this.dateOfDeath = dateOfDeath == null || dateOfDeath.isEmpty() ? null : dateOfDeath;
	}
}