package vet.animalstatus;

import java.util.List;

public interface AnimalStatusDAO {
	
	int save(AnimalStatus animalStatus);
	int update(AnimalStatus animalStaus, int id);
	int delete(int id);
	AnimalStatus getByID(int id);
	List<AnimalStatus> getAllAnimalStatus();

}
