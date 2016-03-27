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
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" /> --%>
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
			<tr>
				<td>
					<button id="add">Add</button>
				</td>
			</tr>
		</table>
		<hr>
		
		<form id="addToDatabase" name="addToDatabase" method="POST" action="/TraineeChefProject/jsp/AddIngredients">
			<h3>Ingredient not in Database? <br> No problem, Add below...</h3>
			<table>
				<tr>
					<td>Ingredient Name:</td>
					<td>
						<input type="text" name="ingredientName" required="">
					</td>
					<td></td>
					<td>
						<input type="submit" value="+">
					</td>
				</tr>
			</table>
		</form>
		
		
			
		<!-- 	First Name: <input type="text" id="myText" value="">
			<button onclick="addIngredient()">+</button>
			
			<button id="addButton" name="addButton">+</button>

			<p id="demo"></p> -->
		
	</div>
</body>
</html>