package com.tabeldata.bootcamp.belajarspringboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tabeldata.bootcamp.belajarspringboot.model.Rak;

@Repository
@Transactional(readOnly=true)
public class RakDao {
	
	@Autowired
	private JdbcTemplate jdbcTempate;
	
	
	

}
