package com.liuxiangwin.test.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.liuxiangwin.test.springMVC.DomainObject;

public class DomainObjectRowMapper implements RowMapper {

	public Object mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		
		return new DomainObject(
				resultSet.getDouble("soft_count"),
				resultSet.getDouble("hard_count")
				,resultSet.getDate("drop_date"));	

	}

}
