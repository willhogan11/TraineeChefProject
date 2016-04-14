<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Success Page</title>
</head>
<body>
	<p>${studentName}</p>
	<p>${studentSurname}</p>
	
	<p>session.getAttribute("studentName")%></p>
	<p>session.getAttribute("studentSurname")%></p>
	
	<p>EL(Expression Language) -----> ${recipeName}</p>
	
	<%-- <p>Scriplet Session object -----> <%=session.getAttribute("recipeName")%></p> --%>
	
	<a href="../jsp/Menu.jsp">
		<button>Return</button>
	</a>
	
	<!-- <a href="index.jsp"><input type="submit" name="logout" value="Logout" method="POST"></a> -->
</body>
</html>