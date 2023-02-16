<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>Uuden reseptin lisäys</title>
</head>
<body>
	<h1>Uuden reseptin lisäys</h1>
	<form action="/uusi-resepti" method="post">
		<p>
			Id: ID
		</p>
		<p>
			Nimi: <input type="text" name="nimi" />
		</p>
		<p>
			Kuvaus: <input type="text" name="kuvaus" />
		</p>
		<p>
			Ainekset: <input type="text" name="ainekset" />
		</p>
		<label for="quantity"> Valmistusaika tuntia: <input
			type="number" name="tunnit" min="0" max="24" /> Minuuttia: <input
			type="number" name="minuutit" min="0" max="59" />
		</label>
		<p>
			Ohjeet: <input type="text" name="ohjeet" />
		</p>

		<input type="submit" value="Tallenna" /> <a href="/reseptit">
		<input type="reset">
			
		</a>
	</form>
</body>
</html>