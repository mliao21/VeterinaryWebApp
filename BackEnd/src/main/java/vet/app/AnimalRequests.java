package vet.app;

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
public class AnimalRequests {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long requestID;
	private long animalID;
	private long userID;
	private String requestStatus;
	
//	public AnimalRequests() {}
//
//	public AnimalRequests(Long requestID, long animalID, long userID, String requestStatus) {
//		this.requestID = requestID;
//		this.animalID = animalID;
//		this.userID = userID;
//		this.requestStatus = requestStatus;
//	}
//
//	public Long getRequestID() {
//		return requestID;
//	}
//
//	public void setRequestID(Long requestID) {
//		this.requestID = requestID;
//	}
//
//	public long getAnimalID() {
//		return animalID;
//	}
//
//	public void setAnimalID(long animalID) {
//		this.animalID = animalID;
//	}
//
//	public long getUserID() {
//		return userID;
//	}
//
//	public void setUserID(long userID) {
//		this.userID = userID;
//	}
//
//	public String getRequestStatus() {
//		return requestStatus;
//	}
//
//	public void setRequestStatus(String requestStatus) {
//		this.requestStatus = requestStatus;
//	}
//	
//	@Override
//	public boolean equals(Object o) {
//		
//		if (this == o)
//			return true;
//		if (!(o instanceof AnimalRequests))
//			return false;
//		AnimalRequests animal = (AnimalRequests) o;
//		return Objects.equals(this.requestID, animal.requestID) && Objects.equals(this.animalID, animal.animalID)
//				&& Objects.equals(this.userID, animal.userID)
//				&& Objects.equals(this.requestStatus, animal.requestStatus);
//		
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(this.requestID, this.animalID, this.userID,this.requestStatus);
//	}
//
//	@Override
//	public String toString() {
//
//		return "AnimalRequest{" + "id=" + this.requestID + ", User ID='" + this.userID + "', animal id='" + this.animalID + "', status='" 
//		+ this.requestStatus+  '\'' + '}';
//
//	}
//	
}
