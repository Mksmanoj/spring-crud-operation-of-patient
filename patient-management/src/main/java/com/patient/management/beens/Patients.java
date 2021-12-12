package com.patient.management.beens;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientsmanage")
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "patient_name")
	private String fullName;

	@Column(name = "age")
	private int age;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "admit_date")
	private Date admitDate;

	@Column(name = "expences")
	private Long expences;

	@Column(name = "STATUS")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return fullName;
	}

	public void setFirstName(String firstName) {
		this.fullName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	public Long getExpences() {
		return expences;
	}

	public void setExpences(Long expences) {
		this.expences = expences;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
