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

@WebServlet("/uusi-resepti")
public class lisaaReseptiServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/uusireseptilomake.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//haetaan tiedot post-lomakkeelta
			String nimi = request.getParameter("nimi");
			String kuvaus = request.getParameter("kuvaus");
			String ainekset = request.getParameter("ainekset");
			String strTunnit = request.getParameter("tunnit");
			
			//valmistusaika tulee tunteina ja minuutteina, joten ne täytyy muokataa oikeanlaiseen muotoon
			String valmistusaika = "";
			if (strTunnit != "") {
				//jos ajassa on tunteja eli H pilkotaan aika sen kohdalta
				int tunnit = Integer.parseInt(strTunnit);
				valmistusaika = tunnit + "h";
			}else {
				valmistusaika = "";
			}
			String strMinuutit = request.getParameter("minuutit");
			if (strMinuutit != "") {
				int minuutit = Integer.parseInt(strMinuutit);
				valmistusaika += minuutit + "min";
			}
			//haetaan loput tiedot
			String ohjeet = request.getParameter("ohjeet");
		
			//luodaan tiedoista reseptiolio
			Resepti resepti = new Resepti(nimi, kuvaus, ainekset, valmistusaika, ohjeet);
			ReseptiDao reseptidao = new ReseptiJdbcDao();
			boolean lisaysOk = false;
			
			//lisätään resepti
			lisaysOk = reseptidao.addResepti(resepti);
			//jos lisäys onnistuu palataan reseptit-sivulle
			if(lisaysOk) {
				response.sendRedirect("/reseptit");
			}else {
				//jos ei onnistu, annetaan virheilmoitus
				String virheviesti = "Reseptin lisääminen tietokantaan ei onnistunut.";
				request.setAttribute("viesti", virheviesti);
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
				response.sendRedirect("/tapahtumaraportti");
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			String virheviesti = "Reseptin lisäämisessä tietokantaan tapahtui virhe.";
			request.setAttribute("viesti", virheviesti);
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
			response.sendRedirect("/tapahtumaraportti");
		}
		
	}
}
