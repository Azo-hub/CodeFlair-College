package com.school.website.AdminPortalServicePackage;

import com.school.website.ModelPackage.Staff;

public interface AdminStaffService {

	void createStaff(Staff staff);

	void createStaffID(Staff staff);

	Staff findByEmail(String email);

	Staff findByDateOfBirth(String dateOfBirth);

}
