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


@WebServlet("/hae-aineksella")
public class haeAineksellaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//haetaan haluttu nimi
		String aines = request.getParameter("hakusana");
		//suoritetaan haku
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		List<Resepti> reseptit = reseptidao.reseptiSearch("ainekset", aines);
		//lähetetään jsp:lle
		request.setAttribute("reseptit", reseptit);
		request.getRequestDispatcher("/WEB-INF/reseptinhakuaineksella.jsp").forward(request, response);
		
	}
}
