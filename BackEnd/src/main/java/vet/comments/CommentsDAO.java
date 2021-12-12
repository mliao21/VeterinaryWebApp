package vet.comments;

import java.util.List;


public interface CommentsDAO {
	
	int save(Comments comment);
	int update(Comments comment, int id);
	int delete(int id);
	List<Comments> getAll();
	Comments getByID(int id);
	
}
