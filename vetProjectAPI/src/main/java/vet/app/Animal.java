package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import net.bytebuddy.asm.Advice.This;

@Entity
public class Animal {

	// private @Id @GeneratedValue Long id;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private String type;
	private double weight;
	private String DOB;
	private String sex;
	private String colour;
	private String bread;
	private int tattoo;
	private String city;
	private String RFID;
	private String microchirp;
	private String status;
	private String draught;
	private String meat;
	private String region;
	private String subspecies;
	private String distinguishing;
	private String features;

    public Animal() {
		
	}
	
	public Animal(String type, double weight, String DOB, String sex, String colour, String bread,
			int tattoo, String city, String RFID, String microchirp, String status, String draught, String meat,
			String region, String subspecies, String distinguishing, String features) {
		//super();
		this.type = type;
		this.weight = weight;
		this.DOB = DOB;
		this.sex = sex;
		this.colour = colour;
		this.bread = bread;
		this.tattoo = tattoo;
		this.city = city;
		this.RFID = RFID;
		this.microchirp = microchirp;
		this.status = status;
		this.draught = draught;
		this.meat = meat;
		this.region = region;
		this.subspecies = subspecies;
		this.distinguishing = distinguishing;
		this.features = features;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public double getWeight() {
		return weight;
	}

	public String getDOB() {
		return DOB;
	}

	public String getSex() {
		return sex;
	}

	public String getColour() {
		return colour;
	}

	public String getBread() {
		return bread;
	}

	public int getTattoo() {
		return tattoo;
	}

	public String getCity() {
		return city;
	}

	public String getRFID() {
		return RFID;
	}

	public String getMicrochirp() {
		return microchirp;
	}

	public String getStatus() {
		return status;
	}

	public String getDraught() {
		return draught;
	}

	public String getMeat() {
		return meat;
	}

	public String getRegion() {
		return region;
	}

	public String getSubspecies() {
		return subspecies;
	}

	public String getDistinguishing() {
		return distinguishing;
	}

	public String getFeatures() {
		return features;
	}

// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public void setTattoo(int tattoo) {
		this.tattoo = tattoo;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setRFID(String rFID) {
		RFID = rFID;
	}

	public void setMicrochirp(String microchirp) {
		this.microchirp = microchirp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDraught(String draught) {
		this.draught = draught;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSubspecies(String subspecies) {
		this.subspecies = subspecies;
	}

	public void setDistinguishing(String distinguishing) {
		this.distinguishing = distinguishing;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Animal))
			return false;
		Animal animal = (Animal) o;
		return Objects.equals(this.id, animal.id) && Objects.equals(this.type, animal.type)
				&& Objects.equals(this.weight, animal.weight) && Objects.equals(this.DOB, animal.DOB)
				&& Objects.equals(this.sex, animal.sex) && Objects.equals(this.colour, animal.colour)
				&& Objects.equals(this.bread, animal.bread) && Objects.equals(this.tattoo, animal.tattoo)
				&& Objects.equals(this.city, animal.city) && Objects.equals(this.RFID, animal.RFID)
				&& Objects.equals(this.microchirp, animal.microchirp) && Objects.equals(this.status, animal.status)
				&& Objects.equals(this.draught, animal.draught) && Objects.equals(this.meat, animal.meat)
				&& Objects.equals(this.region, animal.region) && Objects.equals(this.subspecies, animal.subspecies)
				&& Objects.equals(this.distinguishing, animal.distinguishing)
				&& Objects.equals(this.features, animal.features);

	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.type, this.weight, this.DOB, this.sex, this.colour, this.bread, this.tattoo,
				this.city, this.RFID, this.microchirp, this.status, this.draught, this.meat, this.subspecies,
				this.distinguishing, this.features);
	}

	@Override
	public String toString() {

		return "Animal{" + "id=" + this.id + ", type='" + this.type + "', weight='" + this.weight + "', DOB='"
				+ this.DOB + "', sex='" + this.sex + "', colour='" + this.colour + "', bread='" + this.bread
				+ "', tattoo='" + this.tattoo + "', city tattoo='" + this.city + "', RFID='" + this.RFID
				+ "', microchirp='" + this.microchirp + "', status='" + this.status + "', draught='" + this.draught
				+ "', meat='" + this.meat + "', subspecies='" + this.subspecies + "', distinguishing='"
				+ this.distinguishing + "', features='" + this.features + '\'' + '}';

	}



}
