<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ie.gmit.sw.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.formDiv{
		border: solid black 2px;
		margin: auto;
		width: 320px;
		padding: 20px;
		font-family: arial;
	}
</style>
<!-- <script src="WebContent/script.js"></script> -->
<script>
	// Function to Check if Input is Valid
	function validateFunc(){
		var x;
		x = document.getElementById("age").value;
		if( isNaN(x)){
			window.alert("Input is Not Valid");
			document.getElementById("age").value = "";
			return false;
		}
	} // End of validateFunc()
	
	function validateForm() {
	    var x = document.forms["submitForm"]["name"].value;
	    var y = document.forms["submitForm"]["surname"].value;
	    var z = document.forms["submitForm"]["age"].value;
	    
	    if ( (x == null || x == "") || (y == null || y == "") (z == null || z == "") ){
	        alert("Form Must be Filled out Correctly");
	        return false;
	    }
	}
</script>
<title>Insert Data into Database</title>
</head>
<body>
	<div class="formDiv">
		<form name="submitForm" method="POST" action="UserEntryServlet" enctype="multipart/form-data" onsubmit="return validateForm()" >
			<table>
			    <tr>
			        <td>Name: </td>
			        <td><input type="text" name="name" required=""></td>
			    </tr>
			     <tr>
			        <td>Surname: </td>
			        <td><input type="text" name="surname" required=""></td>
			    </tr>  
			    <tr>
			        <td>Age: </td>
			        <td><input id="age" type="text" name="age" required=""></td>
			    </tr>      
			    <tr>
			    	<td>Image Upload: </td>
			    	<td><input type="file" name="image"></td>
			    </tr>
			    <tr>
			        <td></td>
			        <td><input type="submit" value="Submit"></td>
			    </tr>
			</table>
		</form>
	</div>
</body>
</html>