<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page
	import="java.io.File,org.w3c.dom.*,java.io.IOException,org.xml.sax.SAXException,javax.xml.parsers.DocumentBuilder,javax.xml.parsers.DocumentBuilderFactory,javax.xml.parsers.ParserConfigurationException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String script = null;%>

	<%
	//這段應該要寫在一個 servlet ,這裡為了方便,在這裡寫上java code

	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	File f = new File(getServletContext().getRealPath("/WEB-INF/CDATAScript.xml"));
	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);

		Element root = doc.getDocumentElement();
		NodeList chileNodes = root.getChildNodes();
		for (int i = 0; i < chileNodes.getLength(); i++) {
			Node node = chileNodes.item(i);
			if (node.getNodeName().equals("scriptCode")) {

		//補充:MyEclipse 的自動排版比Eclipse 爛,有些排版看起來就不太對,例如以下...
		script = node.getTextContent();
		request.setAttribute("script", script);

			}
		}

	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	%>


	<%
	out.println("<script type='text/javascript'>");
	out.println("function test1(){");

	out.println("a=1,b=2;");
	out.println(script);

	out.println("}</script>");
	%>

	<script type="text/javascript">
		function test2(){
			a=1,b=2;
			
			alert('xxx');
			
			//<%=script%>;

		}
	</script>




	root=${script}
	<br />

	<button type="button" onclick="test1();">test1</button>
	<br />
	<button type="button" onclick="test2();">test2</button>
	<br />
</body>
</html>