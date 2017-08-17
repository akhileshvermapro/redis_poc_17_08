package com.example.demo.student.repo;

import java.io.IOException;
import java.util.Map;

public interface StudentRepository {
	String saveStudent(Student student);
	void deleteStudent(String id) throws IOException;
	Map<String, Student> findAllStudent() throws IOException, ClassNotFoundException;
	Student findStudent(Student student) throws IOException, ClassNotFoundException;
}
