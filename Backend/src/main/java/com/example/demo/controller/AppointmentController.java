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

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/appointment/")
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping
	public ResponseEntity<Appointment> addAppointment(@Valid@RequestBody Appointment appointment)
	{
		return new ResponseEntity<Appointment>(appointmentService.addAppointment(appointment),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Appointment> getAllAppointment()
	{
		return appointmentService.getAllAppointment();
	}
	
	@GetMapping("{appointmentid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("appointmentid") int appointmentid)
	{
		return new ResponseEntity<Appointment>(appointmentService.getAppointmentById(appointmentid),HttpStatus.OK);
	}
	
	@DeleteMapping("{appointmentid}")
	public ResponseEntity<String> deleteAppointmentById(@PathVariable("appointmentid") int appointmentid) {
		return new ResponseEntity<String>(appointmentService.deleteAppointmentById(appointmentid), HttpStatus.OK);
	}
 
	@PutMapping("{appointmentid}")
	public ResponseEntity<Appointment> updateAppointmentById(@PathVariable("appointmentid") int appointmentid,
			@RequestBody Appointment appointment) {
		return new ResponseEntity<Appointment>(appointmentService.updateAppointmentById(appointmentid, appointment), HttpStatus.OK);

	}
}
