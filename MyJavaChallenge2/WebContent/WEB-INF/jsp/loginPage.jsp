<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
body{
background-color: #f2f2f2}
p.bold{
font-weight: bold;
font-style: inherit; }
input[type="text"]{
padding:12px,20px;
display:inline-block;
border: 1px solid #ccc;
}

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<script>
$(function(){
	//alert("hello ");
	$("#myForm").submit(function( event ) {
		  var user = $("#userId").val();
		  var pass = $("#passwordId").val();
		  var jsonStr = "{userId:" + user + ", password:" + pass + "}";
		 // alert( "Handler for .submit() called. user: " + user + " , pass : " + pass + ", json : " + jsonStr );
		  event.preventDefault();
		  $.post( "/MyJavaChallenge2/login", JSON.stringify($("#myForm").serializeArray()), function( data ) {
			 alert(data);
			  $( "#result" ).html( data );
			  
			});
		});	
});

 </script>
</head>
<body>
<p class = "bold">Welcome to the Login Page. Please enter your login details.</p>

<form:form id= "myForm" action="/MyJavaChallenge2/login" method="POST">
<div>
<ul> 
<li> 
      <label for="usermail">Email</label>      
      <input type="text" name="usermail" id="userId" placeholder="yourname@email.com" required></li>
        <li><label for="password">Password</label>
       <input type="password" name="password" id="passwordId" placeholder = "enter your password" required></li>
  
 </ul>
  <input type="submit" value="Mainlogin" id = show>
 </div>
 </form:form >
<br>
 <div id="result"></div>
<p class ="bold">To access the other end points click on below button</p>
 <form:form action="/MyJavaChallenge2/welcome">
 <input type="submit" value="Now Click here" id= "hide" >
 </form:form>
</body>
</html>
