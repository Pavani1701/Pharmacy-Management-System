package com.pharmacy.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrescriptionSummary")
public class PrescriptionSummaryView {

	@Id
	private Long patientId;
	private String patientName;
	private String insuranceProvider;
	private Long totalPrescriptions;
	private Long totalDispensed;
	private Long maxPrice;
	private Long avgPrice;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public Long getTotalPrescriptions() {
		return totalPrescriptions;
	}

	public void setTotalPrescriptions(Long totalPrescriptions) {
		this.totalPrescriptions = totalPrescriptions;
	}

	public Long getTotalDispensed() {
		return totalDispensed;
	}

	public void setTotalDispensed(Long totalDispensed) {
		this.totalDispensed = totalDispensed;
	}

	public Long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Long maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Long getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Long avgPrice) {
		this.avgPrice = avgPrice;
	}

}
