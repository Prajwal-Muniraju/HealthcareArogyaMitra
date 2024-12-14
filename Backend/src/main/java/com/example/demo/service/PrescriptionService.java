package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Prescription;

public interface PrescriptionService {

	public Prescription addPrescription(Prescription prescription);
	
	public List<Prescription> getAllPrescription();
	
	public Prescription getPrescriptionById(int prescriptionid);
	
	public String deletePrescriptionById(int prescriptionid );
	
	public Prescription updatePrescriptionById(int prescriptionid,Prescription prescription );
}
