package com.patient.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.patient.management.beens.Patients;
import com.patient.management.service.PatientsService;

@Controller
public class PatienstsController {

	@Autowired
	private PatientsService patientsService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listPatients", patientsService.getAllPatients());
		return "index";
//		return findPaginated(1, "firstName", "asc", model);		
	}

	@GetMapping("/showNewPatientsForm")
	public String showNewPatientsForm(Model model) {
		// create model attribute to bind form data
		Patients employee = new Patients();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/savePatients")
	public String savePatients(@ModelAttribute("patients") Patients patients) {
		// save Patients to database
		patientsService.savePatients(patients);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get Patients from the service
		Patients patients = patientsService.getPatientsById(id);

		// set Patients as a model attribute to pre-populate the form
		model.addAttribute("patients", patients);
		return "update_patients";
	}

	@GetMapping("/deletePatients/{id}")
	public String deletePatients(@PathVariable(value = "id") long id) {

		// call delete patient method
		this.patientsService.deletePatientsById(id);
		return "redirect:/";
	}

}
