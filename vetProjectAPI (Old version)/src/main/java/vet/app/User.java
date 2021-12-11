package vet.app;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private String name;
	private String type;
	private String email;
	private String activationDate;
	private boolean isBlocked;
	
	public User(String name, String type, String email, String date, boolean blocked) {
		this.name = name;
		this.type = type;
		this.email = email;
		activationDate = date;
		isBlocked = blocked;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (!(o instanceof User))
	      return false;
	    User user = (User) o;
	    return Objects.equals(this.id, user.id) && Objects.equals(this.type, user.type) && Objects.equals(this.email, user.email);
	  }
	
	@Override
	public int hashCode() {
	    return Objects.hash(this.id, this.type);
	  }
	
	@Override
	public String toString() {
	    return "User{" + "id=" + this.id + ", type='" + this.type + '\'' + '}';
	}

}
