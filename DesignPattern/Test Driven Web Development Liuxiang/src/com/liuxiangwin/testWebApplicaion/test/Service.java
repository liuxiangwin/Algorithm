package com.liuxiangwin.testWebApplicaion.test;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Service {

	public DataAccessObject dataAccess;

	public List<SlotDetailMeter> GetCountInfo() throws SQLException {

		// dataAccess=new DataAccessObject();
		// ApplicationContext ctx = AppContext.getAppContext();
		
        //This Way is use the Spring to Manager the reference;
		List<SlotDetailMeter> countList = dataAccess.GetSlotDetailMeter();
		return countList;

	}

	public List<SlotDetail> GetDetailInfo(ServletContext servletContext)throws SQLException {
		//In the WebApplication,through the servletContext get the Spring cofiguration
		WebApplicationContext applicationContext = WebApplicationContextUtils
		.getWebApplicationContext(servletContext);

		DataAccessObject dataAccessObject =(DataAccessObject)applicationContext.getBean("dataAccessObject");
		
		List<SlotDetail> detailList = dataAccessObject.GetSlotDetail();
		return detailList;
	}

	public DataAccessObject getDataAccess() {
		return dataAccess;
	}

	// @Autowired
	public void setDataAccess(DataAccessObject dataAccess) {
		this.dataAccess = dataAccess;
	}

}
