package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.student.repo.Student;

@Configuration
@Profile("localRedis")
public class RedisConfigsSap {
	
	@Value("${localRedis.host}")
	public String host;
	@Value("${localRedis.port}")
	public int port;	
	@Value("${localRedis.pass}")
	public String pass;
	
	
	
	@Bean
	public JedisConnectionFactory jedisConnFactory(){
		JedisConnectionFactory connFactory = new JedisConnectionFactory();
		connFactory.setHostName(this.host);
		connFactory.setPort(this.port);
		return connFactory;			
	}
	
	@Bean
	public RedisTemplate<String, Student> redisTemplate(){
		RedisTemplate<String, Student> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnFactory());
		return template;		
	}	


}
