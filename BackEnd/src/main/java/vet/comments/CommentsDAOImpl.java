package vet.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CommentsDAOImpl implements CommentsDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Comments comment) {
		return jdbcTemplate.update("INSERT INTO COMMENTS(userID, animalID, Description, Date) VALUES (?,?,?,?)" , new Object[] {comment.getUserId(), 
				comment.getAnimalId(),
				comment.getDescription(),
				comment.getDate()});
	}
	
	@Override
	public int update(Comments comment, int id) {
		return jdbcTemplate.update("UPDATE COMMENTS SET userID=?,animalID=?, Description=?, Date=? WHERE id=?" , new Object[] {comment.getUserId(), 
				comment.getAnimalId(),
				comment.getDescription(),
				comment.getDate()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM COMMENTS WHERE id=?", id);
	}

	@Override
	public List<Comments> getAll() {
		return jdbcTemplate.query("SELECT * from COMMENTS", new BeanPropertyRowMapper<Comments>(Comments.class));
	}

	@Override
	public Comments getByID(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM COMMENTS WHERE id =?", new BeanPropertyRowMapper<Comments>(Comments.class),id);
	}
	
}
