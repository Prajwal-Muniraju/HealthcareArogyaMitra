package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Billing;


public interface BillingService {

	public Billing addBilling(Billing billing);
	
	public List<Billing> getAllBilling();
	
	public Billing getBillingById(int billingid);
	
	public String deleteBillingById(int billingid );
	
	public Billing updateBillingById(int billingid,Billing billing );
}
