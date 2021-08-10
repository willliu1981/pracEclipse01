<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.net.URLEncoder"%>
<jsp:directive.page import="java.net.URLDecoder" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie c = new Cookie(URLEncoder.encode("一", "UTF-8"), URLEncoder.encode("二", "UTF-8"));
	response.addCookie(c);
	%>

	<h1>jsp1</h1>
	<%
	/*
		<jsp:useBean id="user" class="com.ilan.bean.User"></jsp:useBean>
		<jsp:setProperty property="name" name="user" value="Ken"/>
		name= <jsp:getProperty property="name" name="user"/>//*/
	%>


	a=${paramValues.a[1]}

	<form action="jsp2.jsp" method="post">
		<input type="button" value="refresh"
			onclick="location='<%=request.getRequestURI()%>?ts='+new Date().getTime()" />
		<input type="button" value="refresh2"
			onclick="location=location+'?ts='+new Date().getTime()" />

	</form>

	<h1>
		<%
		if (request.getCookies() != null) {
			for (Cookie cc : request.getCookies()) {
				String cname = URLDecoder.decode(cc.getName(), "UTF-8");
				String cvalue = URLDecoder.decode(cc.getValue(), "UTF-8");

				out.println(cname + "=" + cvalue + "<br/>");
			}
		}
		%>

	</h1>



</body>
</html>