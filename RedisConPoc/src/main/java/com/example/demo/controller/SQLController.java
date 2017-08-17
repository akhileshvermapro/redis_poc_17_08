package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.StudentDatabaseRepository;
import com.example.demo.database.model.Student;

@RestController
@RequestMapping("/sql/*")
public class SQLController {
	
	@Autowired
	StudentDatabaseRepository repo;
	
	@RequestMapping(value="/save", method=RequestMethod.PUT)
	@ResponseBody
	public String save(@RequestBody Student student) throws InterruptedException{
		repo.save(student);
		return "saved";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	@ResponseBody
	public List<Student> findAll() throws InterruptedException{
		return (List<Student>) repo.findAll();
		
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	@ResponseBody
	public Student find(@RequestBody Student student) throws InterruptedException{
		return  repo.findOne(student.getId());
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody Student student) throws InterruptedException{
		 repo.delete(student.getId());
		 return "deleted";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody Student student) throws InterruptedException{
		 repo.save(student);
		 return "saved";
	}
	
	@RequestMapping(value="/healthCheck", method=RequestMethod.GET)
	@ResponseBody
	public String healthCheck() throws InterruptedException{		 
		 return "SQL System is UP!!";
	}
	
	
	
}
