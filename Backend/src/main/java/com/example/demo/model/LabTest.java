package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Lab_Test")

public class LabTest 
{
	@Id
    @Column(name = "Lab_Test_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labId;
	
//	@ManyToOne
//    @JoinColumn(name = "Patient_Id", nullable = false) // Foreign key column in LabTest table
//    private Patient patient;

    @Column(name = "Test_Type", length = 50, nullable = false)
    @NotBlank(message = "Test type is mandatory")
    @Size(max = 50, message = "Test type cannot exceed 50 characters")
    private String labTest;

    @Column(name = "Test_Result", length = 1, nullable = false)
    @NotNull(message = "Test result is mandatory")
    @Pattern(regexp = "[PN]", message = "Test result must be 'P' (Positive) or 'N' (Negative)")
    private String labResult; 

    @Column(name = "Test_Date", nullable = false)
    @NotNull(message = "Test date is mandatory")
    private LocalDateTime labTestDate;

    @Column(name = "Diagnosis", length = 50, nullable = false)
    @NotBlank(message = "Diagnosis is mandatory")
    @Size(max = 50, message = "Diagnosis cannot exceed 50 characters")
    private String diagnosis;
    
    @ManyToOne
    @JoinColumn(name="pid", referencedColumnName="Patient_Id")
    private Patient patient;
    

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}

	public String getLabTest() {
		return labTest;
	}

	public void setLabTest(String labTest) {
		this.labTest = labTest;
	}

	public String getLabResult() {
		return labResult;
	}

	public void setLabResult(String labResult) {
		this.labResult = labResult;
	}

	public LocalDateTime getLabTestDate() {
		return labTestDate;
	}

	public void setLabTestDate(LocalDateTime labTestDate) {
		this.labTestDate = labTestDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	

	public int getPatientIdfromLabTest() {
		if(this.patient!=null) {
			return this.patient.getPid();
		}
		return 1;
	}

	@Override
	public String toString() {
		return "LabTest [labId=" + labId + ", labTest=" + labTest + ", labResult=" + labResult + ", labTestDate="
				+ labTestDate + ", diagnosis=" + diagnosis + ", patient=" + patient + "]";
	}
	

	
	
}
