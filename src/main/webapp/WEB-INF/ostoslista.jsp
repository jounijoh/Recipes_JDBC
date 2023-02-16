<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ostoslista</title>
</head>
<body>
<h1>OSTOSLISTA: </h1>
<p>


<c:forEach var="list" items="${ainekset}">
<p>
 <c:out value="${list}"/> 
 <p>
</c:forEach>
</p>

<a href="/reseptit"><button type="button">Takaisin resepteihin</button></a>
</body>
</html>