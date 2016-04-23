<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/receipeDeletedSuccess.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<title>Recipe Deleted</title>
</head>
	
<body>
	<div id="recipeDeletedDiv">
		<h4>Recipe Deleted <span class="glyphicon glyphicon-ok"></span></h4>
		<a href="${pageContext.request.contextPath}/jsp/Menu.jsp">
			<button class="btn btn-lg btn-success">Menu</button>
		</a>
	</div>
</body>
</html>