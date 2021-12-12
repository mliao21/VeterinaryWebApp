package vet.ongoingcare;

import java.util.List;

public interface OngoingCareDAO {
	
	int save(OngoingCare ongoingCare);
	int update(OngoingCare ongoingCare, int animalId, int PreventiveCareID);
	int delete(int animalId, int preventiveCareId);
	List<OngoingCare> getAll();
	OngoingCare getByID(int animalId);
}
