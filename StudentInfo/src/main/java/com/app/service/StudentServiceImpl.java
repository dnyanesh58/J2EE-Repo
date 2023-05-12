package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentRepo;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepo studService;

	@Override
	public List<Student> getAllStudents() 
	{
		return studService.findAll();
	}

	@Override
	public String addNewStudent(Student newStudent) 
	{
		String mesg = "New Student registration failed";
		if (studService.save(newStudent) != null) 
			mesg = "New Student registration done "+newStudent.getId();
		
		return mesg;
	}

	@Override
	public String updateStudent(Student existStudent) 
	{
		String mesg = "Student updation failed";
		if (studService.existsById(existStudent.getId())) 
		{
			mesg = "Student Details updated successfully "+existStudent.getId();
			studService.save(existStudent);
		}
		return mesg;
	}

	@Override
	public Student getStudentById(Long studentId) 
	{
		return studService.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not exists with this id "+studentId));
	}

	@Override
	public String deleteStudent(Long studentId) 
	{
		String mesg = "Student not exists with "+studentId;
		if (studService.existsById(studentId)) 
		{
			mesg = "Student deleted successfully "+studentId;
			studService.deleteById(studentId);
		}
		return mesg;
	}
}
