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
	<jsp:useBean id="judgeBean" class="com.ilan.sessionbean.JudgeBean" />
	<jsp:setProperty name="judgeBean" property="insertion"
		value="${insertion }" />
	<jsp:setProperty name="judgeBean" property="n" value="${input }" />

	<jsp:useBean id="judge" class="com.ilan.sessionbean.Judge" />
	<jsp:setProperty name="judge" property="bean" value="${judgeBean }" />

	<h2>
		max= <jsp:getProperty name="judge" property="max" />
	</h2>
	
	<jsp:useBean id="parseBean" class="com.ilan.bean.URLParserBean" />
	<jsp:setProperty property="uri" name="parseBean"
		value="${header.referer }" />
	<jsp:setProperty property="param" name="parseBean" value="input=${input }&insertion=${insertion }" />

	<jsp:useBean id="parser" class="com.ilan.sessionbean.URLParser" />
	<jsp:setProperty property="bean" name="parser" value="${parseBean }" />
	<h2>
		<button type="button"
			onclick="window.location.href='${parser.parsedURL}'">"retry"</button>
		ref=<jsp:getProperty property="parsedURL" name="parser"/><br/>
	

	</h2>

</body>
</html>