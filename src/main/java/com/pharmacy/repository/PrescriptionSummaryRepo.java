package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.PrescriptionSummaryView;

public interface PrescriptionSummaryRepo extends JpaRepository<PrescriptionSummaryView, Long> {

}
