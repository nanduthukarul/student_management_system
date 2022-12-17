package com.nalt.student_management_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalt.student_management_system.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByStudentStudentId(Long studentId);


}
