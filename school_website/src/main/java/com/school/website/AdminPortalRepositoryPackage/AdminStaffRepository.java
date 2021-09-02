package com.school.website.AdminPortalRepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.website.ModelPackage.Staff;

@Repository
public interface AdminStaffRepository extends JpaRepository <Staff, Long> {

	Staff findByEmail(String email);

	Staff findByDateOfBirth(String dateOfBirth);

	

}
