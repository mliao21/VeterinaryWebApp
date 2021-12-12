package preventive.care;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
 public class PreventiveCare {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String type;
	
	
	public PreventiveCare(String type) {
		super();
		this.type = type;
	}
	
	
	

}
