package vet.ongoingcare;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngoingCare {
	
	@Id
	private int animalId;
	private int preventiveCareId;
	private String schedule;

}
