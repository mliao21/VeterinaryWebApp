package vet.comments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comments {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int commentId;
	private int userId;
	private int animalId;
	private String description;
	private String date;
	
	public Comments(int UserID, int AnimalID, String description, String date) {
		this.userId = UserID;
		this.animalId = AnimalID;
		this.description = description;
		this.date = date;
	}
	
}
