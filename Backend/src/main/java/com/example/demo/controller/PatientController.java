package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/patient/")
@CrossOrigin(origins="http://localhost:4200")

public class PatientController 
{
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping
	public ResponseEntity<Patient> addPatient(@Valid@RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.addPatient(patient),HttpStatus.CREATED);
	}
	
	
	@PostMapping("login")
	public ResponseEntity<Patient> loginPatient(@Valid@RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.loginPatient(patient),HttpStatus.OK);
	}
	
	
	@GetMapping
	public List<Patient> getAllPatients()
	{
		return patientService.getAllPatient();
	}
	
	@GetMapping("{patientid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Patient> getPatientById(@PathVariable("patientid") int patientid)
	{
		return new ResponseEntity<Patient>(patientService.getPatientById(patientid),HttpStatus.OK);
	}
	
	@DeleteMapping("{patientid}")
	public ResponseEntity<String> deletePatientById(@PathVariable("patientid") int patientid) {
		return new ResponseEntity<String>(patientService.deletePatientById(patientid), HttpStatus.OK);
	}
 
	@PutMapping("{patientid}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable("patientid") int patientid,
			@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.updatePatientById(patientid, patient), HttpStatus.OK);

	}
	
}
