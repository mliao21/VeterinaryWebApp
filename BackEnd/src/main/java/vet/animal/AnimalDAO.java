package vet.animal;

import java.util.List;

public interface AnimalDAO {
	
	int save(Animal animal);
	int update(Animal animal, int id);
	int delete(int id);
	List<Animal> getAll();
	Animal getByID(int id);
	List<Animal> getAvailableAnimals();
}
