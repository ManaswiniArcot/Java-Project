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
<h3>U are here to add new Employees</h3>
<br><p>
${empMsg}
</p><br>
<table>
<tr>
<td>the name is: </td><td>${employee.nameTitle} ${employee.employeeName}</td>
</tr>
<tr>
<td>
the domain is:  </td>
<td>
${employee.domain}</td></tr>
<tr><td>DOB</td><td>
${employee.DOB}</td>
<tr><td>
Mobile</td>
<td>
${employee.mobile}</td></tr>
<tr>
<td>Skills</td>
<td>
${employee.skills}</td>
</tr>
<tr>
<td>Department</td>
<td>
Depart id :${employee.department.deptId}
Depart Name :${employee.department.deptName}
Depart Code :${employee.department.deptCode}</td>
</tr></table>
<br>
<table>
<tr><td>
<input name="action" type="button" value="Back" onclick="history.go(-1);" />
</td>
<td>
<form:form action = "/MyJavaChallenge/addEmployee" method="POST">
<input type ="submit" value = "Add Another">
</form:form>
</td>
</tr>
</table>
</body>
</html>