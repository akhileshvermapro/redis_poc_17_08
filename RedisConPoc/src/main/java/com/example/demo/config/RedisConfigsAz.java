package com.example.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

@Configuration
@Profile("azureRedis")
public class RedisConfigsAz {
	
	@Value("${azureRedis.host}")
	public String host;
	@Value("${azureRedis.port}")
	public int port;	
	@Value("${azureRedis.pass}")
	public String pass;
	
	@Bean
	public Jedis getJedis(){
		return new Jedis(getJedisShardInfo());		
	}	
	
	@Bean
	public JedisShardInfo getJedisShardInfo(){
	
		JedisShardInfo jediShard = new JedisShardInfo(this.host, this.port, true);
		jediShard.setPassword(this.pass);
		
		return jediShard;
	}
	
}
