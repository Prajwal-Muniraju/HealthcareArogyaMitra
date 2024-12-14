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

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/admin/")
//@CrossOrigin(origins = "http://localhost:5005/")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<Admin> addAdmin(@Valid@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.CREATED);
	}

	@PostMapping("login")
	public ResponseEntity<Admin> loginAdmin(@Valid@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin), HttpStatus.OK);
	}

	@GetMapping
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@GetMapping("{adminid}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("adminid") int adminid)// used to read the data
																						// which is passing thru url
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(adminid), HttpStatus.OK);
	}

	@DeleteMapping("{adminid}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("adminid") int adminid) {
		return new ResponseEntity<String>(adminService.deleteAdminById(adminid), HttpStatus.OK);
	}

	@PutMapping("{adminid}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable("adminid") int adminid, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.updateAdminById(adminid, admin), HttpStatus.OK);

	}

}
