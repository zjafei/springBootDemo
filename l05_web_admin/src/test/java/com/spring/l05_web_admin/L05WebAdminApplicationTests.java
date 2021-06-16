package com.spring.l05_web_admin;

import java.util.List;

import javax.sql.DataSource;

import com.spring.l05_web_admin.mapper.UserMapper;
import com.spring.l05_web_admin.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class L05WebAdminApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserMapper userMapper;

	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Test
	void contextLoads() {
		// jdbcTemplate.queryForObject("select * from user", rowMapper);
		// jdbcTemplate.queryForList("select * from user");
		Long aLong = jdbcTemplate.queryForObject("select count(*) from innodb_index_stats", Long.class);
		log.info("记录总数：{}", aLong);
		log.info("数据源类型:{}", dataSource.getClass());
	}

	@Test
	void testUserMapper() {
		List<User> list = userMapper.selectList(null);
		list.forEach(System.out::println);
	}


	@Test
	void testRedis() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set("hello","world");
		System.out.println(operations.get("hello"));
		System.out.println(redisConnectionFactory.getClass());
	}
}
