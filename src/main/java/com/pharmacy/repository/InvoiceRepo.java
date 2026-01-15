package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

}
