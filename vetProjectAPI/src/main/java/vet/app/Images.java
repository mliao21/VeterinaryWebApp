package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Images {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private int user;
	private String createDate;
	private String address;
	private int animal;
	private String type;

	public Images() {

	}

	public Images(int user, String createDate, String address, int animal, String type) {
		
		this.user = user;
		this.createDate = createDate;
		this.address = address;
		this.animal = animal;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public int getUser() {
		return user;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getAddress() {
		return address;
	}

	public int getAnimal() {
		return animal;
	}

	public String getType() {
		return type;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (!(o instanceof Images))
	      return false;
	    Images image = (Images) o;
	    return Objects.equals(this.id, image.id) 
	    	&& Objects.equals(this.user, image.user)
	    	&& Objects.equals(this.createDate, image.createDate)
	    	&& Objects.equals(this.address,image.address)
	    	&& Objects.equals(this.animal, image.animal)
	    	&& Objects.equals(this.type, image.type);
	    	
	  }
	
	@Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.user, this.createDate, this.address, this.animal, this.type);
	  }
	
	 @Override
	  public String toString() {
	    return "Images{" + "id=" + this.id + ", user='" + this.user
	    		+ "', creatdate='" + this.createDate + "', address='" + this.address 
	    		+ "', animal='" + this.animal 
	    		+ "', type='" + this.type + '\'' + '}';
	  }

}
