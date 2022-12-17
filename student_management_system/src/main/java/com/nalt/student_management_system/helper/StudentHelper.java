package com.nalt.student_management_system.helper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class StudentHelper {
	
	
	//This method will generate new Student Code
	public String getUniqueStudentCode(String name, LocalDate dob) {

		String uniqueCode = name.toUpperCase()+dob.getYear();
				
		return uniqueCode;
	}
	
	//This method will validate student
	public Boolean validateStudent(String studentCodeFromDb, LocalDate dobFromDb, String studentCode, LocalDate dob) {
		
		if(studentCodeFromDb.equals(studentCode) && dobFromDb.isEqual(dob)) return true;
		
		else return false;
	}

}
