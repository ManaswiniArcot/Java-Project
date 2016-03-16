<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${headerMsg}</h1>
${empMsg}
<!-- 
The below is the main important step for displaying the binding result errors though the error msg is not user friendly.
this below form errors tag displays them.the path should match the model attribute value in the controller class for this action 
called below. 
 --><form:errors path = "employee.*"/>
<form:form action = "/MyJavaChallenge/addAnother" method="POST">
<table>
<tr>
<td>
Enter the Name</td><td><select name= "nameTitle" >
<option value = "">Title</option>
<option value = "Ms">Miss</option>
<option value = "Mr">Mr</option>
<option value = "Mrs">Mrs</option>
</select><input type="text" name = "employeeName"></td></tr>
<tr><td>Enter Domain</td> <td><input type ="text" name= "domain"></td></tr>
<tr><td>Enter DoB</td> <td><input type ="text" name= "DOB"></td></tr>
<tr><td>Enter Mobile</td> <td><input type ="text" name= "mobile"></td></tr>
<tr><td>Enter Skills</td> 
<td><select name= "skills" multiple="multiple">
<option value = "Java">Java</option>
<option value = "SQL">SQL</option>
<option value = "Spring">Spring</option></select>
</td></tr>
<tr><td>Employee Department:</td>
<td>Department Id :<input type="text" name = "department.deptId"></td>
<td>Department Name :<input type="text" name = "department.deptName"></td>
<td>Department Code :<input type="text" name = "department.deptCode"></td>
</tr>
<tr><td colspan="2"><input type="submit" value= "Click Enter"></td></tr>
</table>
</form:form>

<%-- This is example of @ModelAttribute  
<form:form action = "/MyJavaChallenge/addAnother" method="POST">
<p>Enter the Name<input type="text" name = "employeeName">
<br><br>
Enter Domain <input type ="text" name= "domain">
<br>

<input type="submit" value= "ClickMe">
</p>
</form:form>
 --%>
</body>
</html>