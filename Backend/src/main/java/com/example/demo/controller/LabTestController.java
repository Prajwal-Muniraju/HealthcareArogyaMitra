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

import com.example.demo.model.LabTest;
import com.example.demo.service.LabTestService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/labTest/")
//@CrossOrigin(origins="")

public class LabTestController {
	
	@Autowired
	private LabTestService labTestService;
	
	
	@PostMapping
	public ResponseEntity<LabTest> addLabTest(@Valid@RequestBody LabTest labTest)
	{
		return new ResponseEntity<LabTest>(labTestService.addLabTest(labTest),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<LabTest> getAllLabTest()
	{
		return labTestService.getAllLabTest();
	}
	
	@GetMapping("{labTestid}")
	//used to read the data which is passing through URL
	public ResponseEntity<LabTest> getLabTestById(@PathVariable("labTestid") int labTestid)
	{
		return new ResponseEntity<LabTest>(labTestService.getLabTestById(labTestid),HttpStatus.OK);
	}
	
	@DeleteMapping("{labTestid}")
	public ResponseEntity<String> deleteLabTestById(@PathVariable("labTestid") int labTestid) {
		return new ResponseEntity<String>(labTestService.deleteLabTestById(labTestid), HttpStatus.OK);
	}
 
	@PutMapping("{labTestid}")
	public ResponseEntity<LabTest> updateLabTestById(@PathVariable("labTestid") int labTestid,
			@RequestBody LabTest labTest) {
		return new ResponseEntity<LabTest>(labTestService.updateLabTestById(labTestid, labTest), HttpStatus.OK);

	}

}
