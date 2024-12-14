package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Medication;

public interface MedicationService {

	public Medication addMedication(Medication medication);
	
	public List<Medication> getAllMedication();
	
	public Medication getMedicationById(int medicationid);
	
	public String deleteMedicationById(int medicationid );
	
	public Medication updateMedicationById(int medicationid,Medication medication );
}
