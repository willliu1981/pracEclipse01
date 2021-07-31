<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test judge</h1>
	<jsp:useBean id="judge" class="com.ilan.bean.JudgeBean" />
	<jsp:setProperty name="judge" property="insertion"
		value="${ insertion}" />
	<jsp:setProperty name="judge" property="n" value="${input }" />
	<h2>
		<jsp:getProperty name="judge" property="max" />
	</h2>

</body>
</html>