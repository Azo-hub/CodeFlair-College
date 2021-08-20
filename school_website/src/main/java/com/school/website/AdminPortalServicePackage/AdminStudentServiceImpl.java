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
	
	@Override
	public void createStudentID (Student student) {
		
		student.setStudentID("CDF" + "-" + student.getId());
		adminStudentRepository.save(student);

	}

	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return adminStudentRepository.findByEmail(email);
	}

	@Override
	public Student findByDateOfBirth(String dateOfBirth) {
		// TODO Auto-generated method stub
		return adminStudentRepository.findByDateOfBirth(dateOfBirth);
	}

	

}
