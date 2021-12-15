package vet.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(User user) {
		return jdbcTemplate.update("INSERT INTO USER(role, username, email, password, status) VALUES (?,?,?,?,?)" , new Object[] {
				user.getRole(), 
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getStatus()});
	}

	@Override
	public int update(User user, int id) {
		return jdbcTemplate.update("UPDATE USER SET Role=?, Username=?, email=?, password=?, status=? WHERE UserID=?" , new Object[] {user.getRole(), 
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getStatus()});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM USER WHERE id=?", id);
	}

	@Override
	public List<User> getAll() {
		return jdbcTemplate.query("SELECT * from USER", new BeanPropertyRowMapper<User>(User.class));
	}


	@Override
	public User getByID(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE UserID =?", new BeanPropertyRowMapper<User>(User.class),id);
	}

}
