package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceIMPL implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	private Doctor doctor;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int doctorid) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctorid).get();
	}

	@Override
	public String deleteDoctorById(int doctorid) {
		// TODO Auto-generated method stub
		Doctor doctor = getDoctorById(doctorid);// to check the id is present in the table or not
		doctorRepository.deleteById(doctor.getDoctorId());
		return "record deleted successfully";
	}

	@Override
	public Doctor updateDoctorById(int doctorid, Doctor Doctor) {
		// TODO Auto-generated method stub
		Doctor doctor1 = getDoctorById(doctorid);// to check the id is present in the table or not
		doctor1.setDoctorName(doctor.getDoctorName());
		doctor1.setDoctorUsername(doctor.getDoctorUsername());
		doctor1.setDoctorPassword(doctor.getDoctorPassword());
		doctor1.setDoctorContactInfo(doctor.getDoctorContactInfo());
		doctor1.setDoctorEmail(doctor.getDoctorEmail());
		
		return doctorRepository.save(doctor1);
		
	}

	@Override
	public Doctor loginDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDoctorUsernameAndDoctorPassword(doctor.getDoctorName(), (String) doctor.getDoctorPassword());
	}

}