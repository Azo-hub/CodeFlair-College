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
import com.school.website.UserPortalServicePackage.StudentService;

@Controller
@RequestMapping("/adminportal")
public class AdminStudentController {

	@Autowired
	AdminStudentService adminStudentService;

	@Autowired
	AdminStudentRepository adminStudentRepository;

	@GetMapping("/new_students_enrollment")
	public String newStudentEnrollment(Model model) {
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);

		return "NewStudentEnrollment";

	}

	@PostMapping("/new_students_enrollment")
	public String newStudentsEnrollment(Model model, @ModelAttribute("student") Student student,
			@ModelAttribute("firstName") String firstName, @ModelAttribute("lastName") String lastName,
			@ModelAttribute("otherName") String otherName, @ModelAttribute("email") String Email,
			@ModelAttribute("dateOfBirth") String DateOfBirth) {

		if (Email.isEmpty() || DateOfBirth.isEmpty()) {

			String incomplete_field = "Email or Date of Birth Field is Empty!";
			model.addAttribute("incomplete_field", incomplete_field);

		} else if (adminStudentService.findByEmail(Email) != null
				& adminStudentService.findByDateOfBirth(DateOfBirth) != null) {

			String email_Already_Exist = "Student's Email Address or Date of Birth Already Exist";
			model.addAttribute("email_Already_Exist", email_Already_Exist);

		} else {

			/* Capitalizing first letter of the first name */

			char FirstName_FirstChar = firstName.charAt(0);

			String UpperCase_FirstName_FirstChar = Character.toString(FirstName_FirstChar).toUpperCase();

			String FirstName_RemainingChar = firstName.substring(1);

			String FirstName = UpperCase_FirstName_FirstChar.concat(FirstName_RemainingChar);

			student.setFirstName(FirstName);

			/* Capitalizing first letter of the last name */

			char LastName_FirstChar = lastName.charAt(0);

			String UpperCase_LastName_FirstChar = Character.toString(LastName_FirstChar).toUpperCase();

			String LastName_RemainingChar = lastName.substring(1);

			String LastName = UpperCase_LastName_FirstChar.concat(LastName_RemainingChar);

			student.setLastName(LastName);

			/* Capitalizing first letter of the other name */

			char OtherName_FirstChar = otherName.charAt(0);

			String UpperCase_OtherName_FirstChar = Character.toString(OtherName_FirstChar).toUpperCase();

			String OtherName_RemainingChar = otherName.substring(1);

			String OtherName = UpperCase_OtherName_FirstChar.concat(OtherName_RemainingChar);

			student.setOtherName(OtherName);

			/* Setting the enrollment date */

			student.setEnrolledTime(new Date());

			adminStudentService.createStudent(student);
			adminStudentService.createStudentID(student);
			
			String New_Student_Registration_Success = "Student's Details registered successfully" ;
			model.addAttribute("New_Student_Registration_Success", New_Student_Registration_Success);

		}
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);

		return "NewStudentEnrollment";

	}

	@GetMapping("/view_students_list")
	public String Student_List(Model model) {

		List<Student> studentList = adminStudentRepository.findAll();
		model.addAttribute("studentList", studentList);
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);
		
		return "Student's List";
	}

}
