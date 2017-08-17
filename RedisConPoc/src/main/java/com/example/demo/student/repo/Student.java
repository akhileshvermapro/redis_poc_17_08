package com.example.demo.student.repo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name;
	private String gender;
	private int grade;
	
	public Student(){};
	public Student(String id, String name, String gender, int grade){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.grade=grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
