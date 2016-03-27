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
		<hr>
		<table>
			<tr>
				<td><h3>Add Ingredient from Database:</h3></td>
			</tr>
			<tr>
				<td>Item:</td>
				<td>
					<select>
						<option selected="selected">-Select-</option>
						<c:forEach items="${IngredientDAO.ingredientList()}" var="item">
							<option>${item.name}</option>	
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Measurement Type:</td>
				<td>
					<select>
						<option selected="selected">-Select-</option>
						<c:forEach items="${MeasurementDAO.measureType()}" var="item">
							<option>${item.measureName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td>
					<select>
						<option selected="selected">-Select-</option>
						<c:forEach var="i" begin="1" end="100">
							<option>${i}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			
		<!-- 	First Name: <input type="text" id="myText" value="">
			<button onclick="addIngredient()">+</button>
			
			<button id="addButton" name="addButton">+</button>

			<p id="demo"></p> -->
		</table>
	</div>
</body>
</html>