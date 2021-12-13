package vet.animal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

	// private @Id @GeneratedValue Long id;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long animalid;
	private String name;
	private String sex;
	private String Age;
	private double weight;
	private String species;
	private String breed;
	
}	
	
	
