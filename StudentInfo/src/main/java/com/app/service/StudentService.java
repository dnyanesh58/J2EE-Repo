package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface StudentService 
{
	List<Student> getAllStudents();
	
	String addNewStudent(Student newStudent);
	
	String updateStudent(Student existStudent);
	
	Student getStudentById(Long studentId);
	
	String deleteStudent(Long studentId);
}
