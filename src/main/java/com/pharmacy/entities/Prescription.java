package com.pharmacy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Prescription")
public class Prescription {

	@Id
	@Column(nullable = false, unique = true)
	private Long prescription_Id;
	@Column(nullable = false)
	private Long patientId;
	@Column(nullable = false)
	private String datePrescribed;
	@Column(nullable = false)
	private String drugName;
	@Column(nullable = false)
	private String dosage;
	@Column(nullable = false)
	private String quantity;
	@Column(nullable = false)
	private String instructions;

	@Transient
	private String operation;

	public Long getPrescription_Id() {
		return prescription_Id;
	}

	public void setPrescription_Id(Long prescription_Id) {
		this.prescription_Id = prescription_Id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDatePrescribed() {
		return datePrescribed;
	}

	public void setDatePrescribed(String datePrescribed) {
		this.datePrescribed = datePrescribed;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
