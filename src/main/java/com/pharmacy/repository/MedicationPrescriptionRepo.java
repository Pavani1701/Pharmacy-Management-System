package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.MedicationPrescription;

public interface MedicationPrescriptionRepo extends JpaRepository<MedicationPrescription, Long> {

}
