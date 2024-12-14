package com.example.demo.service;

import java.util.List;

import com.example.demo.model.LabTest;

public interface LabTestService {
	
	public LabTest addLabTest(LabTest labTest);
	
	public List<LabTest> getAllLabTest();
	
	public LabTest getLabTestById(int labTestid);
	
	public String deleteLabTestById(int labTestid );
	
	public LabTest updateLabTestById(int labTestid,LabTest labTest );
	
	
}
