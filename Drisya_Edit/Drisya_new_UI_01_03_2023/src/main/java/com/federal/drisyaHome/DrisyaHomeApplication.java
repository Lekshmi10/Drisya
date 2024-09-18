package com.federal.drisyaHome;

import com.federal.drisyaHome.model.DrisyaTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

//@EnableOAuth2Sso
@EnableScheduling
@SpringBootApplication
public class DrisyaHomeApplication extends SpringBootServletInitializer{
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		RedisProperties properties = redisProperties();
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName(properties.getHost()); //("redis-12172.c257.us-east-1-3.ec2.cloud.redislabs.com");
		connectionFactory.setPort(properties.getPort());//(12172);
		connectionFactory.setPassword(properties.getPassword());//("fV1iQr5uQt5ef1sRr6ZkPc6ggfD5xr3y");
		connectionFactory.setDatabase(properties.getDatabase());
		return connectionFactory;
	}

	@Bean
	RedisTemplate<Integer, DrisyaTable> redisTemplate(){
		RedisTemplate<Integer, DrisyaTable> redisTemplate = new RedisTemplate<Integer, DrisyaTable>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(DrisyaTable.class));
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	@Primary
	public RedisProperties redisProperties() {
		return new RedisProperties();
	}
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(DrisyaHomeApplication.class, args);
	}
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(DrisyaHomeApplication.class);
	  }

}
