package com.liuxiangwin.test.Integration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.liuxiangwin.test.util.SqlExecutor;

public abstract class DBUnitIntergationBase extends DatabaseTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		createSchema();
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		// TODO Auto-generated method stub
		return new DatabaseConnection(getDBConnection());
	}
	
	


	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return getDataSet("initial");
	}
	
	private void createSchema() throws SQLException, IOException
	{
		String resource = "/Database-schema.sql";
		InputStream schema = getClass().getResourceAsStream(resource);
		assertNotNull("Resource \"" + resource + "\" not found", schema);
		new SqlExecutor(getDBConnection()).execute(schema);
		
		
	}
	
	
	
	protected  Connection getDBConnection() throws SQLException
	{
	    try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return DriverManager.getConnection("jdbc:hsqldb:mem:testdb");
		
	}

	private IDataSet getDataSet(String name) throws DataSetException, IOException {
		String resource = getClass().getSimpleName() + "." + name + ".xml";
		InputStream stream = getClass().getResourceAsStream(resource);
		assertNotNull("Resource " + resource + " not found.", stream);
		return new FlatXmlDataSet(stream);
		

	}

}
