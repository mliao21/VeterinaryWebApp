package vet.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalDAOimpl implements AnimalDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Animal animal) {
		return jdbcTemplate.update("INSERT INTO ANIMAL(type,breed,name,status,weight) VALUES (?,?,?,?,?)" ,new Object[] {animal.getName(), 
				animal.getSex(),
				animal.getAge(),
				animal.getWeight(),
				animal.getSpecies(),
				animal.getBreed()});
	}

	@Override
	public int update(Animal animal, int id) {
		return jdbcTemplate.update("UPDATE ANIMAL SET type=?, breed =?, name =?, status =?, weight =? WHERE id=?", new Object[] {animal.getName(), 
				animal.getSex(),
				animal.getAge(),
				animal.getWeight(),
				animal.getSpecies(),
				animal.getBreed()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM ANIMAL WHERE id=?", id);
	}

	@Override
	public List<Animal> getAll() {
		
		return jdbcTemplate.query("SELECT * from ANIMAL", new BeanPropertyRowMapper<Animal>(Animal.class));
	}

	@Override
	public Animal getByID(int id) {
	
		return jdbcTemplate.queryForObject("SELECT * FROM ANIMAL WHERE id =?", new BeanPropertyRowMapper<Animal>(Animal.class),id);
	}
	
}
