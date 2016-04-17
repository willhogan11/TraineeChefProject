<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Chef Recipe Page</title>
	
	<style>
		th, td {
	    border: 1px solid black;
	    padding: 5px;
	}
	</style>

</head>
<body>
	<h1>Display Recipes Page</h1>

	<table>
		<c:forEach items="${resultSet}" var="row">
			<tr>
				<td>${row.recipeName}</td>
				<td>${row.description}</td>
				<td>${row.prepTime}</td>
				<td>${row.ingredients}</td>
				<td>${row.directions}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<br>
	
	<a href="jsp/Menu.jsp">
		<button>Return to Menu</button>
	</a>

</body>
</html>