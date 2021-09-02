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
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	private String staffID;
	private String firstName;
	private String lastName;
	private String otherName;
	
	@Column(name = "gender", nullable = false, updatable = true)
	private String gender;

	@Column(name = "email", nullable = false, updatable = false)
	private String email;
	private String phone;
	private String address;
	
	@Column(name = "dateOfBirth", nullable = false, updatable = true)
	private String dateOfBirth;
	private boolean enabled = true;

	@Transient
	private MultipartFile staffImage;

	private Date enrolledTime;

}
