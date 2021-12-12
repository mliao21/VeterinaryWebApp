package vet.treatment;

import java.util.List;

public interface TreatmentDAO {
	
	int save(Treatment treatment);
	int update(Treatment treatment, int id);
	int delete(int id);
	List<Treatment> getAll();
	List<Treatment> getNewTreatment();
	Treatment getByID(int id);
	
}


