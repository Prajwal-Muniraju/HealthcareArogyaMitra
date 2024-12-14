package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;

public interface AppointmentService {
	
	public Appointment addAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointment();
	
	public Appointment getAppointmentById(int appointmentid);
	
	public String deleteAppointmentById(int appointmentid );
	
	public Appointment updateAppointmentById(int appointmentid,Appointment appointment );


}
