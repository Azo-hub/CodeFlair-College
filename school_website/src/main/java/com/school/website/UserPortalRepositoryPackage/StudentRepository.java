package com.school.website.UserPortalRepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.website.ModelPackage.Student;







@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentID(String studentID);

}
