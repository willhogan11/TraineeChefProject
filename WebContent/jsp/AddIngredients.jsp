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
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addIngredients.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>

<body>
	<div class="btn-group-vertical" id="ingredientsForm">
		<h1>Add Ingredients</h1>
		<hr>
		<table>
			<tr>
				<td><h3>Add Ingredients from Database:</h3></td>
			</tr>
			<tr>
				<td>Item:	<span class="glyphicon glyphicon-arrow-right"></span></td>
				<td>
					<select data-toggle="dropdown" 
							data-toggle="tooltip" title="Select Food items for your Recipe..."
		        	        class="btn btn-default btn-md dropdown-toggle"  
		        	        id="item" 
		        	        name="item">
						<option selected="selected">-Select-</option>
						<c:forEach items="${IngredientDAO.ingredientList()}" var="item">
							<option>${item.name}</option>	
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Measurement Type:	<span class="glyphicon glyphicon-arrow-right"></span></td>
				<td>
					<select data-toggle="dropdown" 
							data-toggle="tooltip" title="Choose your measurement type..."
			        	    class="btn btn-default btn-md dropdown-toggle" 
		        	        id="measure" 
		        	        name="measure">
						<option selected="selected">-Select-</option>
						<c:forEach items="${MeasurementDAO.measureType()}" var="item">
							<option>${item.measureName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantity:	<span class="glyphicon glyphicon-arrow-right"></span></td>
				<td>
					<select data-toggle="dropdown" 
			        	    class="btn btn-default btn-md dropdown-toggle"  
			        	    data-toggle="tooltip" title="Add a Quantity..."
			        	    id="quantity" 
			        	    name="quantity">
						<option selected="selected">-Select-</option>
						<c:forEach var="i" begin="1" end="500">
							<option>${i}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Add Ingredient:		<span class="glyphicon glyphicon-arrow-right"></span></td>
				<td>
					<button class="btn btn-sm btn-info" 
							data-toggle="tooltip" title="Add an Ingredient"
							id="add" 
							name="add" 
							onClick="concatIngred()">Add</button>
				</td>
			</tr>
			<tr>
				<td style="text-align: justify; font-style: italic;" id="tableDetailsID">
					<p id="concatResult"></p>
				</td>
			</tr>
			<tr>
				<td>
					<button class="btn btn-md btn-primary" 
							data-toggle="tooltip" title="Click here to return to the main Recipe entry page"
							id="finishedIngredients" 
							name="finishedIngredients" 
							onclick="closePopUp()">Finished <span class="glyphicon glyphicon-ok"></span></button>
				</td>
			</tr>
		</table>
		
		<hr>
		
		<form name="addToDatabase" method="POST" action="/TraineeChefProject/AddIngredients">
			<h3>Ingredient not in Database? <br> No problem, Add below...</h3>
			<table>
				<tr>
					<td>Ingredient Name: </td>
					<td>
						<input class="form-control" type="text" 
							   name="ingredientName" required
							   data-toggle="tooltip" title="Enter an Item to the database that's not in the above list...">
					</td>
					<td></td>
					<td>
						<input data-toggle="tooltip" title="Add an Item to the Database" 
							   class="form-control" type="submit" value="+">
					</td>
				</tr>
			</table>
		</form>
		
		<!-- Display Result from Server -->
		<p>${ingredientName}</p>
	</div>
</body>
</html>