package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Billing;

public interface BillingRepository extends JpaRepository<Billing , Integer> {

}
