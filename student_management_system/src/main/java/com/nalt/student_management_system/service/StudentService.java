package com.nalt.student_management_system.service;

import java.time.LocalDate;
import java.util.List;

import com.nalt.student_management_system.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getByName(String name);
	
	List<Student> getStudentsByCourse(String name);
	
	Student assisgnCourses(Long studentId, List<Long> courseIds);

	List<Student> getAll();

	Object leaveCourse(Long id, Long courseId, String studentCode, LocalDate dob);

	Object updateStudentProfile(Student student, String studentCode, LocalDate dob);

}
