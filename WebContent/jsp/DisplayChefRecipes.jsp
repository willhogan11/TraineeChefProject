<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Chef Recipe Page</title>
	
	<style>
		table, th, td {
	    border: 1px solid black;
	}
	</style>

</head>
<body>
	<h1>Display Recipes Page</h1>
	
	<table>
		<thead>
			<tr>
				<th>Recipe Name:</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${recipeName}</td>
			</tr>
		</tbody>
		<thead>
			<tr>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${recipeDescription}</td>
			</tr>
		</tbody>
	</table>
	
	<br>
	
	<a href="jsp/Menu.jsp">
		<button>Return to Menu</button>
	</a>

</body>
</html>