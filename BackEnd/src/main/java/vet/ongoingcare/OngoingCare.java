package vet.ongoingcare;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngoingCare {

	private int animalId;
	private int preventiveCareId;
	private String schedule;

}
