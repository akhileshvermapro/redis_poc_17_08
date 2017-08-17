package com.example.demo.student;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.student.repo.Student;
import com.example.demo.student.repo.StudentRepository;


@Component
@Profile(value="localRedis")
public class StudentRepositoryImplSap implements StudentRepository {
	
private static final String KEY = "student";
	
	@Autowired
	private RedisTemplate<String, Student> redisTemplate;

	
	
	@Override
	public String saveStudent(Student student) {
		BoundHashOperations<String, String, Student> hashOps = redisTemplate.boundHashOps(KEY);
		hashOps.put(student.getId(), student);
		return "saved";
				
	}
	
	public void deleteStudent(String id){
		BoundHashOperations<String, String, Student> hashOps = redisTemplate.boundHashOps(KEY);
		hashOps.delete(id);
	}
	
	public Map<String, Student> findAllStudent(){
		BoundHashOperations<String, String, Student> hashOps = redisTemplate.boundHashOps(KEY);
		return hashOps.entries();
	}

	@Override
	public Student findStudent(Student student) {
		BoundHashOperations<String, String, Student> hashOps = redisTemplate.boundHashOps(KEY);
		return hashOps.get(student.getId());
	}

}
