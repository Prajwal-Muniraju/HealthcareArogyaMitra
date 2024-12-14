package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Admin")

public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Admin_ID")
    private int adminId;

    @Column(name = "Admin_Name", length = 50, nullable = false)
    @Size(min = 2, max = 50, message = "Admin name must be between 2 and 50 characters")
    private String adminName;

    @Column(name = "Admin_ContactInfo", length = 50)
    @Size(min = 2, max = 50, message = "Contact info must be between 2 and 50 characters")
    private String adminContactInfo;

    @Column(name = "Admin_Email", length = 50, nullable = false)
    @Email(message = "Invalid email format")
    private String adminEmail;

    @Column(name = "Admin_UserName", length = 50, nullable = false)
    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    private String adminUserName;

    @Column(name = "Admin_Password", length = 50, nullable = false)
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
    private String adminPassword;

    @Column(name = "Admin_LastLogin")
    private LocalDateTime adminLastLogin;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContactInfo() {
		return adminContactInfo;
	}

	public void setAdminContactInfo(String adminContactInfo) {
		this.adminContactInfo = adminContactInfo;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public LocalDateTime getAdminLastLogin() {
		return adminLastLogin;
	}

	public void setAdminLastLogin(LocalDateTime adminLastLogin) {
		this.adminLastLogin = adminLastLogin;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContactInfo=" + adminContactInfo
				+ ", adminEmail=" + adminEmail + ", adminUserName=" + adminUserName + ", adminLastLogin="
				+ adminLastLogin + "]";
	}

	
	
}
