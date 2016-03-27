<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="beans.*" %>
<%@ page import="dataAccessObjects.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Ingredients</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>

<body>
	<div id="ingredientsForm">
		<h1>Add Ingredients</h1>
			<select>
				<option selected="selected">-Select-</option>
				<c:forEach items="${IngredientDAO.ingredientList()}" var="items">
					<option>${items.name}</option>	
				</c:forEach>
			</select>
			First Name: <input type="text" id="myText" value="">
			<button onclick="addIngredient()">+</button>
			
			<!-- <button id="addButton" name="addButton">+</button> -->

			<p id="demo"></p>
	</div>
</body>
</html>