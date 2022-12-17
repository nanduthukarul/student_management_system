package com.nalt.student_management_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalt.student_management_system.dao.AddressRepository;
import com.nalt.student_management_system.entity.Address;
import com.nalt.student_management_system.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public List<Address> getAddressesByStudentId(Long studentId) {
	
		return addressRepo.findByStudentStudentId(studentId);
	}

	@Override
	public void saveAll(List<Address> addresses) {

		addressRepo.saveAll(addresses);
		
	}

}
