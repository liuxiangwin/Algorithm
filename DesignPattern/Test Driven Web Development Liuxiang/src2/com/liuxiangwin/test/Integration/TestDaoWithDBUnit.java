package com.liuxiangwin.test.Integration;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liuxiangwin.test.MockJdbc.SlotDetailMeterDao;
import com.liuxiangwin.test.springMVC.DomainObject;

public class TestDaoWithDBUnit extends DBUnitIntergationBase {

	private DataSource _dataSouce;

	private List<DomainObject> _expectedList;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		_dataSouce = new org.apache.commons.dbcp.BasicDataSource() {
			@Override
			// Use the super class get Connection
			public Connection getConnection() throws SQLException {
				return getDBConnection();
			}
		};
		_expectedList = createMeterList();
	}

	@After
	public void tearDown() throws Exception {
	}
   

	
	@Test
	public void test_Dao_WithIntegration() throws SQLException {
		CountDAOJdbcTemplate countDao = new CountDAOJdbcTemplate();
		countDao.set_dataSource(_dataSouce);

		// connection = _datasource.getConnection();
		Assert.assertEquals(_expectedList, countDao.queryByRowMapper());

	}
	
	private List<DomainObject> createMeterList() throws ParseException {
		List<DomainObject> expectedList = new ArrayList<DomainObject>();
		expectedList.add(new DomainObject(96, 50, formatter
				.parse("2011-07-01")));
		expectedList.add(new DomainObject(97, 60, formatter
				.parse("2011-07-01")));
		expectedList.add(new DomainObject(120, 70, formatter
				.parse("2011-07-01")));		
		return expectedList;	
		

	}
	private static SimpleDateFormat formatter = new SimpleDateFormat(
	"yyyy-MM-dd");

	
	

	
}
