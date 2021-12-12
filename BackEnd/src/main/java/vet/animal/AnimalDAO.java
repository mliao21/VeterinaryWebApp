package vet.animal;

import java.util.List;

public interface AnimalDAO {
	
	int save(Animal animal);
	int update(Animal animal, int id);
	int delete(int id);
	List<Animal> getAll();
	List<Animal> getAvailableAnimals();
	List<Animal> getNewRequests();
	List<Animal> getPendingAnimalRequests();
	List<Animal> getApprovedByAdminRequests();
	Animal getByID(int id);
}
