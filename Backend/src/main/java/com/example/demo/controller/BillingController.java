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

import com.example.demo.model.Billing;
import com.example.demo.service.BillingService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/billing/")
//@CrossOrigin(origins="")

public class BillingController {

	@Autowired
	private BillingService billingService;
	
	
	@PostMapping
	public ResponseEntity<Billing> addBilling(@Valid@RequestBody Billing billing)
	{
		return new ResponseEntity<Billing>(billingService.addBilling(billing),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Billing> getAllBilling()
	{
		return billingService.getAllBilling();
	}
	
	@GetMapping("{billingid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Billing> getBillingById(@PathVariable("billingid") int billingid)
	{
		return new ResponseEntity<Billing>(billingService.getBillingById(billingid),HttpStatus.OK);
	}
	
	@DeleteMapping("{billingid}")
	public ResponseEntity<String> deleteBillingById(@PathVariable("billingid") int billingid) {
		return new ResponseEntity<String>(billingService.deleteBillingById(billingid), HttpStatus.OK);
	}
 
	@PutMapping("{billingid}")
	public ResponseEntity<Billing> updateBillingById(@PathVariable("billingid") int billingid,
			@RequestBody Billing billing) {
		return new ResponseEntity<Billing>(billingService.updateBillingById(billingid, billing), HttpStatus.OK);

	}
}
