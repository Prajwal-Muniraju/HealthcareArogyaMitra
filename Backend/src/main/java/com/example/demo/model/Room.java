package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Rooms")

public class Room {


	@Id
    @Column(name = "Room_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
	
	
	 @Column(name = "Room_Type")
	 private String roomType;
	 
	 @Column(name = "Availability_Status")
	 private String status;
	 
	 @ManyToOne
	    @JoinColumn(name="pid", referencedColumnName="Patient_Id")
	    private Patient patient;
	 
	 

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getPatientIdfromRoom() {
		if(this.patient!=null) {
			return this.patient.getPid();
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", status=" + status + ", patient=" + patient
				+ "]";
	}

	 
	
}
