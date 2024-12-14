package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;

@Service
public class StaffServiceIMPL implements StaffService {
	
	@Autowired
    private StaffRepository staffRepository;

	@Override
	public Staff addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(int Staffid) {
		// TODO Auto-generated method stub
		return staffRepository.findById(Staffid).get();
	}

	@Override
	public String deleteStaffById(int Staffid) {
		// TODO Auto-generated method stub
		Staff staff = getStaffById(Staffid);// to check the id is present in the table or not
		staffRepository.deleteById(staff.getStaffId());
				return "record deleted successfully";
	}

	@Override
	public Staff updateStaffById(int Staffid, Staff Staff) {
		// TODO Auto-generated method stub
		Staff staff1 = getStaffById(Staffid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return staffRepository.save(staff1);
	}
	
	

}
