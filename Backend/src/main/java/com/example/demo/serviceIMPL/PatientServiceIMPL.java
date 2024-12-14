package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceIMPL implements PatientService
{
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int patientid) {
		// TODO Auto-generated method stub
		return patientRepository.findById(patientid).get();
	}

	@Override
	public String deletePatientById(int patientid) {
		// TODO Auto-generated method stub
		Patient patient = getPatientById(patientid);// to check the id is present in the table or not
		patientRepository.deleteById(patient.getPid());
		return "record deleted successfully";
	}

	@Override
	public Patient updatePatientById(int patientid, Patient patient) {
		// TODO Auto-generated method stub
		Patient patient1 = getPatientById(patientid);// to check the id is present in the table or not
		patient1.setPname(patient.getPname());
		patient1.setPatientUsername(patient.getPatientUsername());
		patient1.setContInfo(patient.getContInfo());
		patient1.setInsurance_Info(patient.getInsurance_Info());
		patient1.setPatientPassword(patient.getPatientPassword());
		return patientRepository.save(patient1);
	}

	@Override
	public Patient loginPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.findByPatientUsernameAndPatientPassword(patient.getPatientUsername(), patient.getPatientPassword());
	}
	
	
	
	
	
}
