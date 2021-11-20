package veterinary.application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalStatusHistoryRepository extends JpaRepository<AnimalStatusHistory, Long>{
	
}
