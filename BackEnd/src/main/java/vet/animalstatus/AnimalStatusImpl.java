package vet.animalstatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class AnimalStatusImpl implements AnimalStatusDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(AnimalStatus animalStatus) {
		
		return jdbcTemplate.update("INSERT INTO ANIMAL_STATUS(location,status,description,lastuser) VALUES (?,?,?,?)" ,new Object[] {animalStatus.getLocation(), 
				animalStatus.getStatus(),
				animalStatus.getDescription(),
				animalStatus.getLastuser()});
	}

	@Override
	public int update(AnimalStatus animalStatus, int id) {
		
		return jdbcTemplate.update("UPDATE ANIMAL_STATUS SET location=?, status =?, description =?, lastuser =? WHERE id=?", new Object[] {animalStatus.getLocation(), 
				animalStatus.getStatus(),
				animalStatus.getDescription(),
				animalStatus.getLastuser(), id});
	}

	@Override
	public int delete(int id) {
		
		return jdbcTemplate.update("DELETE FROM ANIMAL_STATUS WHERE animalid =?", id);
	}

	
	@Override
	public List<AnimalStatus> getAllAnimalStatus() {
		
		return jdbcTemplate.query("SELECT * from ANIMAL_STATUS", new BeanPropertyRowMapper<AnimalStatus>(AnimalStatus.class));
	}

	
	@Override
	public AnimalStatus getByID(int id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM AnimalStatus WHERE id =?", new BeanPropertyRowMapper<AnimalStatus>(AnimalStatus.class),id);
	}

}
