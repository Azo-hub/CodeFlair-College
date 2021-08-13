package com.school.website.AdminPortalControllerPackage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.website.AdminPortalRepositoryPackage.AdminStudentRepository;
import com.school.website.AdminPortalServicePackage.AdminStudentService;
import com.school.website.ModelPackage.Student;







@Controller
@RequestMapping("/adminportal")
public class AdminStudentController {

	@Autowired
	AdminStudentService adminStudentService;
	
	@Autowired
	AdminStudentRepository adminStudentRepository;
	
	
	
	@GetMapping("/new_students_enrollment")
	public String newStudentEnrollment(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "NewStudentEnrollment";

	}
	
	
	@PostMapping("/new_students_enrollment")
	public String newStudentsEnrollment(@ModelAttribute("student") Student student) {
		
		student.setEnrolledTime(new Date());
		adminStudentService.createStudent(student);

		return "NewStudentEnrollment";

	}
	
	
	@GetMapping("/view_students_list")
	public String Student_List(Model model) {
		
		List<Student> studentList = adminStudentRepository.findAll();
		model.addAttribute("studentList", studentList);

		return "Student's List";
	}

}
