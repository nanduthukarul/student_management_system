package com.nalt.student_management_system.service;

import java.util.List;

import com.nalt.student_management_system.entity.Course;

public interface CourseService {
	
	Course saveCourse(Course course);
	
	void removeAssisnedStudent(Long studentId, Long courseId);

	List<Course> getAll();

	List<Course> getById(List<Long> courseIds);

	Course getAllByCourse(String courseName);

	List<Course> getByStudent(Long studentId);

}
