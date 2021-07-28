package com.school.website.ModelPackage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	private String studentID;
	private String firstName;
	private String lastName;

	@Column(name = "email", nullable = false, updatable = false)
	private String email;
	private String phone;
	private String address;
	private String dateOfBirth;
	private String studentClass;
	private boolean enabled = true;

	@Transient
	private MultipartFile studentImage;

	private Date enrolledTime;
	
	private String guardianName;
	private String guardianEmail;
	private String guardianPhone;
	private String guardianAddress;
	

}
