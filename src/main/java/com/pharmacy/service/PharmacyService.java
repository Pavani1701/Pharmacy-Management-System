package com.pharmacy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharmacy.entities.DispensingRecord;
import com.pharmacy.entities.InsuranceProvider;
import com.pharmacy.entities.Patient;
import com.pharmacy.entities.Pharmacist;
import com.pharmacy.entities.Pharmacy;
import com.pharmacy.entities.Prescription;
import com.pharmacy.entities.Response;
import com.pharmacy.repository.DispensingRecordRepo;
import com.pharmacy.repository.InsuranceProviderRepo;
import com.pharmacy.repository.InvoiceRepo;
import com.pharmacy.repository.MedicationPrescriptionRepo;
import com.pharmacy.repository.MedicationRepo;
import com.pharmacy.repository.NoXYZInsurancesRepo;
import com.pharmacy.repository.PatientRepo;
import com.pharmacy.repository.PharmacistRepo;
import com.pharmacy.repository.PharmacistWorkingRepo;
import com.pharmacy.repository.PharmacyRepo;
import com.pharmacy.repository.PrescribeDrugRepo;
import com.pharmacy.repository.PrescriptionRepo;
import com.pharmacy.repository.PrescriptionSummaryRepo;

@Service
public class PharmacyService {

	@Autowired
	DispensingRecordRepo dispensingRecordRepo;

	@Autowired
	InsuranceProviderRepo insuranceProviderRepo;

	@Autowired
	InvoiceRepo invoiceRepo;

	@Autowired
	MedicationPrescriptionRepo medicationPrescriptionRepo;

	@Autowired
	MedicationRepo medicationRepo;

	@Autowired
	NoXYZInsurancesRepo noXYZInsurancesRepo;

	@Autowired
	PatientRepo patientRepo;

	@Autowired
	PharmacistRepo pharmacistRepo;

	@Autowired
	PharmacistWorkingRepo pharmacistWorkingRepo;

	@Autowired
	PharmacyRepo pharmacyRepo;

	@Autowired
	PrescribeDrugRepo prescribeDrugRepo;

	@Autowired
	PrescriptionRepo prescriptionRepo;

	@Autowired
	PrescriptionSummaryRepo prescriptionSummaryRepo;

	public ResponseEntity<?> insuranceOperations(InsuranceProvider insuranceProvider) {
		try {
			if (insuranceProvider.getOperation().equalsIgnoreCase("ADD")) {

				insuranceProviderRepo.save(insuranceProvider);

				return Response.buildResponse("InsuranceProvider Added Successfully", HttpStatus.OK);
			} else if (insuranceProvider.getOperation().equalsIgnoreCase("UPDATE")) {
				insuranceProviderRepo.save(insuranceProvider);

				return Response.buildResponse("InsuranceProvider Updated Successfully", HttpStatus.OK);
			} else if (insuranceProvider.getOperation().equalsIgnoreCase("DELETE")) {

				List<Long> patIds = patientRepo.findAll().stream()
						.filter(i -> i.getProviderId().equals(insuranceProvider.getProviderId()))
						.map(p -> p.getPatientId()).collect(Collectors.toList());

				List<Long> prescIds = prescriptionRepo.findAll().stream().filter(p -> patIds.contains(p.getPatientId()))
						.map(k -> k.getPrescription_Id()).collect(Collectors.toList());

				medicationPrescriptionRepo.deleteAllById(medicationPrescriptionRepo.findAll().stream()
						.filter(m -> prescIds.contains(m.getPrescriptionId())).map(m -> m.getMedicationId())
						.collect(Collectors.toList()));
				
				
				List<Long> dispRecord = dispensingRecordRepo.findAll().stream()
						.filter(f -> prescIds.contains(f.getPrescriptionId()))
						.map(m -> m.getRecord_Id()).collect(Collectors.toList());

				invoiceRepo
						.deleteAllById(invoiceRepo.findAll().stream().filter(f -> dispRecord.contains(f.getRecordId()))
								.map(m -> m.getInvoiceId()).collect(Collectors.toList()));

				dispensingRecordRepo.deleteAllById(dispRecord);

				prescriptionRepo.deleteAllById(prescIds);

				patientRepo.deleteAllById(patIds);

				insuranceProviderRepo.delete(insuranceProvider);

				return Response.buildResponse("InsuranceProvider Deleted Successfully", HttpStatus.OK);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<?> patientOperations(Patient patient) {
		try {
			if (patient.getOperation().equalsIgnoreCase("ADD")) {

				patientRepo.save(patient);

				return Response.buildResponse("Patient Added Successfully");
			} else if (patient.getOperation().equalsIgnoreCase("UPDATE")) {
				patientRepo.save(patient);

				return Response.buildResponse("Patient Updated Successfully");
			} else if (patient.getOperation().equalsIgnoreCase("DELETE")) {

				List<Long> prescIds = prescriptionRepo.findAll().stream()
						.filter(p -> p.getPatientId().equals(patient.getPatientId())).map(k -> k.getPrescription_Id())
						.collect(Collectors.toList());

				medicationPrescriptionRepo.deleteAllById(medicationPrescriptionRepo.findAll().stream()
						.filter(m -> prescIds.contains(m.getPrescriptionId())).map(m -> m.getMedicationId())
						.collect(Collectors.toList()));

				dispensingRecordRepo.deleteAllById(
						dispensingRecordRepo.findAll().stream().filter(f -> prescIds.contains(f.getPrescriptionId()))
								.map(m -> m.getRecord_Id()).collect(Collectors.toList()));

				prescriptionRepo.deleteAllById(prescIds);

				patientRepo.delete(patient);

				return Response.buildResponse("Patient Deleted Successfully");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<?> pharmacistOperations(Pharmacist pharmacist) {
		try {
			if (pharmacist.getOperation().equalsIgnoreCase("ADD")) {

				pharmacistRepo.save(pharmacist);

				return Response.buildResponse("Pharmacist Added Successfully");
			} else if (pharmacist.getOperation().equalsIgnoreCase("UPDATE")) {
				pharmacistRepo.save(pharmacist);

				return Response.buildResponse("Pharmacist Updated Successfully");
			} else if (pharmacist.getOperation().equalsIgnoreCase("DELETE")) {

				List<Long> dispRecord = dispensingRecordRepo.findAll().stream()
						.filter(f -> f.getPharmacistId().equals(pharmacist.getPharmacistId()))
						.map(m -> m.getRecord_Id()).collect(Collectors.toList());

				invoiceRepo
						.deleteAllById(invoiceRepo.findAll().stream().filter(f -> dispRecord.contains(f.getRecordId()))
								.map(m -> m.getInvoiceId()).collect(Collectors.toList()));

				dispensingRecordRepo.deleteAllById(dispRecord);

				pharmacistRepo.delete(pharmacist);

				return Response.buildResponse("Pharmacist Deleted Successfully");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<?> pharmacyOperations(Pharmacy pharmacy) {
		try {
			if (pharmacy.getOperation().equalsIgnoreCase("ADD")) {

				pharmacyRepo.save(pharmacy);

				return Response.buildResponse("Pharmacy Added Successfully");
			} else if (pharmacy.getOperation().equalsIgnoreCase("UPDATE")) {
				pharmacyRepo.save(pharmacy);

				return Response.buildResponse("Pharmacy Updated Successfully");
			} else if (pharmacy.getOperation().equalsIgnoreCase("DELETE")) {

				List<Long> dispRecord = dispensingRecordRepo.findAll().stream()
						.filter(f -> f.getPharmacyId().equals(pharmacy.getPharmacyId())).map(m -> m.getRecord_Id())
						.collect(Collectors.toList());

				invoiceRepo
						.deleteAllById(invoiceRepo.findAll().stream().filter(f -> dispRecord.contains(f.getRecordId()))
								.map(m -> m.getInvoiceId()).collect(Collectors.toList()));

				dispensingRecordRepo.deleteAllById(dispRecord);

				pharmacyRepo.delete(pharmacy);

				return Response.buildResponse("Pharmacy Deleted Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<?> prescriptionOperations(Prescription prescription) {
		try {
			if (prescription.getOperation().equalsIgnoreCase("ADD")) {

				prescriptionRepo.save(prescription);
				return Response.buildResponse("Prescription Added Successfully");
			} else if (prescription.getOperation().equalsIgnoreCase("UPDATE")) {
				prescriptionRepo.save(prescription);

				return Response.buildResponse("Prescription Updated Successfully");
			} else if (prescription.getOperation().equalsIgnoreCase("DELETE")) {

				medicationPrescriptionRepo.deleteAllById(medicationPrescriptionRepo.findAll().stream()
						.filter(m -> m.getPrescriptionId().equals(prescription.getPrescription_Id()))
						.map(m -> m.getMedicationId()).collect(Collectors.toList()));

				List<Long> dispRecIds = dispensingRecordRepo.findAll().stream()
						.filter(d -> d.getPrescriptionId().equals(prescription.getPrescription_Id()))
						.map(m -> m.getRecord_Id()).collect(Collectors.toList());

				invoiceRepo
						.deleteAllById(invoiceRepo.findAll().stream().filter(f -> dispRecIds.contains(f.getRecordId()))
								.map(m -> m.getInvoiceId()).collect(Collectors.toList()));
				
				dispensingRecordRepo.deleteAllById(dispRecIds);

				prescriptionRepo.delete(prescription);

				return Response.buildResponse("Prescription Deleted Successfully");
			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<?> dispensingRecordOperations(DispensingRecord dispensingRecord) {
		try {
			if (dispensingRecord.getOperation().equalsIgnoreCase("ADD")) {

				dispensingRecordRepo.save(dispensingRecord);

				return Response.buildResponse("DispensingRecord Added Successfully");
			} else if (dispensingRecord.getOperation().equalsIgnoreCase("UPDATE")) {
				dispensingRecordRepo.save(dispensingRecord);

				return Response.buildResponse("DispensingRecord Updated Successfully");
			} else if (dispensingRecord.getOperation().equalsIgnoreCase("DELETE")) {
				
				invoiceRepo
				.deleteAllById(invoiceRepo.findAll().stream().filter(f -> f.getRecordId().equals(dispensingRecord.getRecord_Id()))
						.map(m -> m.getInvoiceId()).collect(Collectors.toList()));

				dispensingRecordRepo.delete(dispensingRecord);

				return Response.buildResponse("DispensingRecord Deleted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/*-----------------*/

	public ResponseEntity<?> viewPrescribeDrug() {
		try {
			return Response.buildResponse(patientRepo.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> viewNoXYZinsurances() {
		try {
			return Response.buildResponse(insuranceProviderRepo.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> viewPharmacistWorking() {
		try {
			return Response.buildResponse(pharmacistRepo.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> viewPrescriptionSummary() {
		try {
			return Response.buildResponse(prescriptionRepo.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
