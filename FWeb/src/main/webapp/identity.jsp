<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function reload() {
		document.getElementById("change").disabled = true;
		document.getElementById("img").src = "servlet/IdentityServlet?time="
				+ new Date().getTime();
	}

	$(document)
			.ready(
					function() {
						$("#change").click(
								function() {
									$("#change").attr("enabled", true);
									jQuery("#img").attr(
											"src",
											"servlet/IdentityServlet?time="
													+ String(
															new Date()
																	.getTime())
															.toString());
								});
						$("#send")
								.click(
										function() {
											location.href = "http://localhost:8088/FWeb/servlet/JudgeServlet?input="
													+ $("#input").val()
													+ "&insertion="
													+ $("#insertion").val()
													+ "&CAPTCHA="
													+ $("#CAPTCHA").val();
										});
					});
</script>
</head>
<body>
	input=${input}
	<br /> ref=${header.referer}
	<br />

	<span>insertion= </span>
	<input type="text" id="insertion"
		value="<%=request.getParameter("insertion")%>" />
	<br />
	<span>n= </span>
	<input type="text" id="input"
		value="<%=request.getParameter("input")%>" />
	<br />
	<br />
	<img src="servlet/IdentityServlet" id="img"
		onload="change.disabled=false;" />
	<input type="button" id="change" value="change" />
	<br />
	<span>CAPTCHA= </span>
	<input type="text" id="CAPTCHA" />
	<br />
	<input type="button" id="send" value="send" />
	<br />

</body>
</html>