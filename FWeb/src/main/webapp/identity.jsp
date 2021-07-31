<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#change").click(function() {
			$("#img").attr("src", "servlet/IdentityServlet?time="+new Date().getTime());

		});
	});
</script>
</head>
<body>
	<img src="servlet/IdentityServlet" id="img"
		onload="change.disabled=false;" />
	<input type="button" id="change" value="change" />
	<br />
</body>
</html>