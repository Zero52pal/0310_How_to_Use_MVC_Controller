<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>여기는 호랑이뷰</h3>
	
	<!-- model로 던져진 데이터를 Servlet문법으로 받는 방법 -->
	<%
		// String nn = request.getParameter("name"); 
		// model을 통한 인수전달은 getAttribute사용
		String nn = (String)request.getAttribute("name");
		int aa = (Integer)request.getAttribute("age");
	%>
	<%=nn %>
	<%=aa %>
	
	<!-- model로 던져진 데이터 받는 방법 -->
	<h3>${name} ${age}</h3>
	
</body>
</html>