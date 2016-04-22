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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/script.js"></script>
</head>

<body onfocus="getLocalStorage();" onload="clearLocalStorage(); getSessionName();">
		
	<div class="recipeEntryForm">
		<form role="form" id="submitForm" name="submitForm" method="POST" enctype="multipart/form-data" 
		      action="/TraineeChefProject/RecipeEntry" onsubmit="return validateForm()" >
			
			<h3>Enter your Recipe</h3>
			<hr>
			<table>
		    	<tr>
			        <td>Your Name</td>
			        <td id="sessionName">
			        	<input type="text" name="studentName">
			        </td>
			    </tr>
			     <tr>
			        <td>Your Surname</td>
			        <td id="sessionSurname">
						<input type="text" name="studentSurname">
			        </td>
			    </tr>  
			    
			     <tr>
			        <td>Food Type</td>
			        <td>
			        	<select data-toggle="tooltip" 
			        	        title="Starter, Main Etc.." 
			        	        data-toggle="dropdown" 
			        	        class="btn btn-default btn-md dropdown-toggle" 
			        	        id="foodType" 
			        	        name="foodType">
			        		<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodTypeDAO.foodTypelist()}" var="items">
								<option>${items.type} - ${items.id}</option>
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
			     <tr>
			        <td>Menu Origin</td>
			        <td>
			        	<select data-toggle="tooltip" 
			        	        title="Country where recipe originated" 
			        	        data-toggle="dropdown" 
			        	        class="btn btn-default btn-md dropdown-toggle" 
			        	        id="foodOrigin" 
			        	        name="foodOrigin">
				        	<option selected="selected">-Select-</option>
			        		<c:forEach items="${FoodOriginDAO.foodOriginlist()}" var="items">
								<option>${items.origin} - ${items.foodOriginid}</option>
							</c:forEach>
			        	</select>
			        </td>
			    </tr>   
			    
		       <tr>
			   		<td>Recipe Name</td>
			   		<td>
			   			<input data-toggle="tooltip" 
			   			       title="Insert your Recipe name here" 
			   			       class="form-control" 
			   			       placeholder="Recipe Name" 
			   			       type="text" 
			   			       name="recipeName" 
			   			       required>
			   		</td> 
			    </tr>
			    
			    <tr>
			        <td>Description</td>
			        <td>
						<textarea placeholder="Enter your Recipe Description here..." 
								  class="form-control"
								  data-toggle="tooltip" title="Describe your Recipe"
								  name="description" 
								  required></textarea>
			        </td>
			    </tr>   
			    
			    <tr>
			    	<td>Prep Time</td>
			    	<td>
			    		<select data-toggle="tooltip" title="Cooking time in Hours" 
			    		        data-toggle="dropdown" 
			    		        class="btn btn-default btn-md dropdown-toggle" 
			    		        id="prepTimeHours" 
			    		        name="prepTimeHours">
			    		       <!--  id="prepTime" 
			    		        name="prepTime"> -->
			    			<option selected="selected">-Select-</option>
			        		<c:forEach var="i" begin="1" end="60">
								<option>${i}</option>
							</c:forEach>
			    		</select>
			    		h
			    		<select data-toggle="tooltip" title="Cooking time in Minutes" 
			    				data-toggle="dropdown" 
			    		        class="btn btn-default btn-md dropdown-toggle" 
			    		        id="prepTimeMins" 
			    		        name="prepTimeMins">
			    			<option selected="selected">-Select-</option>
			    			<c:forEach var="i" begin="0" end="10">
			    				<option>${i}</option>
			    			</c:forEach>
			    		</select>
			    		m
		    		</td>
			    </tr>
			    
			    <tr>
			    	<td>Ingredients</td>
			    	<td>
			    	<a href="/TraineeChefProject/AddIngredients" onClick="return popup(this, 'notes')">
			    		<button class="btn btn-sm btn-warning" id="addIngredients" 
			    				data-toggle="tooltip" title="Click here to add your Ingredients"
			    		        name="addIngredients" type="button">
			    					Add Ingredients
			    		 	<span class="glyphicon glyphicon-plus"></span>
			    		 </button>
    			    </a>
			    	</td>
			    </tr>   
			    <tr>
			    	<td>Entered Ingredients</td>
			    	<td>
		    			<textarea readonly 
		    					  data-toggle="tooltip" title="The Ingredients that you entered"
		    					  class="form-control"
		    					  placeholder="Ingredients will be loaded here..."
		    					  id="ingredientsReturned" 
		    					  name="ingredientsReturned"
		    					  required></textarea>
			    	</td>
			    </tr>
			    <tr>
			    	<td>Directions</td>
			    	<td>
			    		<textarea placeholder="Enter the directions here...." 
			    		          class="form-control" 
			    		          name="directions" 
			    		          data-toggle="tooltip" title="Detail here how to Cook / make your recipe"
			    		          required></textarea>
		    		</td>
			    </tr>     
			    <tr>
			    	<td>Image</td>
			    	<td>
			    		<input data-toggle="tooltip" title="Upload an Image of your recipe" type="file" name="image">
			    		<p style="color: blue; font-weight: bold;">File Size Limit 10mb</p>
		    		</td>
			    </tr>
			    <tr>
			        <td>
		        		<div>
							<a href="../jsp/Menu.jsp">
								<button class="btn btn-large btn-default">
									<span class="glyphicon glyphicon-hand-left"></span> 
										Main Menu
								</button>
							</a>
						</div>
		        	</td>
			        <td>
			        	<input data-toggle="tooltip" title="Enter your recipe to the database" 
			        	       class="btn btn-md btn-primary" type="submit" value="Submit">
		        	</td>
			    </tr>
			</table>
		</form>
	</div>
</body>
</html>