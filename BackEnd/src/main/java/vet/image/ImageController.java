package vet.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
	
	@Autowired
	private ImageDAO imageDAO;
	
	@GetMapping("/image")
	public List<Image> getImages(){
		return imageDAO.getAll();
	}
	
	@GetMapping("/image/{id}")
	public Image getImageByID(@PathVariable int id) {
		return imageDAO.getByID(id);
	}
	
	@PostMapping("/image")
	public String saveImage(@RequestBody Image image) {
		return imageDAO.save(image) + " rows saved to DB";
	}
	
	@PutMapping("image/{id}")
	public String updateImage(@RequestBody Image image, @PathVariable int id) {
		return imageDAO.update(image, id) + " rows updated to DB";
	}
	
	@DeleteMapping("image/{id}")
	public String deleteImage(@PathVariable int id) {
		return imageDAO.delete(id) + " rows deleted from DB";
	}
	
	
}
