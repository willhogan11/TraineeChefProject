<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>

<body>
	<div id="menuSessionName">Logged in as </div>
	
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

			<!-- Need to Send the CHEF_ID from the database into a hidden field in this form -->
			<form id="displayChefRecipes" name="displayChefRecipes" method="GET" action="/TraineeChefProject/DisplayChefRecipes">
				<input name="test" type="submit" value="View Existing Recipes">
				<input type="hidden" name="chef_Id" value="1">
			</form>

			<a href="login.jsp">
				<button>Return to Login screen to logout</button>
			</a>
		</div>
	</div>
</body>
</html>