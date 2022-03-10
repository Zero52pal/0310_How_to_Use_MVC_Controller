<%@page import="java.util.LinkedList"%>
<%@page import="Pack01.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = (int)request.getAttribute("num");
		out.println(num + "</br>");
		out.println("</br>");
		
		String str = (String)request.getAttribute("str");
		out.println(str + "</br>");
		out.println("</br>");
		
		int[] arr = (int[])request.getAttribute("arr");
		
		for(int i =0; i < arr.length; i++){
			out.println(arr[i] + "</br>");		
		}out.println("</br>");
		
		for(int v : arr){
			out.println(v + "</br>");
		}out.println("</br>");
		
		Person p = (Person)request.getAttribute("person");
		out.println(p.getId()+"</br>");
		out.println(p.getPwd()+"</br>");
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> list01 = 
				(LinkedList<Integer>)request.getAttribute("list");
		out.println(list01.get(0)+"</br>");
		out.println(list01.get(1)+"</br>");
		out.println(list01.get(2)+"</br>");
		out.println("</br>");
		
		@SuppressWarnings("unchecked")
		LinkedList<String> list02 = 
				(LinkedList<String>)request.getAttribute("list2");
		out.println(list02.get(0)+"</br>");
		out.println(list02.get(1)+"</br>");
		out.println(list02.get(2)+"</br>");
		out.println("</br>");
		
		@SuppressWarnings("unchecked")
		LinkedList<Person> list03 = 
				(LinkedList<Person>)request.getAttribute("list3");
		out.println(list03.get(0).getId() + " : " + list03.get(0).getPwd() +"</br>");
		out.println(list03.get(1).getId() + " : " + list03.get(1).getPwd() +"</br>");
		out.println(list03.get(2).getId() + " : " + list03.get(2).getPwd() +"</br>");
		out.println("</br>");
	%>
	
	<c:forEach var="arr" items="${arr}" varStatus="b">
    	${b.index} : ${arr}</br>
	</c:forEach>
</body>
</html>