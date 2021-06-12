package com.spring.l05_web_admin;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class L05WebAdminApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
		// jdbcTemplate.queryForObject("select * from user", rowMapper);
		// jdbcTemplate.queryForList("select * from user");
		Long aLong = jdbcTemplate.queryForObject("select count(*) from innodb_index_stats", Long.class);
        log.info("记录总数：{}", aLong);
		log.info("数据源类型:{}", dataSource.getClass());
	}

}
