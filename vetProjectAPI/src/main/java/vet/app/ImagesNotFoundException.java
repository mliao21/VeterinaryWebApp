package veterinary.application;

public class ImagesNotFoundException extends RuntimeException {

	ImagesNotFoundException(Long id) {
		super("Could not find image " + id);

	}
}