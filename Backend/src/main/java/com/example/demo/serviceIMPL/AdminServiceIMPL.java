package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceIMPL implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
		}
	
	
	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
	@Override
	public Admin getAdminById(int adminid) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminid).get();
	}
	
	@Override
	public String deleteAdminById(int adminid) {
		// TODO Auto-generated method stub
		Admin admin = getAdminById(adminid);// to check the id is present in the table or not
		adminRepository.deleteById(admin.getAdminId());
		return "record deleted successfully";
	}
	@Override
	public Admin updateAdminById(int adminid, Admin admin) {
		// TODO Auto-generated method stub
		Admin admin1 = getAdminById(adminid);// to check the id is present in the table or not
		admin1.setAdminName(admin.getAdminName());
		admin1.setAdminName(admin.getAdminName());
		admin1.setAdminPassword(admin.getAdminPassword());
		admin1.setAdminContactInfo(admin.getAdminContactInfo());
		admin1.setAdminEmail(admin.getAdminEmail());
		
		return adminRepository.save(admin1);
	}
	@Override
	public Admin loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminUserNameAndAdminPassword(admin.getAdminName(), (String) admin.getAdminPassword());
	}
	
	
}
