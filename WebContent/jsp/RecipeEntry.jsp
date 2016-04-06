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
		<form id="submitForm" name="submitForm" method="POST" action="/TraineeChefProject/RecipeEntry" enctype="multipart/form-data" onsubmit="return validateForm()" >
			<h3>Enter your Recipe</h3>
			<table>
		    	<tr>
			        <td>Your Name</td>
			        <td>
			        	<input type="text" name="studentName" required="" value="Will">
			        </td>
			    </tr>
			     <tr>
			        <td>Your Surname</td>
			        <td>
						<input type="text" name="studentSurname" required="" value="Hogan">
			        </td>
			    </tr>  
			    
			    <tr><td><hr></td></tr>
			    
			     <tr>
			        <td>Food Type </td>
			        <td>
			        	<select id="foodType" name="foodType">
			        		<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodTypeDAO.foodTypelist()}" var="items">
								<option>${items.id}</option> <!-- ${items.type} -->
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
			     <tr>
			        <td>Menu Origin</td>
			        <td>
			        	<select id="foodOrigin" name="foodOrigin">
				        	<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodOriginDAO.foodOriginlist()}" var="items">
								<option>${items.foodOriginid}</option> <!-- ${items.origin} -->
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
		       <tr>
			   		<td>Recipe Name</td>
			   		<td>
			   			<input type="text" name="recipeName" required="" value="Spaghetti Bolognaise">
			   		</td> 
			    </tr>
			    
			    <tr>
			        <td>Description </td>
			        <td>
						<textarea class="description" type="text" name="description" required="">This is a Wonderful description....</textarea>
			        </td>
			    </tr>   
			    <tr>
			    	<td>Prep/Cooking Time[Hours|Mins]</td>
			    	<td>
			    		<select id="prepTime" name="prepTime">
			    			<option  selected="selected">-Select-</option>
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
			    		<button id="addIngredients" name="addIngredients" type="button" required="">Add Ingredients</button>
    			    </a>
			    	</td>
			    </tr>   
			    <tr>
			    	<td>
			    	<!-- style="display:none" --> 
			    		<div 
			    			 onsubmit="getLocalStorage()" 
			    			 onmouseover="getLocalStorage()" 
			    			 id="ingredientsReturned" 
			    			 name="ingredientsReturned"></div>
			    	</td>
			    </tr>
			    <tr>
			    	<td>Directions</td>
			    	<td>
			    		<textarea class="description" name="directions" required="">These are Wonderful cooking directions....</textarea>
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