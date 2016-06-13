
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

	/* $(function() {
		$("#emailAddress").click(onclicking);
	})
 */
	$(function() {
		$("#emailcheck").click(function() {
			$("#emailfield").toggle();
		});

	});