package prescription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  PrescriptionRepo extends JpaRepository <Prescription, Long>{
	

}
