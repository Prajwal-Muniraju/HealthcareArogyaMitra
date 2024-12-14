package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Appointments")

public class Appointment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_ID")
    private int appId;

    @NotNull(message = "Appointment date is mandatory")
    @Column(name = "Appointment_Date")
    private LocalDate appDate; 

    
    @Column(name = "Appointment_Status")
    private String appStatus;

    @Size(max = 500, message = "Diagnosis description should not exceed 500 characters")
    @Column(name = "Appointment_Diagnosis")
    private String appDiagnosis;

    @Size(max = 500, message = "Prescription should not exceed 500 characters")
    @Column(name = "Appointment_Prescription")
    private String appPrescription;
    
    @ManyToOne
    @JoinColumn(name="pid", referencedColumnName="Patient_Id")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name="doctorId" , referencedColumnName="Doctor_Id")
    private Doctor doctor;
    
    
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getAppDiagnosis() {
		return appDiagnosis;
	}

	public void setAppDiagnosis(String appDiagnosis) {
		this.appDiagnosis = appDiagnosis;
	}

	public String getAppPrescription() {
		return appPrescription;
	}

	public void setAppPrescription(String appPrescription) {
		this.appPrescription = appPrescription;
	}
	
	public int getPatientIdfromAppointment() {
		if(this.patient!=null) {
			return this.patient.getPid();
		}
		return 1;
	}
	
	public int getDoctorIdfromAppointment() {
		if(this.doctor!=null) {
			return this.doctor.getDoctorId();
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ", appDate=" + appDate + ", appStatus=" + appStatus + ", appDiagnosis="
				+ appDiagnosis + ", appPrescription=" + appPrescription + ", patient=" + patient + ", doctor=" + doctor
				+ "]";
	}
 
    
}
