package com.school.website.AdminPortalRepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.website.ModelPackage.Student;



@Repository
public interface AdminStudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentID(String studentID);

	Student findByEmail(String email);

	Student findByDateOfBirth(String dateOfBirth);

}
