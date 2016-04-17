<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Chef Recipe Page</title>
	
	<style>
		html *{
			font-family: Century Gothic;
		}
		
		h1 {
			text-align: center;
			color: #4d94ff;
		}
		
		table {
    		border-collapse: collapse;
    		width: 100%;
		}	
		th, td {
	    	border: 1px solid black;
	    	padding: 10px;
	    	text-align: left;
		}
		th {
			font-size: 20px;
			color: #4d94ff;
		}
		
		td {
			font-size: 15px;
		}
		
		tbody tr:nth-of-type(odd) {
		  background-color: #f2f2f2;
		}
	</style>

</head>
<body>
	<h1>Display Recipes Page</h1>

	<table>
		<thead>
			<tr>
				<th>Recipe Name</th>
				<th>Food Origin</th>
				<th>Food Type</th>
				<th>Description</th>
				<th>Prep Time (Hours/mins)</th>
				<th>Ingredients</th>
				<th>Directions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultSet}" var="row">
				<tr>
					<td>${row.recipeName}</td>
					<td>${row.foodOrigin}</td>
					<td>${row.foodType}</td>
					<td>${row.description}</td>
					<td>${row.prepTime}</td>
					<td>${row.ingredients}</td>
					<td>${row.directions}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>

	<a href="jsp/Menu.jsp">
		<button>Return to Menu</button>
	</a>

</body>
</html>