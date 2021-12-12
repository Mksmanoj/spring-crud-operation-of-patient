package com.patient.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.management.beens.Patients;
import com.patient.management.dao.PatientsDao;

@Service
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsDao patientsDao;

	@Override
	public List<Patients> getAllPatients() {
		return patientsDao.findAll();
	}

	@Override
	public void savePatients(Patients patients) {
		this.patientsDao.save(patients);
	}

	@Override
	public Patients getPatientsById(long id) {
		Optional<Patients> optional = patientsDao.findById(id);
		Patients patients = null;
		if (optional.isPresent()) {
			patients = optional.get();
		} else {
			throw new RuntimeException(" patients not found for id :: " + id);
		}
		return patients;
	}

	@Override
	public void deletePatientsById(long id) {
		this.patientsDao.deleteById(id);
	}

}
