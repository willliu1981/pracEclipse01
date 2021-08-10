<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.ilan.bean.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
User u = new User();
//u.setName("Kevin");
request.setAttribute("user", u);
%>
</head>
<body>
<c:set target="${user }" property="name" value="Helen"></c:set>
Jsp2 name=${user.name }
</body>
</html>