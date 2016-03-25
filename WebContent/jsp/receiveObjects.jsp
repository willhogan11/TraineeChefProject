<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="ie.gmit.sw.beans.*" %>

<%-- <%
	List<Person> list1 = new ArrayList<Person>();

	list1.add(new Person("Will"));
	list1.add(new Person("John"));
	list1.add(new Person("Frank"));
	list1.add(new Person("Wally"));
	list1.add(new Person("Fred"));
	list1.add(new Person("Mark"));
	list1.add(new Person("Mike"));
	list1.add(new Person("Noel"));
	
	request.setAttribute("list1", list1);
%> --%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test JSTL</title>
</head>
<body>

<select>
	<c:forEach items="${list1}" var="person">
		<option>${person.name}</option>
	</c:forEach>
</select>

</body>
</html>