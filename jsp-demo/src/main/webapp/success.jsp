<%@page import="comm.example.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success page</title>
</head>
<body>
<%

	Student student=(Student)request.getAttribute("success");
	out.println("First Name: "+student.getFName());

%>
</body>
</html>