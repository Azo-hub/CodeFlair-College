package com.school.website.AdminPortalControllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminHomeController {
	@GetMapping("/adminportal")
	public String AdminHome(Model model) {
		
		Integer degree = 90;
		model.addAttribute("degree", degree);
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);
		return "AdminHome";
	}

}
