package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Prescription;
import com.example.demo.service.PrescriptionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/prescription/")
//@CrossOrigin(origins="")

public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;
	
	
	@PostMapping
	public ResponseEntity<Prescription> addPrescription(@Valid@RequestBody Prescription prescription)
	{
		return new ResponseEntity<Prescription>(prescriptionService.addPrescription(prescription),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Prescription> getAllPrescription()
	{
		return prescriptionService.getAllPrescription();
	}
	
	@GetMapping("{roomid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("prescriptionid") int prescriptionid)
	{
		return new ResponseEntity<Prescription>(prescriptionService.getPrescriptionById(prescriptionid),HttpStatus.OK);
	}
	
	@DeleteMapping("{prescriptionid}")
	public ResponseEntity<String> deletePrescriptionById(@PathVariable("prescriptionid") int prescriptionid) {
		return new ResponseEntity<String>(prescriptionService.deletePrescriptionById(prescriptionid), HttpStatus.OK);
	}
 
	@PutMapping("{prescriptionid}")
	public ResponseEntity<Prescription> updatePrescriptionById(@PathVariable("prescriptionid") int prescriptionid,
			@RequestBody Prescription prescription) {
		return new ResponseEntity<Prescription>(prescriptionService.updatePrescriptionById(prescriptionid, prescription), HttpStatus.OK);

	}
}
