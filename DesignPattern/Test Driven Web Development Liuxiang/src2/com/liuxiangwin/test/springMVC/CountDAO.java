package com.liuxiangwin.test.springMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountDAO {

	private List<DomainObject> _countInfoList;

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

	private List<DomainObject> QueryFromDB() {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		List<DomainObject> infoList = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance();

			// connection = DriverManager.getConnection(
			// "jdbc:sqlserver://localhost:1433", "caslnk", "psw");
			String url = "jdbc:sqlserver://localhost:49156;DatabaseName=caslnk;User=caslnk;Password=psw";
			connection = DriverManager.getConnection(url);
			// .getConnection("jdbc:sqlserver://localhost:1433;Database=caslnk;User=caslnk;Password=psw");

			if (connection != null) {
				statement = connection.createStatement();
				// String sql =
				// "select soft_count,hard_count,drop_date from caslnk.caslnk.slot_detail_meter";
				String sql = "select soft_count,hard_count,drop_date from caslnk.slot_detail_meter";
				statement.execute(sql);
				result = statement.getResultSet();
				infoList = new ArrayList<DomainObject>();
				while (result.next()) {
					DomainObject domainObject = new DomainObject();
					domainObject.set_softCount(result.getDouble("soft_count"));
					domainObject.set_hardCount(result.getDouble("hard_count"));
					domainObject.set_dropDate(result.getDate("drop_date"));
					infoList.add(domainObject);
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				result.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return infoList;
	}

	public static void main(String args[]) {

		CountDAO countDao = new CountDAO();
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
