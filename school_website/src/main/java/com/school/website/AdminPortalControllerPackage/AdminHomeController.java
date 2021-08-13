package com.school.website.AdminPortalControllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminHomeController {
	@GetMapping("/adminportal")
	public String AdminHome() {

		return "AdminHome";
	}

}
