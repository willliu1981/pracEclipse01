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
	<jsp:useBean id="parseBean" class="com.ilan.bean.URLParserBean" />
	<jsp:setProperty property="uri" name="parseBean"
		value="${header.referer }" />
	<jsp:setProperty property="param" name="parseBean" value="input=${input }&insertion=${insertion }" />

	<jsp:useBean id="parser" class="com.ilan.sessionbean.URLParser" />
	<jsp:setProperty property="bean" name="parser" value="${parseBean }" />
	<h2>
		<button type="button"
			onclick="window.location.href='${parser.parsedURL}'">"go
			back"</button>
		ref=<jsp:getProperty property="parsedURL" name="parser"/>

	</h2>

</body>
</html>