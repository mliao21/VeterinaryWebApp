package animalstatus;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class AnimalStatus {

	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String location;

	private String status;

	private String description;

	private int lastuser;

	public AnimalStatus(String location, String status, String description, int lastuser) {
		super();
		this.location = location;
		this.status = status;
		this.description = description;
		this.lastuser = lastuser;
	}
	
	

}
