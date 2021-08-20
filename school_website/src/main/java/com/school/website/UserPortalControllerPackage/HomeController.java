package com.school.website.UserPortalControllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Home (Model model) {
		
		String User_Portal = "" ;
		model.addAttribute("User_Portal", User_Portal);
		return "Home";
	}

}
