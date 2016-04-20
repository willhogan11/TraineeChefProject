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
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
					<select id="item" name="item">
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
					<select id="measure" name="measure">
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
					<select id="quantity" name="quantity">
						<option selected="selected">-Select-</option>
						<c:forEach var="i" begin="1" end="500">
							<option>${i}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<button id="add" name="add" onClick="concatIngred()">Add</button>
				</td>
			</tr>
			<tr>
				<td id="tableDetailsID" name="tableDetailsID">
					<p id="concatResult" name="concatResult"></p>
				</td>
			</tr>
			<tr>
				<td>
					<button id="finishedIngredients" name="finishedIngredients" onclick="closePopUp()">Finished</button>
				</td>
			</tr>
		</table>
		
		<hr>
		
		<form name="addToDatabase" method="POST" action="/TraineeChefProject/AddIngredients">
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
		
		<!-- Display Result from Server -->
		<p>${ingredientName}</p>
		
	</div>
</body>
</html>