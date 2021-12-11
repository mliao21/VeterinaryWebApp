package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private int user;
	private int animal;
	private String description;

	public Comment() {

	}

	public Comment(int user, int animal, String description) {

		this.user = user;
		this.animal = animal;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public int getUser() {
		return user;
	}

	public int getAnimal() {
		return animal;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Comment))
			return false;
		Comment comment = (Comment) o;
		return Objects.equals(this.id, comment.id) && Objects.equals(this.user, comment.user)
				&& Objects.equals(this.animal, comment.animal) && Objects.equals(this.description, comment.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.user, this.animal, this.description);
	}

	@Override
	public String toString() {
		return "Comment{" + "id=" + this.id + ", user='" + this.user + "', animal='" + this.animal + "', description='"
				+ this.description + '\'' + '}';
	}

}
