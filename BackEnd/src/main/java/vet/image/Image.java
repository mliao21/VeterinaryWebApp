package vet.image;

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
public class Image {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long imageID;
	private int animalID;
	private String creationDate;
	private String file;
	private String type;
	private int userID;
	
	public Image(int animalID, String creationDate, String file, String type, int userID) {
		this.animalID = animalID;
		this.creationDate = creationDate;
		this.file = file;
		this.type = type;
		this.userID = userID;
	}
	
}
