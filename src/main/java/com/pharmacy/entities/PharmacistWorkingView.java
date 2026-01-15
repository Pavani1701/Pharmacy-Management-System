package com.pharmacy.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pharmacistworking")
public class PharmacistWorkingView {

	@Id
	private Long recordId;
	private Long pharmacyId;
	private Long quantityDispensed;
	private String dateDispensed;
	private Long price;
	private String pharmacyName;
	private String phone;
	private String licenseInfo;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
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

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLicenseInfo() {
		return licenseInfo;
	}

	public void setLicenseInfo(String licenseInfo) {
		this.licenseInfo = licenseInfo;
	}

}
