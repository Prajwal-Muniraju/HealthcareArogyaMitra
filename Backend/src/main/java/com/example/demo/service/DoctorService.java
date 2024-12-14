package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getAllDoctor();

	public Doctor getDoctorById(int doctorid);

	public String deleteDoctorById(int doctorid);

	public Doctor updateDoctorById(int doctorid, Doctor doctor);

	public Doctor loginDoctor(Doctor doctor);
	
}
