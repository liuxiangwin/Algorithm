<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ page language="java"
	import="com.liuxiangwin.testWebApplicaion.test.*"%>
<%@ page language="java"
	import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'countInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		Here is Count Information
		<br>

		<%
			//Service service = new Service();		

			WebApplicationContext applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		   
			Service service =(Service)applicationContext.getBean("Service");

			List<SlotDetailMeter> countList = service.GetCountInfo();
		%>
		<%
			for (SlotDetailMeter slotDetailMeter : countList) {
		%>
		<%=slotDetailMeter.get_dropDate()%>
		<%=slotDetailMeter.get_softCount()%>
		<%=slotDetailMeter.get_harCount()%>
		<br>

		<%
			}
		%>
	</body>
</html>
