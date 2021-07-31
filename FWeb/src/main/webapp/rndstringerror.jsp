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
	<h3>CAPTCHA is not correctly</h3>
	<h2>
		<button type="button"
			onclick="window.location.href='${header.referer}'">"go back"</button>
	</h2>

</body>
</html>