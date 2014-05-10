package DesignPattern.Division;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuxiangwin.test.springMVC.DomainObject;

public class TestMySQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestMySQL().QueryFromDB();
	}
	
	
	public List<DomainObject> QueryFromDB() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<DomainObject> infoList = null;
		


		
		
		
		try {
			connection =InitiateWithDataSource();
			//connection = _dataSource.getConnection();
			if (connection != null) {

				String sql = "SELECT * FROM customer c;";
				statement = connection.prepareStatement(sql);
				result = statement.executeQuery();

				infoList = new ArrayList<DomainObject>();
				while (result.next()) {
					
					System.out.println(result.getString("firstname"));
				}
				
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

	
	private Connection InitiateWithDataSource() throws SQLException {
		Connection connection;

		org.apache.commons.dbcp.BasicDataSource _datasource = new org.apache.commons.dbcp.BasicDataSource();
		_datasource
				.setDriverClassName("com.mysql.jdbc.Driver");
		
		
		String conString="jdbc:mysql://localhost:3306/dbo";
		
		_datasource
				.setUrl(conString);
		
		_datasource.setUsername("root");
		 _datasource.setPassword("liuxiang");
		connection = _datasource.getConnection();

		return connection;
	}
	
	


}
