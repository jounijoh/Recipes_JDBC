package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptiDao;
import database.ReseptiJdbcDao;
import model.Resepti;


@WebServlet("/hae-nimella")
public class haeNimelläServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//haetaan haluttu nimi
		String reseptinNimi = request.getParameter("hakusana");
		//suoritetaan haku
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		List<Resepti> reseptit = reseptidao.reseptiSearch("nimi", reseptinNimi);
		
		request.setAttribute("reseptit", reseptit);
		request.getRequestDispatcher("/WEB-INF/reseptinhakunimella.jsp").forward(request, response);
		
	}
}
