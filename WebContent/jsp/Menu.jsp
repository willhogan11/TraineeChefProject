<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/login.js"></script>
</head>

<body>

<fb:login-button name="status" data-max-rows="1" data-size="xlarge" data-show-faces="false" 
		autologoutlink="true" scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>

	<h2 id="name">Welcome ${name}</h2>
	
	<div id="menuControl"
		 style="border: 2px solid black; 
				text-align: center;
				padding: 20px; 
				width: 800px;
				margin: 0 auto">
		<h1>Trainee Chef Recipe Menu</h1>
		<div>
			<a href="RecipeEntry.jsp">
				<button>Add a Recipe</button>
			</a>
			<button>View Existing Recipes</button>
		</div>
	</div>
</body>
</html>