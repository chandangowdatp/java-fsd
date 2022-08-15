<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.practice.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product Details</title>
</head>
<body>
<jsp:useBean id="obj" class ="com.practice.Product" 
scope="session" />
<jsp:setProperty property="*" name="obj" />

<a href="ShowProd.jsp">Show Product Details</a>
</body>
</html>