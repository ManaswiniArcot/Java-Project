<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Files in the given Folder</title>
<style type="text/css">
table{
border-collapse:collapse;
}
th{
background-color: #4CAF50;
color: white;
}

tr:nth-child(even) {background-color: #f2f2f2}
tr:HOVER {
	background-color: #66ff99;

}
th,td{
padding:5px;
text-align: left;
}
p{
font-family:"Lucida Console";
font-style: normal;
font-size:14px;
}
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
<c:choose>
<c:when test="${path == ''}">
<p>Please enter the path.</p>
${msg}
</c:when>
<c:otherwise>
<p>
Here all the list of files in the given path: ${path}
</p><br>
<table>
<tr>
<th>File Name</th></tr>
<c:forEach items="${fileList}"  var = "file">
<tr>
<td>
<c:out value = "${file.name}">
</c:out></td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>

<form:form action="/MyJavaChallenge2/welcome">
<input type="submit" value = "Go back To Home"></form:form>
</body>
</html>