<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Menu.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>

<body>
	<!-- <div id="menuSessionName">Logged in as </div> -->
	
	<br><br><br>
	
	<div id="menuControl">
		<h2>Trainee Chef Recipe Menu</h2>
		
		<div id="buttonDiv">
			<a class="buttonGroup" href="RecipeEntry.jsp">
				<button class="btn btn-large btn-block">Add a Recipe</button>
			</a>

			<!-- Need to Send the CHEF_ID from the database into a hidden field in this form -->
			<form class="buttonGroup" id="displayChefRecipes" name="displayChefRecipes" method="GET" action="/TraineeChefProject/DisplayChefRecipes">
				<input class="btn btn-large btn-block btn-primary" name="test" type="submit" value="View Existing Recipes">
				<input type="hidden" name="chef_Id" value="1">
			</form>

			<a class="buttonGroup" href="login.jsp">
				<button class="btn btn-large btn-block">Return to Login screen to logout</button>
			</a>
		</div>
	</div>
</body>
</html>