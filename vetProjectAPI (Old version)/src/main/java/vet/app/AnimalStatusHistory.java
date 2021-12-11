package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnimalStatusHistory {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String dateAndTime;
	private String description;
	private String location;
	private String status;
	private int animal;

	public AnimalStatusHistory() {

	}

	public AnimalStatusHistory(String dateAndTime, String description, String location, String status,
			int animal) {
		
		this.dateAndTime = dateAndTime;
		this.description = description;
		this.location = location;
		this.status = status;
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getStatus() {
		return status;
	}

	public int getAnimal() {
		return animal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AnimalStatusHistory))
			return false;
		AnimalStatusHistory history = (AnimalStatusHistory) o;
		return Objects.equals(this.id, history.id) && Objects.equals(this.dateAndTime, history.dateAndTime)
				&& Objects.equals(this.description, history.description)
				&& Objects.equals(this.location, history.location) && Objects.equals(this.status, history.status)
				&& Objects.equals(this.animal, history.animal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.dateAndTime, this.description, this.location, this.status, this.animal);
	}

	@Override
	public String toString() {
		return " AnimalStatusHistory{" + "id=" + this.id + ", dateAndTime='" + this.dateAndTime + "', description='"
				+ this.description + "', location='" + this.location + "', status='" + this.status + '\''
				+ "', animal='" + this.animal + '}';
	}

}
