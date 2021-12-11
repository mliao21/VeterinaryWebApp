package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class PrescriptionRecord {

  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  private int treatmentId;
  private int type;
  private ScheduleType schedule;
  private String description;
  private String lastUpdate;
  private int userId;

  PrescriptionRecord() {}

  PrescriptionRecord(int treatment, int type, ScheduleType schedule, String desc, String lastUpdate, int userId) {
    this.treatmentId = treatment;
    this.type = type;
    this.schedule = schedule;
    this.description = desc;
    this.lastUpdate = lastUpdate;
    this.userId = userId;
  }

  public Integer getId() {
    return this.id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }

  public int getTreatmentId() {
	return treatmentId;
  }

  public void setTreatmentId(int treatmentId) {
	this.treatmentId = treatmentId;
  }

  public int getType() {
	return type;
  }

  public void setType(int type) {
	this.type = type;
  }

  public ScheduleType getSchedule() {
	return schedule;
  }

  public void setSchedule(ScheduleType schedule) {
	this.schedule = schedule;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
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
    if (!(o instanceof PrescriptionRecord))
      return false;
    PrescriptionRecord prescription = (PrescriptionRecord) o;
    return Objects.equals(this.id, prescription.id) && Objects.equals(this.treatmentId, prescription.treatmentId)
    		&& Objects.equals(this.type, prescription.type)
    		&& Objects.equals(this.schedule, prescription.schedule)
    		&& Objects.equals(this.description, prescription.description)
    		&& Objects.equals(this.lastUpdate, prescription.lastUpdate)
    		&& Objects.equals(this.userId, prescription.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.treatmentId, this.type, this.schedule, this.description, this.lastUpdate, this.userId);
  }

  @Override
  public String toString() {
    return "PrescriptionRecord{" + "id=" + this.id + ", treatment id='" + this.treatmentId
    		+ "type=" + this.type + ", schedule='" + this.schedule + "description=" + this.description 
    		+ "last update=" + this.lastUpdate + ", user ID='" + this.userId + '\'' + '}';
  }
}