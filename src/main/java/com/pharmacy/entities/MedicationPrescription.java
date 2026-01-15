package com.pharmacy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MedicationPrescription")
public class MedicationPrescription {

	@Id
	@Column(nullable = false, unique = true)
	private Long medicationId;
	@Column(nullable = false)
	private Long prescriptionId;
	@Column(nullable = false)
	private Long quantityDispensed;

	@Transient
	private String operation;

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Long getQuantityDispensed() {
		return quantityDispensed;
	}

	public void setQuantityDispensed(Long quantityDispensed) {
		this.quantityDispensed = quantityDispensed;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
