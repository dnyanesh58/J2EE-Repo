package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studService;
	
	public StudentController()
	{
		System.out.println("In Ctor : "+this.getClass());
	}
	
	@GetMapping
	public List<Student> getAllStudentsDetails()
	{
		return studService.getAllStudents();
	}
	
	@PostMapping
	public String addNewStudent(@RequestBody Student newStud)
	{
		return studService.addNewStudent(newStud);
	}
	
	@PutMapping
	public String updateStudent(@RequestBody Student existStud)
	{
		return studService.updateStudent(existStud);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		return studService.deleteStudent(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id)
	{
		try
		{
			return ResponseEntity.ok(studService.getStudentById(id));
		}
		catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
