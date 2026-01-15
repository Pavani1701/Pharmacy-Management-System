package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Pharmacist;

public interface PharmacistRepo extends JpaRepository<Pharmacist, Long>{

}
