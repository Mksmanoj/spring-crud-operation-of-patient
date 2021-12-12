package com.patient.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.patient.management.beens.User;
import com.patient.management.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	
//register user 
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		System.out.println("Agreement" + agreement);
		System.out.println("user" + user);
		
		User result = this.userDao.save(user);
		model.addAttribute("user", result);
		return "signup";
	}
}
