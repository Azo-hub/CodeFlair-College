package com.school.website.AdminPortalServicePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.website.AdminPortalRepositoryPackage.AdminStaffRepository;
import com.school.website.ModelPackage.Staff;

@Service
public class AdminStaffServiceImpl implements AdminStaffService {
	
	@Autowired
	private AdminStaffRepository adminStaffRepository;

	@Override
	public void createStaff(Staff staff) {

		adminStaffRepository.save(staff);

	}
	
	@Override
	public void createStaffID (Staff staff) {
		
		staff.setStaffID("CDF-STF" + "-" + staff.getId());
		adminStaffRepository.save(staff);

	}

	@Override
	public Staff findByEmail(String email) {
		// TODO Auto-generated method stub
		return adminStaffRepository.findByEmail(email);
	}

	@Override
	public Staff findByDateOfBirth(String dateOfBirth) {
		// TODO Auto-generated method stub
		return adminStaffRepository.findByDateOfBirth(dateOfBirth);
	}



}
