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
	
	
	
	
//    public Animal() {
//		
//	}
//	
//	public Animal(String type, double weight, String bread,String status, String name) {
//		//super();
//		this.type = type;
//		this.weight = weight;
//		this.breed = bread;
//		this.status = status;
//		this.name = name;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	// Getters
//	public Long getId() {
//		return id;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public double getWeight() {
//		return weight;
//	}
//
//	
//
//	public String getStatus() {
//		return status;
//	}
//	
//	public String getBreed() {
//		
//		return breed;
//	}
//
//	
//
//// Setters
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public void setWeight(double weight) {
//		this.weight = weight;
//	}
//
//	
//	public void setBreed(String breed) {
//		this.breed = breed;
//	}
//
//	
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//
//	@Override
//	public boolean equals(Object o) {
//
//		if (this == o)
//			return true;
//		if (!(o instanceof Animal))
//			return false;
//		Animal animal = (Animal) o;
//		return Objects.equals(this.id, animal.id) && Objects.equals(this.type, animal.type)
//				&& Objects.equals(this.weight, animal.weight)
//				&& Objects.equals(this.breed, animal.breed) && Objects.equals(this.status, animal.status);
//
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.id, this.type, this.weight,this.breed, this.status);
//	}
//
//	@Override
//	public String toString() {
//
//		return "Animal{" + "id=" + this.id + ", type='" + this.type + "', weight='" + this.weight + "', breed='" + this.breed
//				+ "', status='" + this.status + '\'' + '}';
//
//	}

}
