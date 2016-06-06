<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginSuccess</title>
<style type="text/css">
body { height: 100%; padding: 0; margin: 0;
background-color: #f2f2f1;
 }
div { width: 50%; height: 50%; float: left;
margin: 10px
 }
/* #div1 { background: #DDD; }
#div2 { background: #AAA; }
#div3 { background: #DDD; }
#div4 { background: #AAA; } */ 

input[type = "text"]{
width: 70%;
padding:12px,20px;
display:inline-block;
border: 1px solid #ccc;
}

</style>
</head>
<body>
<!-- <a href = "/MyJavaChallenge/addEmployee">Click here</a><p> to enter the employee details</p> -->
<h2></h2>

<p>Below are the different options available</p>
<div id="div1">
<p>Click on the below link to search the user<br>
<a href = "/MyJavaChallenge2/searchUser">Search User</a></p>
</div>
<div id="div2">
<form:form action = "/MyJavaChallenge2/files" method = "POST">
<br>
To get the list of all the files in a given path.<br>
Enter the path and click on Go
<br> <input type = "text" placeholder ="Enter the path" name = "path" id = path>
<input type="submit" value = "Go">
</form:form>
</div>
<div id="div3">
<p>Click here to know the status of the dependent tools used by the application.<br>
<a href = "/MyJavaChallenge2/status">Click here</a>to check the status</p>
</div>
<div id="div4">
<p><a href="/MyJavaChallenge2/">Click here</a> for the login Page</p>
</div>

<br>

</body>
</html>