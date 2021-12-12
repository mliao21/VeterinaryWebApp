package vet.image;

public class ImageNotFoundException extends RuntimeException{
	
	ImageNotFoundException(Long imageID) {
	    super("Could not find image" + imageID);
	  }
	
}
