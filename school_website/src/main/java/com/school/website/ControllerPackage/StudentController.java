package com.school.website.ControllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping("/new_students_enrollment")
	public String newStudentEnrollment () {
		
		return "NewStudentEnrollment";
		
	}

}
