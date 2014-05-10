<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="java.net.URLDecoder"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<title>Insert title here</title>
	</head>


	<%
		String cookieName = "Alan";
		Cookie[] cookies = request.getCookies();
		//HttpClient client = new HttpClient();
    
		Cookie setCookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					setCookie = cookies[i];
					break;
					
				}

			}
		}
	%>
	<body>

		<font color="green"><h2>
				This Geed Cookles</>h2
			</h2>
		</font>
		<br>
		This is Cookie Details
		<br>
		The Cookies Detais is Here
		<br>
		You set cookie info is like
		<%
			if (setCookie == null) {
		%>
		you cookie is expried
		<%
			} else {
		%>
		this <%=URLDecoder.decode(setCookie.getValue()) %>
		<%
			}
		%>
	</body>
</html>