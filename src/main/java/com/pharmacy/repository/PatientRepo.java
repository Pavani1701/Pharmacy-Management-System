package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>{

}
