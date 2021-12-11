package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class TreatmentRecord {

  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  private String creationDate;
  private int treatmentType;
  private int animalId;
  private TreatmentStages stage;
  private String comment;
  private String lastUpdate;
  private int userId;

  TreatmentRecord() {}

  TreatmentRecord(String date, int type, int animal, TreatmentStages stage, String comment, String update, int user) {
    this.creationDate = date;
    this.treatmentType = type;
    this.animalId = animal;
    this.stage = stage;
    this.comment = comment;
    this.lastUpdate = update;
    this.userId = user;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getCreationDate() {
	return creationDate;
  }

  public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
  }
	
  public int getTreatmentType() {
	return treatmentType;
  }
	
  public void setTreatmentType(int treatmentType) {
	this.treatmentType = treatmentType;
  }
	
  public int getAnimalId() {
	return animalId;
  }
	
  public void setAnimalId(int animalId) {
	this.animalId = animalId;
  }
	
  public TreatmentStages getStage() {
	return stage;
  }
	
  public void setStage(TreatmentStages stage) {
	this.stage = stage;
  }
	
  public String getComment() {
	return comment;
  }
	
  public void setComment(String comment) {
	this.comment = comment;
  }
	
  public String getLastUpdate() {
	return lastUpdate;
  }
	
  public void setLastUpdate(String lastUpdate) {
	this.lastUpdate = lastUpdate;
  }
	
  public int getUserId() {
	return userId;
  }
	
  public void setUserId(int userId) {
	this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof TreatmentRecord))
      return false;
    TreatmentRecord treatment = (TreatmentRecord) o;
    return Objects.equals(this.id, treatment.id) && Objects.equals(this.creationDate, treatment.creationDate)
    		&& Objects.equals(this.treatmentType, treatment.treatmentType)
    		&& Objects.equals(this.animalId, treatment.animalId)
    		&& Objects.equals(this.stage, treatment.stage)
    		&& Objects.equals(this.comment, treatment.comment)
    		&& Objects.equals(this.lastUpdate, treatment.lastUpdate)
    		&& Objects.equals(this.userId, treatment.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.creationDate, this.treatmentType, this.animalId, this.stage, 
    					this.comment, this.lastUpdate, this.userId);
  }

  @Override
  public String toString() {
    return "TreatmentRecord{" + "id=" + this.id + ", creationDate='" + this.creationDate 
    		+ "type=" + this.treatmentType + ", animal ID='" + this.animalId 
    		+ "stage=" + this.stage + ", comment='" + this.comment 
    		+ "last update=" + this.lastUpdate + ", user ID='" + this.userId + '\'' + '}';
  }
  
}