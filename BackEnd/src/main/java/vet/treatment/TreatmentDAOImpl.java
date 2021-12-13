package vet.treatment;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Treatment treatment) {
		return jdbcTemplate.update("INSERT INTO TREATMENTS(type, animalId, description, stage, userid, date) VALUES (?,?,?,?,?,?)" , new Object[] {treatment.getType(), 
				treatment.getAnimalId(),
				treatment.getDescription(),
				treatment.getStage(),
				treatment.getUserid(),
				treatment.getDate()});
	}

	@Override
	public int update(Treatment treatment, int id) {
		return jdbcTemplate.update("UPDATE TREATMENTS SET type=?, animalId=?, description=?, stage=?, userid=?, date=? WHERE treatmentid=?" , new Object[] {treatment.getType(), 
				treatment.getAnimalId(),
				treatment.getDescription(),
				treatment.getStage(),
				treatment.getUserid(),
				treatment.getDate()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM TREATMENTS WHERE treatmentid=?", id);
	}

	@Override
	public List<Treatment> getAll() {
		return jdbcTemplate.query("SELECT * from TREATMENTS", new BeanPropertyRowMapper<Treatment>(Treatment.class));
	}

	@Override
	public List<Treatment> getNewTreatment() {
		return jdbcTemplate.query("SELECT * FROM TREATMENTS WHERE stage = 'In progress'", new BeanPropertyRowMapper<Treatment>(Treatment.class));
	}

	@Override
	public Treatment getByID(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM TREATMENTS WHERE treatmentid =?", new BeanPropertyRowMapper<Treatment>(Treatment.class),id);
	}
	
	

}
