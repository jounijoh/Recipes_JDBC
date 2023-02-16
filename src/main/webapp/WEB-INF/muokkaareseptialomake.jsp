<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>Muokkaa</title>
</head>
<body>
	
	<h1>Muokkaa reseptia id: <c:out value="${vanharesepti.id}" /></h1>
	<form action="/muokkaa" method="post">
		<p>
			
			Id: <input type="text" name="id" value="<c:out value="${vanharesepti.id}" />" readonly/>
			
		</p>
		<p>
			
			Nimi: <input type="text" name="nimi" value="<c:out value="${vanharesepti.nimi}" />"/>
			
		</p>
		<p>
			Kuvaus: <input type="text" name="kuvaus" value="<c:out value="${vanharesepti.kuvaus}" />"/>
		</p>
		<p>
			Ainekset: <input type="text" name="ainekset" value="<c:out value="${vanharesepti.ainekset}" />"/>
		</p>
		<label for="quantity"> Valmistusaika: <input  value="<c:out value="${vanhattunnit}" />"
			type="number" name="tunnit" min="0" max="24" /> tuntia <input value="<c:out value="${vanhatminuutit}" />" 
			type="number" name="minuutit" min="0" max="59" /> minuuttia
		</label>
		<p>
			Ohjeet: <input type="text" name="ohjeet" value="<c:out value="${vanharesepti.ohjeet}" />"/>
		</p>

		<input type="submit" value="Tallenna" /> <a href="/reseptit">
		<input type="reset">
			
		</a>
	</form>
</body>
</html>