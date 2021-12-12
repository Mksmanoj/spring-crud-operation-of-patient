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

	// display list of patients
	@GetMapping("/dashboard")
	public String viewHomePage(Model model) {
		model.addAttribute("listPatients", patientsService.getAllPatients());
		return "dashboard";
//		return findPaginated(1, "firstName", "asc", model);		
	}

	@GetMapping("/showNewPatientsForm")
	public String showNewPatientsForm(Model model) {
		// creating model attribute to bind form data
		Patients patients = new Patients();
		model.addAttribute("patients", patients);
		return "new_patients";
	}

	@PostMapping("/savePatients")
	public String savePatients(@ModelAttribute("patients") Patients patients) {
		// save Patients in database
		patientsService.savePatients(patients);
		return "redirect:/dashboard";
	}

	@GetMapping("/deletePatients/{id}")
	public String deletePatients(@PathVariable(value = "id") long id) {

		// call delete patient method
		this.patientsService.deletePatientsById(id);
		return "redirect:/dashboard";
	}

}
