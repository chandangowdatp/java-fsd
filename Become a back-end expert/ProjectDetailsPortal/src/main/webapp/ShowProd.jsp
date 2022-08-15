<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.practice.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product details</title>
</head>
<body>
<jsp:useBean id="obj" class="com.practice.Product" 
scope="session" />

 Product Name:<jsp:getProperty property="pName" name="obj"/><br>
 Product Price:<jsp:getProperty property="pPrice" name="obj"/><br>
 Product Freshness:<jsp:getProperty property="pFreshness" name="obj"/><br>

</body>
</html>