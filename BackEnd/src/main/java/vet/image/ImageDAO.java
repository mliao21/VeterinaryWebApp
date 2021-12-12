package vet.image;

import java.util.List;

public interface ImageDAO {
	
	int save(Image image);
	int update(Image image, int id);
	int delete(int id);
	List<Image> getAll();
	Image getByID(int id);
	
	
}
