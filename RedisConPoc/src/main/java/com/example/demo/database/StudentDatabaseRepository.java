package com.example.demo.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.database.model.Student;

@Transactional
public interface StudentDatabaseRepository extends CrudRepository<Student, Integer>{

}
