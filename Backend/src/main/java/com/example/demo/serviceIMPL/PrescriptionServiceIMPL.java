package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.service.PrescriptionService;

@Service
public class PrescriptionServiceIMPL implements PrescriptionService{
	@Autowired
    private PrescriptionRepository prescriptionRepository;

	@Override
	public Prescription addPrescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return prescriptionRepository.save(prescription);
	}

	@Override
	public List<Prescription> getAllPrescription() {
		// TODO Auto-generated method stub
		return prescriptionRepository.findAll();
	}

	@Override
	public Prescription getPrescriptionById(int prescriptionid) {
		// TODO Auto-generated method stub
		return prescriptionRepository.findById(prescriptionid).get();
	}

	@Override
	public String deletePrescriptionById(int prescriptionid) {
		// TODO Auto-generated method stub
		Prescription prescription = getPrescriptionById(prescriptionid);// to check the id is present in the table or not
		prescriptionRepository.deleteById(prescription.getPrescriptionId());
				return "record deleted successfully";
	}

	@Override
	public Prescription updatePrescriptionById(int prescriptionid, Prescription prescription) {
		// TODO Auto-generated method stub
		Prescription prescription1 = getPrescriptionById(prescriptionid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return prescriptionRepository.save(prescription1);
	}
	
	
}
