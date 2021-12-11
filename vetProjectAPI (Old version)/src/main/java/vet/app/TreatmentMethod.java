package vet.app;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class TreatmentMethod {

  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
  private String type;

  TreatmentMethod() {}

  TreatmentMethod(String type) {
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
    if (!(o instanceof TreatmentMethod))
      return false;
    TreatmentMethod treatment = (TreatmentMethod) o;
    return Objects.equals(this.id, treatment.id) && Objects.equals(this.type, treatment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.type);
  }

  @Override
  public String toString() {
    return "TreatmentMethod{" + "id=" + this.id + ", type='" + this.type + '\'' + '}';
  }
}