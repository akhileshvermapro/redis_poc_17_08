package com.example.demo;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class RedisConPocApplication {;
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RedisConPocApplication.class, args);
	
	}
}
