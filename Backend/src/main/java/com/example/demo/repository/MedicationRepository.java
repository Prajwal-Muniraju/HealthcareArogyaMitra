package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication , Integer>{

}
