package com.nalt.student_management_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalt.student_management_system.dao.CourseRepository;
import com.nalt.student_management_system.entity.Course;
import com.nalt.student_management_system.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public Course saveCourse(Course course) {

		return courseRepo.save(course);
		
	}

	@Override
	public void removeAssisnedStudent(Long studentId, Long courseId) {
		
		Course course = courseRepo.getReferenceById(courseId);
		
		courseRepo.save(course);
		
	}

	@Override
	public List<Course> getAll() {
		
		return courseRepo.findAll();
	}


	@Override
	public List<Course> getById(List<Long> courseIds) {

		return courseRepo.findAllById(courseIds);
	}



	@Override
	public Course getAllByCourse(String courseName) {
		
		return courseRepo.findByNameWithStudents(courseName);
	}


	@Override
	public List<Course> getByStudent(Long studentId) {

		return courseRepo.findAllById(courseRepo.getCourseIdsByStudentId(studentId));
	}

}
