package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Billing")
public class Billing {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Billing_ID")
    private int billId;

    @NotNull(message = "Total amount is mandatory")
    @Digits(integer = 10, fraction = 2, message = "Amount must be a valid monetary value")
    @Column(name = "Total_Amount")
    private BigDecimal billAmount; // Changed to BigDecimal

    @NotNull(message = "Billing date is mandatory")
    @Column(name = "Date_Of_Billing")
    private LocalDate billDate; // Changed to LocalDate for proper date handling

    @NotNull(message = "Insurance claimed status is mandatory")
    @Column(name = "Insurance_Claimed")
    private boolean billInsurance; 

    @NotNull(message = "Payment status is mandatory")
    @Size(max = 20, message = "Payment status cannot exceed 20 characters")
    @Column(name = "Payment_Status")
    private String billStatus;
    
    @ManyToOne
    @JoinColumn(name="pid", referencedColumnName="Patient_Id")
    private Patient patient;
    

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public boolean isBillInsurance() {
		return billInsurance;
	}

	public void setBillInsurance(boolean billInsurance) {
		this.billInsurance = billInsurance;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	

	public int getPatientIdfromBilling() {
		if(this.patient!=null) {
			return this.patient.getPid();
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Billing [billId=" + billId + ", billAmount=" + billAmount + ", billDate=" + billDate
				+ ", billInsurance=" + billInsurance + ", billStatus=" + billStatus + ", patient=" + patient + "]";
	}
	

	
	
	
    
	
}
