<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
<style type="text/css">
body{
background-color: #f2f2f2}
p.bold{
font-weight: bold;
font-style: inherit; }
select{
width: 75%;
padding:12px,20px;
display:inline-block;
border: 1px solid #ccc;
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
<p class = "bold">Search the employee here by selecting the categories:</p>
<br>
<form:form action ="/MyJavaChallenge2/searchBy" method = "POST">
<table><tr>
<td>
By State<select name= "statetype" >
<option value = "">All</option>
<option value = "CA">CA</option>
<option value = "AP">AP</option>
<option value = "VA">VA</option>
</select>
<!-- <input type = "radio" name = "ordertype" value = "ByState">By State<br> --></td></tr>
<tr><td>By Country<select name= "countrytype" >
<option value = "">All</option>
<option value = "India">India</option>
<option value = "USA">USA</option>
</select>
<!-- <input type = "radio" name = "ordertype" value = "ByCountry">Group By<br> --></td>
</tr>
<tr><td>By Profession<select name= "Proftype" >
<option value = "">All</option>
<option value = "teacher">Teacher</option>
<option value = "doctor">Doctor</option>
<option value = "engineer">Engineer</option>
</select>
<!-- <input type = "radio" name = "ordertype" value = "ByProfession">By Profession<br> --></td>
</tr>
</table>
<input type="submit" value = "SearchUser">
</form:form>
</body>
</html>