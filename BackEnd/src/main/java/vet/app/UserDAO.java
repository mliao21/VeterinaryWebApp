package vet.app;

import java.util.List;

public interface UserDAO {
	
	int save(User user);
	int update(User user, int id);
	int delete(int id);
	List<User> getAll();
	User getByID(int id);
	
}
