package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.DispensingRecord;

public interface DispensingRecordRepo extends JpaRepository<DispensingRecord, Long>{

}
