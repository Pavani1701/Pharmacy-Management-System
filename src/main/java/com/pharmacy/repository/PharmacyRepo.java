package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {

}
