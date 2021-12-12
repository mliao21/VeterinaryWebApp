package treatment;
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
		return jdbcTemplate.update("INSERT INTO TREATMENT(type, animalId, description, stage, userid, date) VALUES (?,?,?,?,?,?)" , new Object[] {treatment.getType(), 
				treatment.getAnimalId(),
				treatment.getDescription(),
				treatment.getStage(),
				treatment.getUserid(),
				treatment.getDate()});
	}

	@Override
	public int update(Treatment treatment, int id) {
		return jdbcTemplate.update("UPDATE TREATMENT SET type=?, animalId=?, description=?, stage=?, userid=?, date=? WHERE id=?" , new Object[] {treatment.getType(), 
				treatment.getAnimalId(),
				treatment.getDescription(),
				treatment.getStage(),
				treatment.getUserid(),
				treatment.getDate()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM TREATMENT WHERE id=?", id);
	}

	@Override
	public List<Treatment> getAll() {
		return jdbcTemplate.query("SELECT * from TREATMENT", new BeanPropertyRowMapper<Treatment>(Treatment.class));
	}

	@Override
	public List<Treatment> getNewTreatment() {
		return jdbcTemplate.query("SELECT * FROM TREATMENT WHERE stage = 'In progress'", new BeanPropertyRowMapper<Treatment>(Treatment.class));
	}

	@Override
	public Treatment getByID(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM TREATMENT WHERE id =?", new BeanPropertyRowMapper<Treatment>(Treatment.class),id);
	}
	
	

}