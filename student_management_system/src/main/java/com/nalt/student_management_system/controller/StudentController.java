package com.nalt.student_management_system.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nalt.student_management_system.entity.Student;
import com.nalt.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//This method will Save new student entry by Admin only
	@PostMapping("/new")
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		
		try {
			return ResponseEntity.ok().body(service.saveStudent(student));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}	
		
	}
	
	//This method will update student profile by students them self
	@PutMapping("/updateProfile")
	public ResponseEntity<?> updateStudentProfile(@RequestBody Student student, @RequestParam String studentCode, @RequestParam LocalDate dob){
		
		try {
			return ResponseEntity.ok().body(service.updateStudentProfile(student, studentCode, dob));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
	}
	
	//This method will return all students records
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudent(){
		
		try {
			return ResponseEntity.ok().body(service.getAll());
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	
	}
	
	//This method will save student by name
	@GetMapping("/byName/{name}")
	public ResponseEntity<?> getStudentByName(@PathVariable String name){
		
		try {
			return ResponseEntity.ok().body(service.getByName(name));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
	}
	
	//This method will return students list by course assigned
	@GetMapping("/course/{course}")
	public ResponseEntity<?> getStudentsByCourse(@PathVariable String course){
		
		try {
			return ResponseEntity.ok().body(service.getStudentsByCourse(course));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
	}
	
	//This method will assign course/courses to student
	@PutMapping("/assisnCourse/{id}")
	public ResponseEntity<?> assignCourse(@PathVariable Long id, @RequestParam List<Long> courseIds){
		
		try {
			return ResponseEntity.ok().body(service.assisgnCourses(id, courseIds));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	
	}
	
	//This method will delete course assigned to student
	@PutMapping("/leaveCourse/{id}")
	public ResponseEntity<?> leaveCourse(@PathVariable Long id, @RequestParam Long courseId, 
			@RequestParam String studentCode, @RequestParam LocalDate dob){
		
		try {
			return ResponseEntity.ok().body(service.leaveCourse(id, courseId, studentCode, dob));
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}	
		
	}
	
}
