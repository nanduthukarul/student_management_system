# student_management_system
This is a Springboot project, will enable admin to store and access students, course records. And students can view and update their profile by after validating themself.

Tools and Dependencies use
	JPA with Hibernate
	Spring Security
	spring web

------------------------------------------------------------------------------------------------------------------------------------------------------

Following are URLs and Required inputs for all the operations

For all admin operations Authorization required. Following are credentials
	user: amdin , password : password
	Add those in Authorization tab with 'Basic Auth' selected from dropdown
	
For all student operations Authorization not required, But for validation 'Student Unique Code' and 'DOB' are mandatory parameters
	Unique code will be combination of 'Student Name in Caps + year of birth'
		eg. if name is: Ram and DOB is: 2000-01-01 then unique code will be 'RAM2000'
------------------------------------------------------------------------------------------------------------------------------------
Admin Operations:

1. Save new student record
	URL : 
		http://localhost:8080/student_management_system/student	
	Authentication Required : Yes
	Input Parameters:
		RequestBody : Student object
			Eg. 
				{
					"name": "ram",
					"dob": "2001-01-01",
					"gender": "male",
					"email": "abc@gmail.com",
					"mobile": 9999999901,
					"parents_name": "sham",
					"unique_code": null,
					"addresses": 
					[
						{
							"area": "Andheri",
							"district": "Mumbai",
							"state": "Maharashtra",
							"pin": 400092,
							"type": "Permanant"
						},
						{
							"area": "Malad",
							"district": "Mumbai",
							"state": "Maharashtra",
							"pin": 400067,
							"type": "Current"
						}
					]
				}
				
			Return:
				Saved student object
			
			
2. Add new Course record
	URL : http://localhost:8080/student_management_system/course
	Authentication Required :Yes
	Input Parameters:
		RequestBody : Course object
			Eg. 
				{
					"name": "BSc",
					"type": "Full Time",
					"description": "This is course",
					"duration": "3 years",
					"topic": "Science"
				}
			
			Return:
				Saved Course object
			
		
3. Assign Course/Courses to student
	URL : http://localhost:8080/student_management_system/student/assisnCourse/{id}
	Authentication Required : Yes
	Input Parameters:
		PathVariable : id
		RequestParam : List<Long> courseIds
			
			Return :
				Student object with assigned course
				
				
4. Search student by name
	URL: http://localhost:8080/student_management_system/student/byName/{name}
	Authentication Required : Yes
	Input Parameters:
		PathVariable : name
		
			Retrun :
				List of Students matching input name
				
				
5. Get students assigned to perticular course	
	URL : http://localhost:8080/student_management_system/student/course/{course}
	Authentication Required : Yes
	Input Parameters:
		PathVariable : name
		
		Retrun :
				List of Students matching input course name
	
-----------------------------------------------------------------------------------------------------------------------------------------------
	
Student Operations :

1. Update profile Details (email,mobile,parent name, address)
	URL : http://localhost:8080/student_management_system/student/updateProfile
	Authentication Required : No
	Input Parameters : 
		RequestParam : studentCode
			Eg. RAM2000
		RequestParam : dob
			Eg. 2000-01-01
		RequestBody : Student object
			Eg. 
				{
					"studentId": 1,
					"email": "xyz@gmail.com",
					"mobile": 9999999902,
					"parents_name": "suresh",
					"addresses": 
					[
						{
							"addressId": 1,
							"area": "Kurla",
							"district": "Mumbai",
							"state": "Maharashtra",
							"pin": 400066,
							"type": "Permanant"
						},
						{
							"addressId": 2,
							"area": "Malad",
							"district": "Mumbai",
							"state": "Maharashtra",
							"pin": 400093,
							"type": "Current"
						}
					]
				}
			
		
2. Search for courses assigned
	URL : http://localhost:8080/student_management_system/student/course/student/{studentId}
	Authentication Required : No
	Input Parameters : 
		PathVariable : studentId
		RequestParam : studentCode
			Eg. RAM2000
		RequestParam : dob
			Eg. 2000-01-01
		
		
			Retrun :
				List of Courses matching input studentId
				
				
3. Leave Course
	URL : http://localhost:8080/student_management_system/student/course/student/leaveCourse/{id}
	Authentication Required : No
	Input Parameters : 
		PathVariable : id
		RequestParam : courseId
		RequestParam : studentCode
			Eg. RAM2000
		RequestParam : dob
			Eg. 2000-01-01
		
			Retrun :
				Student Object after removing input courseId assigned to student
	
-------------------------------------------------------------------------------------------------------------------------------------------------------

Here are some other useful URLs
  
  1. Get all students list
    URL : http://localhost:8080/student_management_system/student/all
      Authentication Required : No
      Input Parameters : None
  
  2. Get all courses list
    URL : http://localhost:8080/student_management_system/course/all
      Authentication Required : No
      Input Parameters : None
  
  
  
  
	
		

