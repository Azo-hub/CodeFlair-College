package com.school.website.AdminPortalServicePackage;

import com.school.website.ModelPackage.Student;

public interface AdminStudentService {

	void createStudent(Student student);

	void createStudentID(Student student);

	Student findByEmail(String email);

	Student findByDateOfBirth(String dateOfBirth);
	
	
}
