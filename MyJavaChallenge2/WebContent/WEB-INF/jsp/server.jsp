<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status Report</title>
<style type="text/css">
body{
background-color: #f2f2f2}
p{
font-family: sans-serif;
font-size: 18px;
}
div{
padding: 5px;}
input[type=submit] {
   
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=submit]:hover {
    background-color: #45a049;
}

</style>
</head>
<body>
<p>Please see below</p>
<div><b>Tomcat:</b>${msg}</div>
<div>
<b>MySql:</b>${mysql}
</div>

<form:form action="/MyJavaChallenge2/welcome">
<input type="submit" value = "Go back To Home"></form:form>
</body>
</html>