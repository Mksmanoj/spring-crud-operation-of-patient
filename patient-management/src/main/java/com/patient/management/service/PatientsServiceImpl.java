package com.patient.management.service;

import java.util.List;

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
	public void deletePatientsById(long id) {
		this.patientsDao.deleteById(id);
	}

}
