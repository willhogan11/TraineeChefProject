<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="beans.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipe Entry</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>
<body>
	<div class="recipeEntryForm">
		<form name="submitForm" method="POST" action="/TraineeChefProject/jsp/RecipeEntry" enctype="multipart/form-data" onsubmit="return validateForm()" >
			<h3>Enter your Menu</h3>
			<table>
			    <tr>
			        <td>Your Name: </td>
			        <td>
			        	<input type="text" name="name" required="">
			        </td>
			    </tr>
			     <tr>
			        <td>Your Surname: </td>
			        <td>
						<input type="text" name="surname" required="">
			        </td>
			    </tr>  
			    
			     <tr>
			        <td>Food Type </td>
			        <td>
			        	<select id="foodType" name="foodType">
			        		<option>Starter</option>
			        		<option>Main Course</option>
			        		<option>Dessert</option>
			        		<option>Salad</option>
			        	</select>
			        </td>
			    </tr>   
			    
			     <tr>
			        <td>Menu Origin</td>
			        <td>
			        	<select id="menuOrigin" name="menuOrigin">
			        		<c:forEach items="${foodOriginResult}" var="items">
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
			    			<option>15</option>
			    			<option>30</option>
			    			<option>45</option>
			    			<option>1.00</option>
			    			<option>1.15</option>
			    			<option>1.30</option>
			    			<option>1.45</option>
			    			<option>2.00</option>
			    			<option>2.15</option>
			    			<option>2.30</option>
			    			<option>2.45</option>
			    			<option>3.00</option>
			    			<option>3.15</option>
			    			<option>3.30</option>
		    				<option>3.45</option>
		    				<option>4.00</option>
		    				<option>4.15</option>
		    				<option>4.30</option>
		    				<option>4.45</option>
		    				<option>5.00</option>
		    				<option>5.15</option>
		    				<option>5.30</option>
		    				<option>5.45</option>
			    		</select>
		    		</td>
			    </tr> 
			    <tr>
			    	<td>Ingredients</td>
			    	<td>
				    	<a href="html/AddIngredients.html" onClick="return popup(this, 'notes')">
				    		<button id="addIngredients" onClick="testPopUp()" 
				    			   type="button" name="addIngredients" required="">Add Ingredients</button>
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