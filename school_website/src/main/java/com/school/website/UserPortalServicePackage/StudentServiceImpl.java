package com.school.website.UserPortalServicePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.website.ModelPackage.Student;
import com.school.website.UserPortalRepositoryPackage.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {

		studentRepository.save(student);

	}

}
