package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30,nullable = false)
	private String name;
	
	@Column(nullable = false)
	private long rollNo;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10,nullable = false)
	private Course courseName;
	
	@Column(nullable = false)
	private int age;
}
