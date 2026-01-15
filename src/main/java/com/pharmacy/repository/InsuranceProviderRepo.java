package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.InsuranceProvider;

public interface InsuranceProviderRepo extends JpaRepository<InsuranceProvider, Long> {

}
