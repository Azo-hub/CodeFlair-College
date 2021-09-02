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

import com.school.website.AdminPortalRepositoryPackage.AdminStaffRepository;
import com.school.website.AdminPortalServicePackage.AdminStaffService;
import com.school.website.ModelPackage.Staff;


@Controller
@RequestMapping("/adminportal")
public class AdminStaffController {
	
	
	@Autowired
	AdminStaffService adminStaffService;

	@Autowired
	AdminStaffRepository adminStaffRepository;

	@GetMapping("/new_staff_enrollment")
	public String newStaffEnrollment(Model model) {
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);

		return "NewStaffEnrollment";

	}

	@PostMapping("/new_staff_enrollment")
	public String newStudentsEnrollment(Model model, @ModelAttribute("staff") Staff staff,
			@ModelAttribute("firstName") String firstName, @ModelAttribute("lastName") String lastName,
			@ModelAttribute("otherName") String otherName, @ModelAttribute("email") String Email,
			@ModelAttribute("dateOfBirth") String DateOfBirth) {

		if (Email.isEmpty() || DateOfBirth.isEmpty()) {

			String incomplete_field = "Email or Date of Birth Field is Empty!";
			model.addAttribute("incomplete_field", incomplete_field);

		} else if (adminStaffService.findByEmail(Email) != null
				& adminStaffService.findByDateOfBirth(DateOfBirth) != null) {

			String email_Already_Exist = "Staff's Email Address or Date of Birth Already Exist";
			model.addAttribute("email_Already_Exist", email_Already_Exist);

		} else {

			/* Capitalizing first letter of the first name */

			char FirstName_FirstChar = firstName.charAt(0);

			String UpperCase_FirstName_FirstChar = Character.toString(FirstName_FirstChar).toUpperCase();

			String FirstName_RemainingChar = firstName.substring(1);

			String FirstName = UpperCase_FirstName_FirstChar.concat(FirstName_RemainingChar);

			staff.setFirstName(FirstName);

			/* Capitalizing first letter of the last name */

			char LastName_FirstChar = lastName.charAt(0);

			String UpperCase_LastName_FirstChar = Character.toString(LastName_FirstChar).toUpperCase();

			String LastName_RemainingChar = lastName.substring(1);

			String LastName = UpperCase_LastName_FirstChar.concat(LastName_RemainingChar);

			staff.setLastName(LastName);

			/* Capitalizing first letter of the other name */

			char OtherName_FirstChar = otherName.charAt(0);

			String UpperCase_OtherName_FirstChar = Character.toString(OtherName_FirstChar).toUpperCase();

			String OtherName_RemainingChar = otherName.substring(1);

			String OtherName = UpperCase_OtherName_FirstChar.concat(OtherName_RemainingChar);

			staff.setOtherName(OtherName);

			/* Setting the enrollment date */

			staff.setEnrolledTime(new Date());

			adminStaffService.createStaff(staff);
			adminStaffService.createStaffID(staff);
			
			String New_Staff_Registration_Success = "Staff's Details registered successfully" ;
			model.addAttribute("New_Staff_Registration_Success", New_Staff_Registration_Success);

		}
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);

		return "NewStaffEnrollment";

	}
	

	@GetMapping("/view_staff_list")
	public String Staff_List(Model model) {

		List<Staff> staffList = adminStaffRepository.findAll();
		model.addAttribute("staffList", staffList);
		
		String Admin_Portal = "" ;
		model.addAttribute("Admin_Portal", Admin_Portal);
		
		return "Staff's List";
	}


}
