<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search Results</title>
<style type="text/css">
table{
border-collapse:collapse;
}
th{
background-color: #4CAF50;
color: white;
}

tr:nth-child(even) {background-color: #f2f2f2}
tr.list1:HOVER {
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
p.bold{
font-weight: bold;
font-style: inherit; }
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
<p class = "bold">Results are here</p>
<c:choose>
<c:when test="${empty userList}">
NO Users found with this search criteria.
</c:when>
<c:otherwise>
<p>Below are the list of users</p>
<br>
<table>
<tr class="list1">
<th>First Name</th>
<th>Last Name</th>
<th>Profession</th>
<th>City</th>
<th>State</th>
<th>Country</th></tr>
<c:forEach items="${userList}"  var = "user">
<tr class= "list1">
<td><c:out value = "${user.lastName}"></c:out></td>
<td><c:out value = "${user.firstName}"></c:out></td>
<td><c:out value = "${user.profession}"></c:out></td>
<td><c:out value="${user.city}"></c:out></td>
<td><c:out value="${user.state}"></c:out></td>
<td><c:out value="${user.country}"></c:out></td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
<form:form action="/MyJavaChallenge2/welcome">
<input type="submit" value = "Go back To Home"></form:form>
<br><%-- 
<c:forEach items="${groupList}"  var = "group">
<c:forEach items= "${group}" var = "vargroup">
<c:out value = "${vargroup}"></c:out></c:forEach>
</c:forEach> --%>

</body>
</html>