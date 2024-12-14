package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService 
{
	public Patient addPatient(Patient patient);
	
	public List<Patient> getAllPatient();
	
	public Patient getPatientById(int patientid);
	
	public String deletePatientById(int patientid );
	
	public Patient updatePatientById(int patientid,Patient patient );
	
	public Patient loginPatient(Patient patient );
	
}
