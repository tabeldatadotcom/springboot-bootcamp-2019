package com.tabeldata.bootcamp.belajarspringboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	private DataSource datasource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(this.datasource);
	}

}
