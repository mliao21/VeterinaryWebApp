package vet.ongoingcare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OngoingCareDAOimpl implements OngoingCareDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(OngoingCare ongoingCare) {
		return jdbcTemplate.update("INSERT INTO ANIMAL_ONGOING_CARE (AnimalID, PreventiveCareID, Schedule) VALUES (?,?,?)", new Object[] {
				ongoingCare.getAnimalId(),
				ongoingCare.getPreventiveCareId(),
				ongoingCare.getSchedule()});
	}

	@Override
	public int update(OngoingCare ongoingCare, int animalId, int preventiveCareId) {
		return jdbcTemplate.update("UPDATE ANIMAL_ONGOING_CARE SET Schedule=?, WHERE AnimalID=? AND PreventiveCareID=?", new Object[] {
				ongoingCare.getSchedule(), animalId, preventiveCareId});
	}

	@Override
	public int delete(int animalId, int preventiveCareId) {
		return jdbcTemplate.update("DELETE FROM ANIMAL_ONGOING_CARE WHERE AnimalID=? AND PreventiveCareID=?", animalId, preventiveCareId);
	}

	@Override
	public List<OngoingCare> getAll() {	
		return jdbcTemplate.query("SELECT * from ANIMAL_ONGOING_CARE", new BeanPropertyRowMapper<OngoingCare>(OngoingCare.class));
	}

	@Override
	public OngoingCare getByID(int animalId) {
		return jdbcTemplate.queryForObject("SELECT * FROM ANIMAL_ONGOING_CARE WHERE AnimalID=?", new BeanPropertyRowMapper<OngoingCare>(OngoingCare.class), animalId);
	}
	
}
