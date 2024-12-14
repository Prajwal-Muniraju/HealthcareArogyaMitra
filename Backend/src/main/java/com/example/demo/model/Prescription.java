package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Prescriptions")
public class Prescription {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prescription_ID")
    private int prescriptionId;

    @NotNull(message = "Prescription date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    @Column(name = "Prescription_Date")
    private LocalDate prescriptionDate; 

    @NotBlank(message = "Medicine list cannot be empty")
    @Size(max = 1000, message = "Medicine list cannot exceed 1000 characters")
    @Column(name = "Medicine_List")
    private String medicineList; 

    @NotBlank(message = "Dosage cannot be empty")
    @Size(max = 1000, message = "Dosage cannot exceed 500 characters")
    @Column(name = "Dosage")
    private String dosage;
    
    @ManyToOne
    @JoinColumn(name="pid", referencedColumnName="Patient_Id")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name="doctorId" , referencedColumnName="Doctor_Id")
    private Doctor doctor;
    
    

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(String medicineList) {
		this.medicineList = medicineList;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getPatientIdfromPrescription() {
		if(this.patient!=null) {
			return this.patient.getPid();
		}
		return 1;
	}
	
	public int getDoctorIdfromPrescription() {
		if(this.doctor!=null) {
			return this.doctor.getDoctorId();
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", prescriptionDate=" + prescriptionDate
				+ ", medicineList=" + medicineList + ", dosage=" + dosage + ", patient=" + patient + ", doctor="
				+ doctor + "]";
	}

	
    
    
}
