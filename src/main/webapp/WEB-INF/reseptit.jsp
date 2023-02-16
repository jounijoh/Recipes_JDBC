<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Reseptit</title>

</head>
<body>
	<h1>Reseptit tietopankissa:</h1>
	<form action="/hae-nimella">
		<label for="hakusana">Hae nimell‰:</label> <input type="search"
			id="hakusana" name="hakusana"> <input type="submit"
			value="Hae">
	</form>
	<form action="/hae-aineksella">
		<label for="hakusana">Hae aineksella:</label> <input type="search"
			id="hakusana" name="hakusana"> <input type="submit"
			value="Hae">
	</form>

	<table class="table table_striped">

		<tr>
			<th>Reseptin numero</th>
			<th>Nimi</th>
			<th>Kuvaus</th>
			<th>Ainekset</th>
			<th>Valmistusaika</th>
			<th>Ohjeet</th>
		</tr>
		<c:forEach items="${reseptit}" var="reseptit">
			<tr>
				<td><c:out value="${reseptit.id}" /></td>
				<td><c:out value="${reseptit.nimi}" /></td>
				<td><c:out value="${reseptit.kuvaus}" /></td>
				<td><c:out value="${reseptit.ainekset}" /></td>
				<td><c:out value="${reseptit.valmistusaika}" /></td>
				<td><c:out value="${reseptit.ohjeet}" /></td>
				<td><a href="/poista-resepti?reseptinid=${reseptit.id}"><button
							type="button">Poista resepti</button></a></td>
				<td><a href="/muokkaa?id=${reseptit.id}"><button
							type="button">Muokkaa</button></a></td>
				<td><a href="/ostoslista?id=${reseptit.id}"><button type="button">Lis‰‰
							ostoslistalle</button></a></td>

			</tr>
		</c:forEach>

	</table>
	<a href="/uusi-resepti"><button type="button">Lis‰‰ uusi
			resepti</button></a>
</body>
</html>