package treatment;


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
@AllArgsConstructor

public class Treatment {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String type;
	private int animalId;
	private String description;
	private String stage;
	private int userid;
	private String date;
	
	public Treatment(String type, int animalId, String description, String stage, int userid, String date) {
	
		this.type = type;
		this.animalId = animalId;
		this.description = description;
		this.stage = stage;
		this.userid = userid;
		this.date = date;
	}
	
	
	
	
}
