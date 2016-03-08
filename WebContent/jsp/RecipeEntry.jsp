<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Recipe Entry</title>
</head>
<body>
	
	
	<div class="recipeEntryForm">
		<form name="submitForm" method="POST" action="RecipeEntry" enctype="multipart/form-data" onsubmit="return validateForm()" >
			<h3>Enter your Menu</h3>
			<table>
				<tr>
					<td><input type="hidden" id=hiddenField name="testdata" value=""></td>
				</tr>
			</table>
		
			<table>
			    <tr>
			        <td>Name: </td>
			        <td><input type="text" name="name" required=""></td>
			    </tr>
			     <tr>
			        <td>Surname: </td>
			        <td><input type="text" name="surname" required=""></td>
			    </tr>  
			    <tr>
			        <td>Food Origin </td>
			        <td>
			        	<select id="foodOrigin" name="foodOrigin">
			        		<option>Italian</option>
			        		<option>Spanish</option>
			        		<option>Chinese</option>
			        	</select>
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
			        <td>Description </td>
			        <td><input id="description" type="text" name="description" required=""></td>
			    </tr>   
			    <tr>
			    	<td>Prep Time</td>
			    	<td><input id="" type="" name="" required=""></td>
			    </tr> 
			    <tr>
			    	<td>Ingredients</td>
			    	<td><input id="" type="" name="" required=""></td>
			    </tr>   
			    <tr>
			    	<td>Directions</td>
			    	<td><input id="" type="" name="" required=""></td>
			    </tr>     
			    <tr>
			    	<td>Image</td>
			    	<td><input type="file" name="image"></td>
			    </tr>
			    <tr>
			        <td></td>
			        <td><input type="submit" value="Submit"></td>
			    </tr>
			</table>
		</form>
	</div>

</body>
</html>