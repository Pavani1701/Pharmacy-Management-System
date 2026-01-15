package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.PrescribeDrugView;

public interface PrescribeDrugRepo extends JpaRepository<PrescribeDrugView, String> {

}
