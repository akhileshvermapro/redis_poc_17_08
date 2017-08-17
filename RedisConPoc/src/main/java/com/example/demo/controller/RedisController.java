package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.repo.Student;
import com.example.demo.student.repo.StudentRepository;

@RestController
@RequestMapping("/redis/*")
public class RedisController {
	

	
	@Autowired
	StudentRepository repo;

	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody Student student) throws InterruptedException{
		return repo.saveStudent(student);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestBody Student student) throws InterruptedException, IOException{
		repo.deleteStudent(student.getId());
		return "deleted";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Student> findAll() throws InterruptedException, ClassNotFoundException, IOException{
		return repo.findAllStudent();
		
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	@ResponseBody
	public Student find(@RequestBody Student student) throws InterruptedException, ClassNotFoundException, IOException{
		return repo.findStudent(student);
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public String update(@RequestBody Student student) throws InterruptedException, ClassNotFoundException, IOException{
		repo.saveStudent(student);
		return  "updated";
	}
	
	@RequestMapping(value="/healthCheck", method=RequestMethod.GET)
	@ResponseBody
	public String healthCheck() throws InterruptedException{
		return "System is UP!!";
		
	}

	

	


}
