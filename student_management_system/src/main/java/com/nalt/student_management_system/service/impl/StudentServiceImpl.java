package com.nalt.student_management_system.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nalt.student_management_system.dao.StudentRepository;
import com.nalt.student_management_system.entity.Course;
import com.nalt.student_management_system.entity.Student;
import com.nalt.student_management_system.helper.StudentHelper;
import com.nalt.student_management_system.service.CourseService;
import com.nalt.student_management_system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentHelper helper;
	
	//This method will save new student
	@Override
	public Student saveStudent(Student student) {
		
		student.setUnique_code(helper.getUniqueStudentCode(student.getName(), student.getDob()));
		 		
		return studentRepo.save(student);

	}

	@Override
	public List<Student> getByName(String name) {
		
		List<Student> students = studentRepo.findByName(name);
		 
		return students;
	}

	@Override
	public List<Student> getStudentsByCourse(String courseName) {

		Course course = courseService.getAllByCourse(courseName);

		return course.getStudents();
	}

	@Override
	public Student assisgnCourses(Long studentId, List<Long> courseIds) {
	
		List<Course> courses = courseService.getById(courseIds);
		
		Student student = studentRepo.getReferenceById(studentId);
		
		student.setCourses(courses);
			
		return studentRepo.save(student);
		
		//return studentRepo.findByIdWithCourses(studentId);
			
	}

	@Override
	public List<Student> getAll() {
		
		return studentRepo.findAll();
	}

	@Override
	public Object leaveCourse(Long id, Long courseId, String studentCode, LocalDate dob) {
		
		
		Student student = studentRepo.findByIdWithCourses(id);
		
		if(helper.validateStudent(student.getUnique_code(), student.getDob(), studentCode, dob)) {
			List<Course> courses = student.getCourses();
			
			Course leavedCourse = null;
			
			for(Course course : courses) {
				if(course.getCourseId() == courseId) leavedCourse = course;
			}
			
			student.getCourses().remove(leavedCourse);
			
			return studentRepo.save(student);
		
		}
		
		else {
			ObjectMapper om = new ObjectMapper();
			ObjectNode obj = om.createObjectNode();
			
			obj.put("Message", "Invalid User!");
			
			return obj;
		}
		
	}

	//This method will update student record 
	@Override
	public Object updateStudentProfile(Student student, String studentCode, LocalDate dob) {
		
		Student studentProfile = studentRepo.getReferenceById(student.getStudentId());
		
		if(helper.validateStudent(studentProfile.getUnique_code(), studentProfile.getDob(), studentCode, dob)) {
			studentProfile.setEmail(student.getEmail());
			studentProfile.setMobile(student.getMobile());
			studentProfile.setParents_name(student.getParents_name());
			studentProfile.setAddresses(student.getAddresses());
			return studentRepo.save(studentProfile);
		}

		else {
			ObjectMapper om = new ObjectMapper();
			ObjectNode obj = om.createObjectNode();
			
			obj.put("Message", "Invalid User!");
			
			return obj;
		}
	}
	
}
