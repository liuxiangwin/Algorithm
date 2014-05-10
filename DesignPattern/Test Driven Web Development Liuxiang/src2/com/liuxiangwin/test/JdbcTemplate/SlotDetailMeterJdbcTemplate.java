package com.liuxiangwin.test.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.liuxiangwin.test.springMVC.DomainObject;

public class SlotDetailMeterJdbcTemplate {

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

		DataSource dataSource = InstantiateDataSource();

		JdbcTemplate jdbcTemlate = new JdbcTemplate(dataSource);

		String sqlQuery = "select soft_count,hard_count,drop_date from caslnk.slot_detail_meter";

		RowMapper rowMapper = new DomainObjectRowMapper();
		domainList = jdbcTemlate.query(sqlQuery, rowMapper);

		return domainList;

	}

	private DataSource InstantiateDataSource() throws SQLException {

		org.apache.commons.dbcp.BasicDataSource datasource = new org.apache.commons.dbcp.BasicDataSource();
		datasource
				.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		datasource
				.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=caslnk;User=sa;Password=liuxiang");
		return datasource;
	}

	public static void main(String args[]) throws SQLException {
		SlotDetailMeterJdbcTemplate SlotDetailMeterJdbcTemplate = new SlotDetailMeterJdbcTemplate();

		List<Map<String, Object>> resultList = SlotDetailMeterJdbcTemplate
				.queryFromDB();

		List<DomainObject> domainList = SlotDetailMeterJdbcTemplate
				.queryByRowMapper();
		for (DomainObject domain : domainList) {
			System.out.println(domain.get_softCount());

			System.out.println(domain.get_hardCount());

			System.out.println(domain.get_dropDate());
		}
	}

	// The Best practice to iterator Map

	private static void PringMapList(List<Map<String, Object>> resultList) {
		for (Map<String, Object> slotDetailMeter : resultList) {

			System.out.println(slotDetailMeter.get("soft_count"));

			System.out.println(slotDetailMeter.get("hard_count"));

			System.out.println(slotDetailMeter.get("drop_date"));
		}
	}

}
