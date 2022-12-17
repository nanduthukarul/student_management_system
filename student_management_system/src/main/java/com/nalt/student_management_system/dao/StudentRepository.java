package com.nalt.student_management_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nalt.student_management_system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByName(String name);
	
	//This will fetch Student record with courses
	@Query(value = "SELECT S from Student S JOIN FETCH S.courses where S.studentId = ?1 ")
	Student findByIdWithCourses(Long id);

}
