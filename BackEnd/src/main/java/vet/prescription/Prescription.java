package vet.prescription;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Prescription {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long prescriptionid;
	private int animalid;
	private int  userid;
	private String date;
	private String instructions;
	private String drugname;
	private String dosage;
	private String delieverymethod;
	
	public Prescription(int animalid, int userid, String date, String instructions, String drugname, String dosage,
			String delieverymethod) {
	
		this.animalid = animalid;
		this.userid = userid;
		this.date = date;
		this.instructions = instructions;
		this.drugname = drugname;
		this.dosage = dosage;
		this.delieverymethod = delieverymethod;
	}
	
	}