package com.pharmacy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DispensingRecord")
public class DispensingRecord {

	@Id
	@Column(nullable = false, unique = true)
	private Long record_Id;
	@Column(nullable = false)
	private Long prescriptionId;
	@Column(nullable = false)
	private Long pharmacistId;
	@Column(nullable = false)
	private Long pharmacyId;
	@Column(nullable = false)
	private Long quantityDispensed;
	@Column(nullable = false)
	private String dateDispensed;
	@Column(nullable = false)
	private Long price;

	@Transient
	private String operation;

	public Long getRecord_Id() {
		return record_Id;
	}

	public void setRecord_Id(Long record_Id) {
		this.record_Id = record_Id;
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Long getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(Long pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

	public Long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public Long getQuantityDispensed() {
		return quantityDispensed;
	}

	public void setQuantityDispensed(Long quantityDispensed) {
		this.quantityDispensed = quantityDispensed;
	}

	public String getDateDispensed() {
		return dateDispensed;
	}

	public void setDateDispensed(String dateDispensed) {
		this.dateDispensed = dateDispensed;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
