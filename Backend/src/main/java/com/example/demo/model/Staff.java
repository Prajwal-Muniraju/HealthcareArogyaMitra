package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Staffs")
public class Staff {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Staff_ID")
    private int staffId;

    @NotNull(message = "Staff name is mandatory")
    @Size(max = 100, message = "Staff name cannot exceed 100 characters")
    @Column(name = "Staff_Name")
    private String staffName;

    @NotNull(message = "Staff role is mandatory")
    @Size(max = 50, message = "Staff role cannot exceed 50 characters")
    @Column(name = "Staff_Role")
    private String staffRole;

    @Size(min = 10, max = 10, message = "Contact info must be exactly 10 characters") 
    @Column(name = "Staff_Contact_Info") 
    private String staffContactInfo;


    @NotNull(message = "Staff salary is mandatory")
    @Digits(integer = 10, fraction = 2, message = "Salary must be a valid monetary value")
    @Column(name = "Staff_Salary")
    private BigDecimal staffSalary; 

    @Size(max = 255, message = "Schedule details cannot exceed 255 characters")
    @Column(name = "Staff_Schedule")
    private String scheduleDetails;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	public String getStaffContactInfo() {
		return staffContactInfo;
	}

	public void setStaffContactInfo(String staffContactInfo) {
		this.staffContactInfo = staffContactInfo;
	}

	public BigDecimal getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(BigDecimal staffSalary) {
		this.staffSalary = staffSalary;
	}

	public String getScheduleDetails() {
		return scheduleDetails;
	}

	public void setScheduleDetails(String scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffRole=" + staffRole
				+ ", staffContactInfo=" + staffContactInfo + ", staffSalary=" + staffSalary + ", scheduleDetails="
				+ scheduleDetails + "]";
	} 
    
    
}
