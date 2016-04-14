<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/login.js"></script>
	<title>Login Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body onload="enableNavButton();" onchange="enableNavButton();" onformchange="enableNavButton();">

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->
<div class="login">

	<form onformchange="enableNavButton();" onchange="enableNavButton();" name="fbLogin" method="POST" action="DisplayRecipes">
	
		<fb:login-button onformchange="enableNavButton();" onchange="enableNavButton();" data-max-rows="1" data-size="xlarge" data-show-faces="false" 
		autologoutlink="true" scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
		
		<p class="statusText" id="status" value=""></p>
		
		<button id="hiddenButton" type="button">Go To Menu -></button>
	    <img class="image" src="../images/gmitLogo.jpg" style="float:">
    </form>
</div>

</body>
</html>