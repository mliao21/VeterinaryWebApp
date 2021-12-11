package vet.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagesController {
	
	private final ImagesRepository repository;

	public ImagesController(ImagesRepository repository) {
		
		this.repository = repository;
	}
	
	// Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/images")
	  List<Images> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]
	  
	  @PostMapping("/images")
	  Images newImage(@RequestBody Images newImage) {
	    return repository.save(newImage);
	  }
	  
	// Single item
	  
	  @GetMapping("/images/{id}")
	  Images one(@PathVariable Long id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new ImagesNotFoundException(id));
	  }
	  
	  
	  @PutMapping("/images/{id}")
	  Images replaceImages(@RequestBody Images newImage, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(image -> {
	    	image.setUser(newImage.getUser());
	    	image.setCreateDate(newImage.getCreateDate());
	    	image.setAddress(newImage.getAddress());
	    	image.setAnimal(newImage.getAnimal());
	    	image.setType(newImage.getType());
	        return repository.save(image);
	      })
	      .orElseGet(() -> {
	        newImage.setId(id);
	        return repository.save(newImage);
	      });
	  }
	  
	  @DeleteMapping("/images/{id}")
	  void deleteImage(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

	
	

}
