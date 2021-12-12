package com.patient.management.service;

import java.util.List;

import com.patient.management.beens.Patients;

public interface PatientsService {
	List<Patients> getAllPatients();

	void savePatients(Patients patients);

	void deletePatientsById(long id);
}
