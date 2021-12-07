package com.example.demo;

public class UserNotFoundException extends RuntimeException {
	
	UserNotFoundException(Integer id) {
	    super("Could not find user id: " + id);
	}
}
