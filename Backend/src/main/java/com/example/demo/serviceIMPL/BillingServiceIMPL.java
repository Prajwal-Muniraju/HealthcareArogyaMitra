package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Billing;
import com.example.demo.repository.BillingRepository;
import com.example.demo.service.BillingService;

@Service
public class BillingServiceIMPL implements BillingService{


	@Autowired
    private BillingRepository billingRepository;
	
	@Override
	public Billing addBilling(Billing billing) {
		// TODO Auto-generated method stub
		return billingRepository.save(billing);
	}

	@Override
	public List<Billing> getAllBilling() {
		// TODO Auto-generated method stub
		return billingRepository.findAll();
	}

	@Override
	public Billing getBillingById(int billingid) {
		// TODO Auto-generated method stub
		return billingRepository.findById(billingid).get();
	}

	@Override
	public String deleteBillingById(int billingid) {
		// TODO Auto-generated method stub
		Billing billing = getBillingById(billingid);// to check the id is present in the table or not
		billingRepository.deleteById(billing.getBillId());
				return "record deleted successfully";
	}

	@Override
	public Billing updateBillingById(int billingid, Billing billing) {
		// TODO Auto-generated method stub
		Billing billing1 = getBillingById(billingid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return billingRepository.save(billing1);
	}

	
}
