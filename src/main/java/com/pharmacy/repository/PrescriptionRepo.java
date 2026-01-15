package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Prescription;

public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {

}
