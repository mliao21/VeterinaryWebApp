package vet.prescription;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Component
public class PrescriptionDAOImpl implements PrescriptionDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Prescription prescriptions) {
		
		return jdbcTemplate.update("INSERT INTO PRESCRIPTION(animalid, userid, date, instructions, drugname, dosage, delieverymethod) VALUES (?,?,?,?,?, ?, ?)" ,new Object[] {prescriptions.getAnimalid(), 
				prescriptions.getUserid(),
				prescriptions.getDate(),
				prescriptions.getInstructions(), prescriptions.getDrugname(), prescriptions.getDosage(), prescriptions.getDelieverymethod()});
	}

	@Override
	public int update(Prescription prescriptions, int id) {
		
		return jdbcTemplate.update("UPDATE PRESCRIPTIONS SET animalid=?, userid =?, date =?, instructions =?, drugname =?, dosage = ?, delieverymethod =? WHERE id=?", new Object[] {prescriptions.getAnimalid(), 
				prescriptions.getUserid(),
				prescriptions.getDate(),
				prescriptions.getInstructions(), prescriptions.getDrugname(), prescriptions.getDosage(), prescriptions.getDelieverymethod()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM PRESCRIPTIONS WHERE id =?", id);
		
	}

	@Override
	public Prescription getByID(int id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM PRESCRIPTIONS WHERE id =?", new BeanPropertyRowMapper<Prescription>(Prescription.class),id);
	}

	@Override
	public List<Prescription> getAllPrescriptions() {
		
		return jdbcTemplate.query("SELECT * from ANIMAL", new BeanPropertyRowMapper<Prescription>(Prescription.class));

	}

}
