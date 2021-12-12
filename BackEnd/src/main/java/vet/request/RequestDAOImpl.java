package request;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAOImpl  implements  RequestDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
 
	@Override
	public int save(Request request) {
		return jdbcTemplate.update("INSERT INTO REQUEST(animalId, userId, requestStatus, date) VALUES (?,?,?,?)" ,new Object[] {request.getAnimalId(), 
				request.getUserId(),  
				request.getRequestStatus(),
				request.getDate()});
	}

	@Override
	public int update(Request request, int animalId) {
		return jdbcTemplate.update("UPDATE REQUEST SET animalId=?, userId=?, requestStatus=?, date=? WHERE animalId=?" , new Object[] {request.getAnimalId(), 
				request.getUserId(),  
				request.getRequestStatus(),
				request.getDate(), animalId });
	}

	@Override
	public int delete(int animalId) {
		
		return jdbcTemplate.update("DELETE FROM REQUEST WHERE animalId=?", animalId);
	}

	@Override
	public List<Request> getAll() {
		
		return jdbcTemplate.query("SELECT * from REQUEST", new BeanPropertyRowMapper<Request>(Request.class));
	}


	@Override
	public Request getByStatus() {
		
		return jdbcTemplate.queryForObject("SELECT * FROM REQUEST WHERE requestStatus = 'new'", new BeanPropertyRowMapper<Request>(Request.class));
	}
	
	

}
