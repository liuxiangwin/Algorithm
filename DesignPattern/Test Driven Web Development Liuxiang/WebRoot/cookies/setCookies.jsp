<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'setCookies.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
     //Only When The Brower Start the cookie works
     String cookieName="Alan";
     Date now=new Date();
     String timeStamp=now.toString();
     String cookieValue=  java.net.URLEncoder.encode(timeStamp,"utf-8");
     
     
     String cookieValue2=  java.net.URLEncoder.encode("LiuXiang is good person","utf-8");
     Cookie cookies =new Cookie(cookieName,cookieValue2);
     //cookies.setPath("/Test Driven Web Development Liuxiang/cookies");
     cookies.setMaxAge(24*60*60);
            
     cookies.setVersion(0);
     cookies.setSecure(false);
     cookies.setComment("This is test set cookies by alan");
      
     response.addCookie(cookies);
     
  
   %>
  <body> 
  <font color="blue"><h2>This Blue Cookles</>h2</h2></font>
    <br>This is my JSP page. <br>
    The Cookies Detais is Here<a  href="getCookies.jsp">Click Here</a>
  </body>
</html>
