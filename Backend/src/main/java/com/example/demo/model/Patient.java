package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Patient_InFo")
public class Patient 
{
	@Id
    @Column(name = "Patient_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(name = "Patient_Name", length = 50)
    @Size(min = 2, max = 50, message = "Patient name must be between 2 and 50 characters")
    private String pname;

    @Column(name = "Gender", length = 10)
    @Pattern(regexp = "^(Male|Female|Non-Binary|Other)$", message = "Gender must be Male, Female, Non-Binary, or Other")
    private String gender; 

    @Column(name = "DateOfBirth")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in the format yyyy-MM-dd")
    private LocalDate dob; 
    
    @Column(name = "Patient_Address", length = 255) // Adjust length as per your requirement
    @Pattern(
        regexp = "^[a-zA-Z0-9\\s,.-]+$", 
        message = "Address must contain only letters, numbers, spaces, commas, periods, or hyphens"
    )
    private String patientAddress;
    

    @Column(name = "Contact_Number", length = 15, unique = true)
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Contact number must be exactly 10 digits")
    private String contInfo; 

    @Column(name = "Insurance_Details", length = 50)
    private String insurance_Info;

    @Column(name = "Patient_UserName", length = 20, unique = true)
    private String patientUsername;

    @Column(name = "Patient_Password", length = 20, nullable = false) 
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$", 
        message = "Password must be 8-20 characters long, with at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String patientPassword;

    
	

	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getContInfo() {
		return contInfo;
	}

	public void setContInfo(String contInfo) {
		this.contInfo = contInfo;
	}

	public String getInsurance_Info() {
		return insurance_Info;
	}

	public void setInsurance_Info(String insurance_Info) {
		this.insurance_Info = insurance_Info;
	}

	public String getPatientUsername() {
		return patientUsername;
	}

	public void setPatientUsername(String patientUsername) {
		this.patientUsername = patientUsername;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}


	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", gender=" + gender + ", dob=" + dob + ", patientAddress="
				+ patientAddress + ", contInfo=" + contInfo + ", insurance_Info=" + insurance_Info
				+ ", patientUsername=" + patientUsername + "]";
	}




	
			
}
