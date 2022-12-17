package com.nalt.student_management_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nalt.student_management_system.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	Course findByName(String name);
	 
	//This query will fetch course ids assigned to student by studentId
	@Query(value = "SELECT C.course_id from course C INNER JOIN student_course_map SC on C.course_id = SC.course_id where SC.student_id = ?1 ",
			  nativeQuery = true)
	List<Long> getCourseIdsByStudentId(Long studentId);
	 
	@Query(value = "SELECT C from Course C JOIN FETCH C.students where C.name = ?1 ")
	Course findByNameWithStudents(String name);

}
