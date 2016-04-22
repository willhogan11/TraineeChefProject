<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/displayRecipes.css" />
	<title>Chef Recipe Page</title>
</head>
<body>
	<h1>Your Recipe List</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Recipe Name</th>
				<th>Food Origin</th>
				<th>Food Type</th>
				<th>Description</th>
				<th>Preparation Time</th>
				<th>Ingredients</th>
				<th>Directions</th>
				<th>Delete Recipe</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultSet}" var="row">
				<tr>
					<td id="recipeId">${row.recipeId}</td>
					<td>${row.recipeName}</td>
					<td>${row.foodOrigin}</td>
					<td>${row.foodType}</td>
					<td>${row.description}</td>
					<td>${row.prepTimeHours}h ${row.prepTimeMins}m</td>
					<td>${row.ingredients}</td>
					<td>${row.directions}</td>
					<td><button id="deleteRecipe" name="deleteRecipe" value="Delete">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	
	<div id="returnButton">
		<a href="jsp/Menu.jsp">
			<button class="btn btn-large btn-primary"><span class="glyphicon glyphicon-hand-left"></span>
			  Return to Menu</button>
		</a>
	</div>

</body>
</html>