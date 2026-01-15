package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Medication;

public interface MedicationRepo extends JpaRepository<Medication, Long> {
	
	

}
