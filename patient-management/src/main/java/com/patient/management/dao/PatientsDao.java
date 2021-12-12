package com.patient.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.management.beens.Patients;

public interface PatientsDao extends JpaRepository<Patients, Long>{

}
