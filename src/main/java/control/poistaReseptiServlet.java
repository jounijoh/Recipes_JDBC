package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptiDao;
import database.ReseptiJdbcDao;

//servletti reseptin poistamiseen

@WebServlet("/poista-resepti") //esim. /poista-resepti?reseptinid=x
public class poistaReseptiServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ReseptiDao reseptidao = new ReseptiJdbcDao();
			boolean poistoOk = false;
			
			//haetaan haluttu id 
			String strReseptiId = request.getParameter("reseptinid");
			int reseptiId = Integer.parseInt(strReseptiId);
			
			//poistetaan resepti
			poistoOk = reseptidao.remove(reseptiId);
			
			if(poistoOk) {//poiston onnistuttua siirrytään reseptit sivulle
				response.sendRedirect("/reseptit");
			}else {//muussa tapauksessa virheilmoitus
				String virheViesti = "Reseptin poisto tietokannasta epäonnistui.";
				request.setAttribute("viesti", virheViesti);
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
			}
		} catch (NumberFormatException e) {
			String virheViesti = "Reseptin poistopyynnössä tapahtui virhe.";
			request.setAttribute("viesti", virheViesti);
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp");
			e.printStackTrace();
		}
		
	}
	
}
