package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.NoXYZInsurancesView;

public interface NoXYZInsurancesRepo extends JpaRepository<NoXYZInsurancesView, String> {

}
