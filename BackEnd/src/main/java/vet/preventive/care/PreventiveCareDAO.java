package preventive.care;

import java.util.List;

public interface PreventiveCareDAO {
	
	int save(PreventiveCare animal);
	int update(PreventiveCare animal, int id);
	int delete(int id);
	List<PreventiveCare> getAll();
	PreventiveCare getByID(int id);

}
