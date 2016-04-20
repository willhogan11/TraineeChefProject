<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/login.js"></script>
	<title>Login Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

<br><br><br>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->
<div class="login">

	<form name="fbLogin" method="POST" action="DisplayRecipes">
	
		<fb:login-button data-max-rows="1" data-size="xlarge" data-show-faces="false" 
		autologoutlink="true" scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
		
		<p class="statusText" id="status" name="status" value=""></p>
		
		<div class="buttonGroup">
			<a href="Menu.jsp">
				<button id="hiddenButton" type="button" class="btn btn-large btn-success">
				 Go To Menu <span class="glyphicon glyphicon-hand-right"></span></button>
			</a>
		</div>
		
	    <img class="image" src="../images/gmitLogo.jpg" style="float:">
    </form>
</div>

</body>
</html>