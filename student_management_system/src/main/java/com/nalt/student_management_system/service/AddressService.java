package com.nalt.student_management_system.service;

import java.util.List;

import com.nalt.student_management_system.entity.Address;;

public interface AddressService {

	List<Address> getAddressesByStudentId(Long studentId);

	void saveAll(List<Address> addresses);

}
