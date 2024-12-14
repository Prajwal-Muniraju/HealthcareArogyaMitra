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

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/doctor/")
@CrossOrigin(origins = "http://localhost:4200/")
public class DoctorController {
//controller --accept the request process and response

	// abstraction
	@Autowired
	private DoctorService doctorService;

	@PostMapping
	public ResponseEntity<Doctor> addDoctor(@Valid@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
	}

	@PostMapping("login")
	public ResponseEntity<Doctor> loginDoctor(@Valid@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.loginDoctor(doctor), HttpStatus.OK);
	}

	@GetMapping
	public List<Doctor> getAllDoctor() {
		return doctorService.getAllDoctor();
	}

	@GetMapping("{doctorid}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorid") int doctorid)// used to read the data
																						// which is passing thru url
	{
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorid), HttpStatus.OK);
	}

	@DeleteMapping("{doctorid}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("doctorid") int doctorid) {
		return new ResponseEntity<String>(doctorService.deleteDoctorById(doctorid), HttpStatus.OK);
	}

	@PutMapping("{doctorid}")
	public ResponseEntity<Doctor> updateDoctorById(@PathVariable("doctorid") int doctorid, @RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.updateDoctorById(doctorid, doctor), HttpStatus.OK);

	}

}