package com.school.website.AdminPortalServicePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.website.AdminPortalRepositoryPackage.AdminStudentRepository;
import com.school.website.ModelPackage.Student;




@Service
public class AdminStudentServiceImpl implements AdminStudentService {

	@Autowired
	private AdminStudentRepository adminStudentRepository;

	@Override
	public void createStudent(Student student) {

		adminStudentRepository.save(student);

	}
	

}
