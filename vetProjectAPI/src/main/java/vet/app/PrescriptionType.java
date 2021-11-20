package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class PrescriptionType {

  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  private String type;

  PrescriptionType() {}

  PrescriptionType(String type) {
    this.type = type;
  }

  public Integer getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof PrescriptionType))
      return false;
    PrescriptionType prescription = (PrescriptionType) o;
    return Objects.equals(this.id, prescription.id) && Objects.equals(this.type, prescription.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.type);
  }

  @Override
  public String toString() {
    return "PrescriptionType{" + "id=" + this.id + ", type='" + this.type + '\'' + '}';
  }
}