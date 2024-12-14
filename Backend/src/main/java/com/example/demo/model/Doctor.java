package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "Doctor_Table")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Doctor_Id")
    private int doctorId; 

    @Column(name = "Doctor_Name", length = 50, nullable = false)
    @Pattern(
        regexp = "^[A-Za-z\\s]{2,50}$", 
        message = "Doctor name must contain only letters and spaces, and be 2-50 characters long"
    )
    private String doctorName; 

    @Column(name = "Doctor_Specialization", length = 50, nullable = false)
    @Pattern(
        regexp = "^[A-Za-z\\s]{2,50}$", 
        message = "Specialization must contain only letters and spaces, and be 2-50 characters long"
    )
    private String doctorSpecialization;

    @Column(name = "Doctor_Email", length = 50, unique = true, nullable = false)
    @Email(message = "Please provide a valid email address")
    private String doctorEmail; 

    @Column(name = "Doctor_Contact_Info", length = 15, unique = true, nullable = false)
    @Pattern(
        regexp = "^[6-9][0-9]{9}$", 
        message = "Contact number must be 10 digits and start with 6, 7, 8, or 9"
    )
    private String doctorContactInfo; 

    @Column(name = "Doctor_Schedule", length = 50, nullable = false)
    private String doctorSchedule; 

    @Column(name = "Doctor_Username", length = 50, unique = true, nullable = false)
    @Pattern(
        regexp = "^[a-zA-Z0-9._-]{5,50}$", 
        message = "Username must be alphanumeric and 5-50 characters long"
    )
    private String doctorUsername;

    @Column(name = "Doctor_Password", length = 20, nullable = false)
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$", 
        message = "Password must be 8-20 characters long, with at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String doctorPassword;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorContactInfo() {
		return doctorContactInfo;
	}

	public void setDoctorContactInfo(String doctorContactInfo) {
		this.doctorContactInfo = doctorContactInfo;
	}

	public String getDoctorSchedule() {
		return doctorSchedule;
	}

	public void setDoctorSchedule(String doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorEmail=" + doctorEmail + ", doctorContactInfo=" + doctorContactInfo
				+ ", doctorSchedule=" + doctorSchedule + ", doctorUsername=" + doctorUsername + "]";
	}
    
    
    
}
