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
		<label for="hakusana">Hae nimell�:</label> <input type="search"
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
		Projektity�ni on reseptipankki/-sivusto, joka hy�dynt��
		sqlite-tietokantasovellusta<br> tietojen s�il�miseen, hakemiseen,
		tallentamiseen ja muokkaamiseen.<br>Sovelluksesta pystyy selaimen kautta hakemaan kaikki resept listana<br>
		ja sen lis�ksi hakusanojen avulla. <br>Reseptej� voi my�s muokata, lis�t� seka poistaa.<br>
		<br>
		<br>
		Ajatuksenani oli lis�t� web-sovellukseen my�s ostoslistaosio, <br>
		joka listaa valittujen reseptien ainekset ja m��r�t.<br>
		Se osoittautuikin hieman liian monimutkaiseksi toteuttaa t�ll� aika taululla ja p��dyin <br>
		toteuttamaan ostoslistan vain yksinkertaisena listana yhdest� valitusta reseptist� <br><br><br>
		Ohjelman toiminnot hy�dynt�v�t palvelinp��n jsp. toimintoja.
		<br>
		Pyrin projektissa k�ytt�m��n opittuja taitoja mahdollisimman monella eri tapaa, <br>
		kuitenkin niin ettei toimivuus k�rsi. <br>
		P��dyinkin k�ytt�m��n kaiken projektiin k�ytt�m�ni ajan vain toiminnallisuuksien kehitt�miseen, <br>
		mink� johdosta en kehitt�nyt sivuston ulkoasua laisinkaan.
		<br>
		<br>
		Projektin my�t� opin toteuttamaan tietokantaa hy�dynt�vi� web-sovellustoimintoja monilla eri tavoin <br>
		ja olenkin tyytyv�inen lopputulokseen vaikka aika ei riitt�nytk��n k�ytt�liittym�n tyylittelyyn.
	
		 
	</p>
	<br>
	<br>
	<br>
	<br>
	<a href="/reseptit"><button type="button">N�yt� kaiki
			reseptit</button></a>
	<a href="/uusi-resepti"><button type="button">Lis�� uusi
			resepti</button></a>
	<br>
</body>
</html>