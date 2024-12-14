package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medication;
import com.example.demo.service.MedicationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/medication/")
@CrossOrigin(origins="http://localhost:4200")

public class MedicationController {

	@Autowired
	private MedicationService medicationService;
	
	@PostMapping
	public ResponseEntity<Medication> addMedication(@Valid@RequestBody Medication medication)
	{
		return new ResponseEntity<Medication>(medicationService.addMedication(medication),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Medication> getAllMedication()
	{
		return medicationService.getAllMedication();
	}
	
	@GetMapping("{medicationid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Medication> getMedicationById(@PathVariable("medicationid") int medicationid)
	{
		return new ResponseEntity<Medication>(medicationService.getMedicationById(medicationid),HttpStatus.OK);
	}
	
	@DeleteMapping("{medicationid}")
	public ResponseEntity<String> deleteMedicationById(@PathVariable("medicationid") int medicationid) {
		return new ResponseEntity<String>(medicationService.deleteMedicationById(medicationid), HttpStatus.OK);
	}
 
	@PutMapping("{medicationid}")
	public ResponseEntity<Medication> updateMedicationById(@PathVariable("medicationid") int medicationid,
			@RequestBody Medication medication) {
		return new ResponseEntity<Medication>(medicationService.updateMedicationById(medicationid, medication), HttpStatus.OK);

	}
}
