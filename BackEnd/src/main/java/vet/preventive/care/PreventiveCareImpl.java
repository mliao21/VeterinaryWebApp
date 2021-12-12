package vet.preventive.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PreventiveCareImpl  implements PreventiveCareDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public int save(PreventiveCare preventiveCare) {
		
		return jdbcTemplate.update("INSERT INTO PREVENTIVE_CARE(type) VALUES (?)", new Object[] {preventiveCare.getType()});
	}

	@Override
	public int update(PreventiveCare preventiveCare, int id) {
		
		return jdbcTemplate.update("UPDATE PREVENTIVE_CARE SET type=?", new Object[] {preventiveCare.getType()});
	}
	

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM PREVENTIVE_CARE WHERE id=?", id);
	}

	@Override
	public List<PreventiveCare> getAll() {
		
		return jdbcTemplate.query("SELECT * from PREVENTIVE_CARE", new BeanPropertyRowMapper<PreventiveCare>(PreventiveCare.class));
	}

	@Override
	public PreventiveCare getByID(int id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM PREVENTIVE_CARE WHERE id =?", new BeanPropertyRowMapper<PreventiveCare>(PreventiveCare.class),id);
	}

}
	

