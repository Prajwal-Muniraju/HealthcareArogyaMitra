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

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/staff/")
//@CrossOrigin(origins="")

public class StaffController {

	@Autowired
	private StaffService staffService;
	
	
	@PostMapping
	public ResponseEntity<Staff> addStaff(@Valid@RequestBody Staff staff)
	{
		return new ResponseEntity<Staff>(staffService.addStaff(staff),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Staff> getAllStaff()
	{
		return staffService.getAllStaff();
	}
	
	@GetMapping("{staffid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Staff> getStaffById(@PathVariable("staffid") int staffid)
	{
		return new ResponseEntity<Staff>(staffService.getStaffById(staffid),HttpStatus.OK);
	}
	
	@DeleteMapping("{staffid}")
	public ResponseEntity<String> deleteStaffById(@PathVariable("staffid") int staffid) {
		return new ResponseEntity<String>(staffService.deleteStaffById(staffid), HttpStatus.OK);
	}
 
	@PutMapping("{staffid}")
	public ResponseEntity<Staff> updateStaffById(@PathVariable("staffid") int staffid,
			@RequestBody Staff staff) {
		return new ResponseEntity<Staff>(staffService.updateStaffById(staffid, staff), HttpStatus.OK);

	}
}
