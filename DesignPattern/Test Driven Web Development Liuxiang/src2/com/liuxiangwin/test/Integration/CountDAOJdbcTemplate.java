package com.liuxiangwin.test.Integration;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.liuxiangwin.test.JdbcTemplate.DomainObjectRowMapper;
import com.liuxiangwin.test.springMVC.DomainObject;

public class CountDAOJdbcTemplate {
   private DataSource _dataSource;
	public List<Map<String, Object>> queryFromDB() throws SQLException {
		List<DomainObject> domainList;

		List<Map<String, Object>> resultList;

		DataSource dataSource = InstantiateDataSource();

		JdbcTemplate jdbcTemlate = new JdbcTemplate(dataSource);

		String sqlQuery = "select soft_count,hard_count,drop_date from caslnk.slot_detail_meter";

		resultList = jdbcTemlate.queryForList(sqlQuery);

		return resultList;

	}

	public List<DomainObject> queryByRowMapper() throws SQLException {
		List<DomainObject> domainList;

		List<Map<String, Object>> resultList;

		//DataSource dataSource = InstantiateDataSource();

		JdbcTemplate jdbcTemlate = new JdbcTemplate(_dataSource);

		String sqlQuery = "select soft_count,hard_count,drop_date from slot_detail_meter";

		RowMapper rowMapper = new DomainObjectRowMapper();
		domainList = jdbcTemlate.query(sqlQuery, rowMapper);

		return domainList;

	}

	private DataSource InstantiateDataSource() throws SQLException {

		org.apache.commons.dbcp.BasicDataSource datasource = new org.apache.commons.dbcp.BasicDataSource();
		datasource
				.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		datasource
				.setUrl("jdbc:sqlserver://localhost:49156;DatabaseName=caslnk;User=caslnk;Password=psw");
		return datasource;
	}

	public DataSource get_dataSource() {
		return _dataSource;
	}

	public void set_dataSource(DataSource dataSource) {
		_dataSource = dataSource;
	}


}
