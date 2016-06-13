<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit Details</title>
<script type="text/javascript">

	/* function validateEmail(email) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(email);
	}
 */
	function isValid() {
		valid = true;
		msg = "";
		var pname = document.forms["myForm"]["positionName"].value;
		var cname = document.forms["myForm"]["companyName"].value;
		var url = document.forms["myForm"]["sourceUrl"].value;
		var path = document.forms["myForm"]["path"].value
	/* 	var checked = document.forms["myForm"]["emailcheck"].value;
		var email = document.forms["myForm"]["emailId"].value;
	 	alert(email);*/
		if (pname == null | pname == "") {
			valid = false;
			document.forms["myForm"]["positionName"].focus();
			document.forms["myForm"]["positionName"].style.border = "solid 1.5px red";
		}
		if (cname == null | cname == "") {
			valid = false;
			document.forms["myForm"]["companyName"].focus();
			document.forms["myForm"]["companyName"].style.border = "solid 1.5px red";
		}
		if (url == null | url == "") {
			valid = false;
			document.forms["myForm"]["sourceUrl"].focus();
			document.forms["myForm"]["sourceUrl"].style.border = "solid 1.5px red";
		}
		if (path == null | path == "") {
			valid = false;
			document.forms["myForm"]["path"].focus();
			document.forms["myForm"]["path"].style.border = "solid 1.5px red";
		}

	/* 	if(email){
		valid = validateEmail(email);
		msg = "/Email id is invalid";
		} */

	if (!valid) {
		alert("Missing One or more Required Fields" + msg);
		}
		return valid;
	}

	function onclicking() {
		$(this).css("border", "solid 1.5px green");
	}

	$(function() {
		$("#position").keypress(onclicking);
	});
	$(function() {
		$("#company").keypress(onclicking);
	});

	$(function() {
		$("#source").keypress(onclicking);
	});
	
	$(function() {
		$("#path").keypress(onclicking);
	});


	/* $(function() {
		$("#emailAddress").click(onclicking);
	})
 */
	$(function() {
		$("#emailcheck").click(function() {
			$("#emailfield").toggle();
		});

	});
</script>
<style type="text/css">
input.field {
	margin-left: 50px;
}

#A {
	height: 180px;
	width: 130px;
	float: left;
	margin: 5px, 5px, 0px, 5px;
	padding: 2px, 2px, 2px ,.2px;
}

#B {
	padding-left: 2px;
	height: 150px;
	margin-left: 70px;
}

input.field {
	/*  border: 1px solid navy;*/
	width: auto;
}

.req {
	color: red;
}
</style>
</head>
<body>
	<h3>Welcome to Easy Cover Letter Portal</h3>
	<h4>Enter the Job Details of your Application</h4>
	<p>Please enter your local system directory path along with the file name.eg(D://newletter.pdf)</p>
	<div id="A">
		Position Name:<span class="req">*</span><br> <br> Company
		Name:<span class="req">*</span><br> <br> Source Url:<span
			class="req">*</span><br> <br> HR Name:
		<br><br>
		Enter Path:<span class="req">*</span><br>
	</div>
		 	
	<form action="/JobSubmission/onsubmit" onsubmit="return isValid()"
		name="myForm" method="POST" class="B">
		<input class="field" type="text" name="positionName" id="position"><br>
		<br> <input class="field" type="text" name="companyName"
			id="company"><br> <br> <input class="field"
			type="text" name="sourceUrl" id="source"><br> <br>
		<input class="field" type="text" name="hrName"> <br> <br>
		<input class="field" type="text" name="path" id = "path"><br><br>
	
		<input type="submit" name="submit" value="Submit">
	</form>
</body>
</html>