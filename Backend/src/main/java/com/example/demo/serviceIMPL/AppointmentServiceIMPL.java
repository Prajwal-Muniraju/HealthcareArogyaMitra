package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;

@Service
public class AppointmentServiceIMPL implements AppointmentService{
	
	@Autowired
    private AppointmentRepository appointmentRepository;
	
	
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}

	
	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(appointmentid).get();
	}

	@Override
	public String deleteAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		Appointment appointment = getAppointmentById(appointmentid);// to check the id is present in the table or not
		appointmentRepository.deleteById(appointment.getAppId());
				return "record deleted successfully";
	}

	@Override
	public Appointment updateAppointmentById(int appointmentid, Appointment appointment) {
		// TODO Auto-generated method stub
		Appointment appointment1 = getAppointmentById(appointmentid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return appointmentRepository.save(appointment1);
	}

}
