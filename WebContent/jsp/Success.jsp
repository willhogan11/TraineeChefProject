<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<p>${msg}</p>
	<p>${SavedInsert}</p>
	<p>${message}</p>
	<p>${recipeName}</p>
	
	<p><%=request.getAttribute("Message")%></p>
	<p><%=request.getAttribute("RecipeName")%></p>
	<p><%=request.getAttribute("recipeName")%></p>
	
<%--<p><%=request.getAttribute("Message")%></p>
	<p><%=request.getAttribute("fbUser")%></p>
	<p><%=request.getAttribute("testData")%></p> --%>
	
	<a href="../html/Menu.html">
		<button>Return</button>
	</a>
	
	<!-- <a href="index.jsp"><input type="submit" name="logout" value="Logout" method="POST"></a> -->
</body>
</html>