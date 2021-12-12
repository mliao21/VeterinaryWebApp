package request;

import java.util.List;

public interface RequestDAO {
	
	int save(Request request);
	int update(Request Request, int id);
	int delete(int animalId);
	List<Request> getAll();
	Request getByStatus();

}
