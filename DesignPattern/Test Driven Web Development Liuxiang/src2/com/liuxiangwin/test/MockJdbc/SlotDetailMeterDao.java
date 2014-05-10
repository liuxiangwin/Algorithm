package com.liuxiangwin.test.MockJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.liuxiangwin.test.springMVC.DomainObject;

public class SlotDetailMeterDao {

	private List<DomainObject> _countInfoList;
	private DataSource _dataSource;

	public void set_dataSource(DataSource dataSource) {
		_dataSource = dataSource;
	}

	public DataSource get_dataSource() {
		return _dataSource;
	}

	public List<Date> GetDropDate() {
		_countInfoList = QueryFromDB();
		List<Date> dropDateList = new ArrayList<Date>();

		for (DomainObject count : _countInfoList) {
			dropDateList.add(count.get_dropDate());
			System.out.println(count.get_dropDate());
		}
		return dropDateList;
	}

	public List<Double> GetSoftCountAmount() {
		_countInfoList = QueryFromDB();
		List<Double> softAmountList = new ArrayList<Double>();
		for (DomainObject count : _countInfoList) {
			softAmountList.add(count.get_softCount());
			System.out.println(count.get_softCount());
		}

		return softAmountList;
	}

	public List<DomainObject> QueryFromDB() {
		Connection connection = null;
		// Statement statement = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<DomainObject> infoList = null;

		try {
			//connection =InitiateWithDataSource();
			
			connection =InitiateWithJDBC();
			//connection = _dataSource.getConnection();
			if (connection != null) {

				String sql = "select soft_count,hard_count,drop_date from caslnk.slot_detail_meter";
				statement = connection.prepareStatement(sql);
				result = statement.executeQuery();

				infoList = new ArrayList<DomainObject>();
				while (result.next()) {
					DomainObject domainObject = new DomainObject();
					domainObject.set_softCount(result.getDouble("soft_count"));
					domainObject.set_hardCount(result.getDouble("hard_count"));
					domainObject.set_dropDate(result.getDate("drop_date"));
					infoList.add(domainObject);
				}
				/*
				 * result.close(); statement.close(); connection.close();
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}

				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return infoList;
	}

	private Connection InitiateWithJDBC() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		Connection connection;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.newInstance();
		//String url = "jdbc:sqlserver://localhost:1433;DatabaseName=caslnk;User=caslnk;Password=psw";
		
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=caslnk;User=sa;Password=liuxiang";
		connection = DriverManager.getConnection(url);
		return connection;
	}

	private Connection InitiateWithDataSource() throws SQLException {
		Connection connection;

		org.apache.commons.dbcp.BasicDataSource _datasource = new org.apache.commons.dbcp.BasicDataSource();
		_datasource
				.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//String conString="jdbc:sqlserver://localhost:49157;DatabaseName=caslnk;User=caslnk;Password=psw";
		
		//String conString="jdbc:sqlserver://localhost:1433;DatabaseName=caslnk;User=sa;Password=liuxiang";
		
		String conString="jdbc:sqlserver://localhost:1433;databaseName=caslnk;integratedSecurity=true"; 


		//String conString="jdbc:sqlserver://localhost:1433;DatabaseName=caslnk;User=caslnk;Password=psw";
		
		_datasource
				.setUrl(conString);
		// _datasource.setUsername("caslnk");
		// _datasource.setPassword("psw");
		connection = _datasource.getConnection();

		return connection;
	}

	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		SlotDetailMeterDao countDao = new SlotDetailMeterDao();
		
		Pring(countDao.QueryFromDB());

	}

	private static void Pring(List<DomainObject> list) {
		for (DomainObject domainObject : list) {
			System.out.println(domainObject.get_softCount());
			System.out.println(domainObject.get_hardCount());
			System.out.println(domainObject.get_dropDate());
			System.out.println("================================");

		}
	}

}
