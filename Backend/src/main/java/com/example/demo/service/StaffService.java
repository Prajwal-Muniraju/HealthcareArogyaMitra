package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffService {

public Staff addStaff(Staff staff);
	
	public List<Staff> getAllStaff();
	
	public Staff getStaffById(int Staffid);
	
	public String deleteStaffById(int Staffid );
	
	public Staff updateStaffById(int Staffid,Staff Staff );
}
