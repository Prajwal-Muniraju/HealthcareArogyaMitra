package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.LabTest;
import com.example.demo.repository.LabTestRepository;
import com.example.demo.service.LabTestService;

@Service
public class LabTestServiceIMPL implements LabTestService {

	@Autowired
    private LabTestRepository labTestRepository;
	
	@Override
	public LabTest addLabTest(LabTest labTest) {
		// TODO Auto-generated method stub
		return labTestRepository.save(labTest);
	}

	@Override
	public List<LabTest> getAllLabTest() {
		// TODO Auto-generated method stub
		return labTestRepository.findAll();
	}

	@Override
	public LabTest getLabTestById(int labTestid) {
		// TODO Auto-generated method stub
		return labTestRepository.findById(labTestid).get();
	}

	@Override
	public String deleteLabTestById(int labTestid) {
		// TODO Auto-generated method stub
		LabTest labTest = getLabTestById(labTestid);// to check the id is present in the table or not
		labTestRepository.deleteById(labTest.getLabId());
		return "record deleted successfully";
	}

	@Override
	public LabTest updateLabTestById(int labTestid, LabTest labTest) {
		// TODO Auto-generated method stub
		LabTest labTest1 = getLabTestById(labTestid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return labTestRepository.save(labTest1);
	}
	
	
}
