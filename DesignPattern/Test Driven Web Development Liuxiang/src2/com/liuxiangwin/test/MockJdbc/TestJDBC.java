package com.liuxiangwin.test.MockJdbc;


import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.liuxiangwin.test.springMVC.DomainObject;
import com.mockobjects.sql.MockMultiRowResultSet;




public class TestJDBC {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void  Test_JDBC_WithMock() throws SQLException
	{
		DataSource dataSource=createMock(DataSource.class);		
		Connection connection=createMock(Connection.class);
		
		//Tell the easyMock Object should  get connection
		expect(dataSource.getConnection()).andReturn(connection);	
		
		String sqlQuery="select soft_count,hard_count,drop_date from caslnk.slot_detail_meter";
		
		PreparedStatement stmt=createMock(PreparedStatement.class);		
		//Tell the Connection Object should return a Preparestatemen class
		expect(connection.prepareStatement(sqlQuery)).andReturn(stmt);			
		
		List<DomainObject> expectedList = createExpectedList();			
		
		MockMultiRowResultSet resultset = new MockMultiRowResultSet();	
		
		String[] columns = new String[] {"soft_count", "hard_count" ,"drop_date"};		
		
		//Set Up the Mock ResultSet
        resultset.setupColumnNames(columns);        
        
        resultset.setupRows(resultSetToArray(expectedList));
        
        expect(stmt.executeQuery()).andReturn(resultset);
        //Tell the Result set should close once
    	resultset.setExpectedCloseCalls(1);
    	
        //Tell the PrepareStatement should close
    	stmt.close();
    	
    	//Tell the Connection should close
		connection.close();

		//replay(dataSource, connection, stmt);

        //Invoke the Production Code
        SlotDetailMeterDao slotDetailMeterDao=new SlotDetailMeterDao();
        
        slotDetailMeterDao.set_dataSource(dataSource);
        
        List<DomainObject> actualList= slotDetailMeterDao.QueryFromDB();
        
        Assert.assertEquals(expectedList,actualList);
        //Verify All the Mock Object
        //verify(dataSource, connection, stmt);
        
        //resultset.verify();
        
        
 
	}
	
	
    @SuppressWarnings("deprecation")
	private List<DomainObject> createExpectedList() {
        List<DomainObject> expectedList = new ArrayList<DomainObject>();
        expectedList.add(new DomainObject(20,0,new java.sql.Date(2010,4,21)));
        expectedList.add(new DomainObject(-20,0,new java.sql.Date(2010,4,21)));
        expectedList.add(new DomainObject(8611,0,new java.sql.Date(2010,4,21)));
        expectedList.add(new DomainObject(26,0,new java.sql.Date(2010,10,22)));
      
        return expectedList;
    }
    private Object[][] resultSetToArray(List<DomainObject> domainList) {
        Object[][] objArray = new Object[domainList.size()][3];
        for (int i = 0; i < objArray.length; i++) 
        {
        	DomainObject domainObject = domainList.get(i);
        	
        	objArray[i] = new Object[] 
                  { domainObject.get_softCount(),
            		domainObject.get_hardCount(),
            		domainObject.get_dropDate()};
        }
        return objArray;
    }
}
