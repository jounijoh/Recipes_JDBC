<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Resepi-tietopankki</title>
</head>
<body>
	<h1>Resepti-tietopankki</h1>


	<form action="/hae-nimella">
		<label for="hakusana">Hae nimellä:</label> <input type="search"
			id="hakusana" name="hakusana"> <input type="submit"
			value="Hae">
	</form>
	<form action="/hae-aineksella">
		<label for="hakusana">Hae aineksella:</label> <input type="search"
			id="hakusana" name="hakusana"> <input type="submit"
			value="Hae">
	</form>
	<br>
	<br>
	<br>
	<br>
	<p>
		Projektityöni on reseptipankki/-sivusto, joka hyödyntää
		sqlite-tietokantasovellusta<br> tietojen säilömiseen, hakemiseen,
		tallentamiseen ja muokkaamiseen.<br>Sovelluksesta pystyy selaimen kautta hakemaan kaikki resept listana<br>
		ja sen lisäksi hakusanojen avulla. <br>Reseptejä voi myös muokata, lisätä seka poistaa.<br>
		<br>
		<br>
		Ajatuksenani oli lisätä web-sovellukseen myös ostoslistaosio, <br>
		joka listaa valittujen reseptien ainekset ja määrät.<br>
		Se osoittautuikin hieman liian monimutkaiseksi toteuttaa tällä aika taululla ja päädyin <br>
		toteuttamaan ostoslistan vain yksinkertaisena listana yhdestä valitusta reseptistä <br><br><br>
		Ohjelman toiminnot hyödyntävät palvelinpään jsp. toimintoja.
		<br>
		Pyrin projektissa käyttämään opittuja taitoja mahdollisimman monella eri tapaa, <br>
		kuitenkin niin ettei toimivuus kärsi. <br>
		Päädyinkin käyttämään kaiken projektiin käyttämäni ajan vain toiminnallisuuksien kehittämiseen, <br>
		minkä johdosta en kehittänyt sivuston ulkoasua laisinkaan.
		<br>
		<br>
		Projektin myötä opin toteuttamaan tietokantaa hyödyntäviä web-sovellustoimintoja monilla eri tavoin <br>
		ja olenkin tyytyväinen lopputulokseen vaikka aika ei riittänytkään käyttöliittymän tyylittelyyn.
	
		 
	</p>
	<br>
	<br>
	<br>
	<br>
	<a href="/reseptit"><button type="button">Näytä kaiki
			reseptit</button></a>
	<a href="/uusi-resepti"><button type="button">Lisää uusi
			resepti</button></a>
	<br>
</body>
</html>