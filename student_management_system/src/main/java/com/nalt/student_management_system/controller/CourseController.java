package com.nalt.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nalt.student_management_system.entity.Course;
import com.nalt.student_management_system.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired 
	CourseService service;
	
	//This method will return all courses 
	@GetMapping("/all")
	public ResponseEntity<?> getAllCourses(){
		
		try {
			return ResponseEntity.ok().body(service.getAll());
		} catch (Exception e) {
			return ResponseEntity.ok().body(e.getMessage());
		}	
		
	}
	
	//This method will save new course
	@PostMapping("/new")
	public ResponseEntity<?> saveCourse(@RequestBody Course course){
		
		try {
			return ResponseEntity.ok().body(service.saveCourse(course));
		} catch (Exception e) {
			return ResponseEntity.ok().body(e.getMessage());
		}
		
	}
	
	//This method will return course list by studentId
	@GetMapping("/student/{studentId}")
	public ResponseEntity<?> getCoursesByStudent(@PathVariable Long studentId){
		
		try {
			return ResponseEntity.ok().body(service.getByStudent(studentId));
		} catch (Exception e) {
			return ResponseEntity.ok().body(e.getMessage());
		}
		
	}
	
	
}
