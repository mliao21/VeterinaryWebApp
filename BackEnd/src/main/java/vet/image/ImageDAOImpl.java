package vet.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import vet.treatment.Treatment;

@Component
public class ImageDAOImpl implements ImageDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public int save(Image image) {
		return jdbcTemplate.update("INSERT INTO IMAGES(animalId, creationDate, File, type, userid) VALUES (?,?,?,?,?)" , new Object[] {image.getAnimalID(), 
				image.getCreationDate(),
				image.getFile(),
				image.getType(),
				image.getUserID()});
	}

	@Override
	public int update(Image image, int id) {
		return jdbcTemplate.update("UPDATE IMAGE SET AnimalID=?, CreationDate=?, File=?, Type=?, userid=? WHERE imageid=?" , new Object[] {image.getAnimalID(), 
				image.getCreationDate(),
				image.getFile(),
				image.getType(),
				image.getUserID()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM IMAGES WHERE imageid=?", id);
	}

	@Override
	public List<Image> getAll() {
		return jdbcTemplate.query("SELECT * from IMAGES", new BeanPropertyRowMapper<Image>(Image.class));
	}

	@Override
	public Image getByID(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM IMAGES WHERE imageid =?", new BeanPropertyRowMapper<Image>(Image.class),id);
	}
	
	
}
