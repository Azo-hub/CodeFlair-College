package com.school.website.ControllerPackage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.website.ModelPackage.Student;

import com.school.website.ServicePackage.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/new_students_enrollment")
	public String newStudentEnrollment(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "NewStudentEnrollment";

	}

	@PostMapping("/new_students_enrollment")
	public String newStudentsEnrollment(@ModelAttribute("student") Student student) {
		
		student.setEnrolledTime(new Date());
		studentService.createStudent(student);

		return "NewStudentEnrollment";

	}

}
