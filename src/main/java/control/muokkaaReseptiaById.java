package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptiDao;
import database.ReseptiJdbcDao;
import model.Resepti;
@WebServlet("/muokkaa")
public class muokkaaReseptiaById extends HttpServlet{

	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//haetaan valittu id
		String strReseptiId = request.getParameter("id");
		int reseptiId = Integer.parseInt(strReseptiId);
		
		//haetaan resepti sqlitestä valitulla id:llä
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		Resepti resepti = reseptidao.findById(reseptiId);
		
		//lähetetään reseptin tiedot jsp.tiedostoon, jotta niitä voidaan muokata
		request.setAttribute("vanharesepti", resepti);
		
		//koska valmistsaika on kahdessa osassa tunteina ja minuutteina, se täytyyy pilkkoa osiin ja lähettää erikseen
		String valmistusaika = resepti.getValmistusaika();
		
		String h = ""; //apumuuttujat tunteja ja minuutteja varten
		String m = "";
		int onkoH = valmistusaika.indexOf('h');
		
		if (onkoH > -1) { //tarkistetaan onko h merkintään ollenkaan ja jaetaan sen perusteella osiin
			String[] ajat = valmistusaika.split("h");

			h = ajat[0].trim();
			m = ajat[1].trim().replace("min", "");

		}else {
			m = valmistusaika.trim().replace("min", "");
		}
		//lähetetään minuutit ja tunnit erikseen lomakkeeseen
		request.setAttribute("vanhattunnit", h);
		request.setAttribute("vanhatminuutit", m);
		request.getRequestDispatcher("/WEB-INF/muokkaareseptialomake.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
			//haetaan tiedot lomakkeelta
			String strReseptiId = request.getParameter("id");
			int reseptiId = Integer.parseInt(strReseptiId);
			String uusiNimi = request.getParameter("nimi");
			String uusiKuvaus = request.getParameter("kuvaus");
			String uusiAinekset = request.getParameter("ainekset");
			String uusiValmistusaika = "";
			String strTunnit = request.getParameter("tunnit");
			//muokataan aika sopivaan muotoon
			if (strTunnit != "") {
				int tunnit = Integer.parseInt(strTunnit);
				uusiValmistusaika = tunnit + "h ";
			}else {
				uusiValmistusaika = "";
			}
			String strMinuutit = request.getParameter("minuutit");
			if (strMinuutit != "") {
				int minuutit = Integer.parseInt(strMinuutit);
				uusiValmistusaika += minuutit + "min";
			}
			
			String uusiOhjeet = request.getParameter("ohjeet");
			
			
			//luodaan resepti uusilla tiedoilla
			Resepti resepti = new Resepti(reseptiId, uusiNimi, uusiKuvaus, uusiAinekset, uusiValmistusaika, uusiOhjeet);
			ReseptiDao reseptidao = new ReseptiJdbcDao();
		
			
			//päivitetään tietokantaan vanhaan reseptiin
			boolean updateOk = false;
			updateOk = reseptidao.updateResepti(resepti);
			if (updateOk) {
				System.out.println("muokkaus ok");
				response.sendRedirect("/reseptit");
			}else {
				String virheviesti = "Reseptin muokkaaminen tietokannassa ei onnistunut.";
				request.setAttribute("viesti", virheviesti);
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
				response.sendRedirect("/tapahtumaraportti");
			}
		} catch (NumberFormatException e) {
			
			
			e.printStackTrace();
			String virheviesti = "Reseptin muokkaamisessa tietokannassa tapahtui virhe.";
			request.setAttribute("viesti", virheviesti);
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
			response.sendRedirect("/tapahtumaraportti");
		}
		
		
	}
}
