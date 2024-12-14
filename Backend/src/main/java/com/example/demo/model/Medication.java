package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name ="Medication")
public class Medication {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Medication_ID")
    private int medicationId;

    @NotBlank(message = "Medication name cannot be blank")
    @Size(max = 100, message = "Medication name cannot exceed 100 characters")
    @Column(name = "Medication_Name")
    private String medicationName;

    @NotBlank(message = "Medication category cannot be blank")
    @Size(max = 50, message = "Medication category cannot exceed 50 characters")
    @Column(name = "Medication_Category")
    private String medicationCategory;

    @NotNull(message = "Medication price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid price format")
    @Column(name = "Medication_Price")
    private BigDecimal medicationPrice;

    @NotNull(message = "Stock quantity is mandatory")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    @Column(name = "Stock_Quantity")
    private int stockQuantity;

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getMedicationCategory() {
		return medicationCategory;
	}

	public void setMedicationCategory(String medicationCategory) {
		this.medicationCategory = medicationCategory;
	}

	public BigDecimal getMedicationPrice() {
		return medicationPrice;
	}

	public void setMedicationPrice(BigDecimal medicationPrice) {
		this.medicationPrice = medicationPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Medication [medicationId=" + medicationId + ", medicationName=" + medicationName
				+ ", medicationCategory=" + medicationCategory + ", medicationPrice=" + medicationPrice
				+ ", stockQuantity=" + stockQuantity + "]";
	}
    
    
}
