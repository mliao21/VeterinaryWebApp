package prescription;

import java.util.List;

public interface PrescriptionDAO {
	
	int save(Prescription prescriptions);
	int update(Prescription prescriptions, int id);
	int delete(int id);
	Prescription getByID(int id);
	List<Prescription> getAllPrescriptions();

}
