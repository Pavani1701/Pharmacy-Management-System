package com.pharmacy.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.entities.DispensingRecord;
import com.pharmacy.entities.InsuranceProvider;
import com.pharmacy.entities.Patient;
import com.pharmacy.entities.Pharmacist;
import com.pharmacy.entities.Pharmacy;
import com.pharmacy.entities.Prescription;
import com.pharmacy.service.PharmacyService;

@RestController
@CrossOrigin("*")
public class PharmacyController {

	@Autowired
	PharmacyService service;

	static List<String> operationsList = Arrays.asList("ADD", "UPDATE", "DELETE");

	@PostMapping("/insuranceProvider/operations")
	public ResponseEntity<?> teamOperations(@RequestBody InsuranceProvider insuranceProvider) {
		if (null != insuranceProvider.getOperation() && !insuranceProvider.getOperation().isEmpty()
				&& operationsList.contains(insuranceProvider.getOperation().toUpperCase()))
			return service.insuranceOperations(insuranceProvider);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	@PostMapping("/patient/operations")
	public ResponseEntity<?> organizerOperations(@RequestBody Patient patient) {
		if (null != patient.getOperation() && !patient.getOperation().isEmpty()
				&& operationsList.contains(patient.getOperation().toUpperCase()))
			return service.patientOperations(patient);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	@PostMapping("/pharmacist/operations")
	public ResponseEntity<?> sponserOperations(@RequestBody Pharmacist pharmacist) {
		if (null != pharmacist.getOperation() && !pharmacist.getOperation().isEmpty()
				&& operationsList.contains(pharmacist.getOperation().toUpperCase()))
			return service.pharmacistOperations(pharmacist);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	@PostMapping("/pharmacy/operations")
	public ResponseEntity<?> riderOperations(@RequestBody Pharmacy pharmacy) {
		if (null != pharmacy.getOperation() && !pharmacy.getOperation().isEmpty()
				&& operationsList.contains(pharmacy.getOperation().toUpperCase()))
			return service.pharmacyOperations(pharmacy);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	@PostMapping("/prescription/operations")
	public ResponseEntity<?> raceOperations(@RequestBody Prescription prescription) {
		if (null != prescription.getOperation() && !prescription.getOperation().isEmpty()
				&& operationsList.contains(prescription.getOperation().toUpperCase()))
			return service.prescriptionOperations(prescription);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	@PostMapping("/dispensingrecord/operations")
	public ResponseEntity<?> riderTeamRaceOperations(@RequestBody DispensingRecord dispensingRecord) {
		if (null != dispensingRecord.getOperation() && !dispensingRecord.getOperation().isEmpty()
				&& operationsList.contains(dispensingRecord.getOperation().toUpperCase()))
			return service.dispensingRecordOperations(dispensingRecord);
		return ResponseEntity.badRequest().body("Please provide one valid operation");

	}

	

	@GetMapping("/viewPrescribeDrug/")
	public ResponseEntity<?> viewPrescribeDrug() {
		return service.viewPrescribeDrug();

	}

	@GetMapping("/viewNoXYZinsurances/")
	public ResponseEntity<?> viewNoXYZinsurances() {
		return service.viewNoXYZinsurances();

	}

	@GetMapping("/viewPharmacistWorking/")
	public ResponseEntity<?> viewPharmacistWorking() {
		return service.viewPharmacistWorking();

	}

	@GetMapping("/viewPrescriptionSummary/")
	public ResponseEntity<?> viewPrescriptionSummary() {
		return service.viewPrescriptionSummary();

	}

}
