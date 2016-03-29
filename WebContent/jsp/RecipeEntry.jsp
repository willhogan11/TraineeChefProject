<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="beans.*" %>
<%@ page import="dataAccessObjects.*" %>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recipe Entry</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>
<body>
	<div class="recipeEntryForm">
		<form id="submitForm" name="submitForm" method="POST" action="/TraineeChefProject/jsp/RecipeEntry" enctype="multipart/form-data" onsubmit="return validateForm()" >
			<h3>Enter your Recipe</h3>
			<table>
		    	<tr>
			        <td>Your Name</td>
			        <td>
			        	<input type="text" name="name" required="">
			        </td>
			    </tr>
			     <tr>
			        <td>Your Surname</td>
			        <td>
						<input type="text" name="surname" required="">
			        </td>
			    </tr>  
			    
			     <tr>
			        <td>Food Type </td>
			        <td>
			        	<select id="foodType" name="foodType">
			        		<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodTypeDAO.foodTypelist()}" var="items">
								<option>${items.type}</option>
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
			     <tr>
			        <td>Menu Origin</td>
			        <td>
			        	<select id="menuOrigin" name="menuOrigin">
				        	<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodOriginDAO.foodOriginlist()}" var="items">
								<option>${items.origin}</option>
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
			    <tr>
			        <td>Description </td>
			        <td>
						<textarea class="description" type="text" name="description" required=""></textarea>
			        </td>
			    </tr>   
			    <tr>
			    	<td>Prep/Cooking Time[Hours|Mins]</td>
			    	<td>
			    		<select>
			    			<option selected="selected">-Select-</option>
			        		<c:forEach items="${PrepTimeDAO.prepTime()}" var="items">
								<option>${items}</option>
							</c:forEach>
			    		</select>
		    		</td>
			    </tr> 
			    <tr>
			    	<td>Ingredients</td>
			    	<td>
			    	<a href="/TraineeChefProject/AddIngredients" onClick="return popup(this, 'notes')">
			    		<button id="addIngredients" type="button" name="addIngredients" required="">Add Ingredients</button>
    			    </a>
			    	</td>
			    </tr>   
			    <tr>
			    	<td>Directions</td>
			    	<td>
			    		<textarea class="description" name="directions" required=""></textarea>
		    		</td>
			    </tr>     
			    <tr>
			    	<td>Image</td>
			    	<td>
			    		<input type="file" name="image">
		    		</td>
			    </tr>
			    <tr>
			        <td></td>
			        <td>
			        	<input type="submit" value="Submit">
		        	</td>
			    </tr>
			</table>
		</form>
	</div>
</body>
</html>