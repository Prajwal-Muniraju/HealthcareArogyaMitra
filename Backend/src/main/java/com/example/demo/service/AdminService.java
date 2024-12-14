package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public List<Admin> getAllAdmin();

	public Admin getAdminById(int adminid);

	public String deleteAdminById(int adminid);

	public Admin updateAdminById(int adminid, Admin admin);

	public Admin loginAdmin(Admin admin);
}
