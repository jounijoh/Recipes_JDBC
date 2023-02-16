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
	//sivu joka listaa kaikki reseptit selaimeen
	@WebServlet("/reseptit")
	public class ReseptitServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//haetaan reseptit db:stä listalle
			ReseptiDao reseptidao = new ReseptiJdbcDao();
			List<Resepti> reseptit = reseptidao.findAll();
			//lähetetään lista jsp tiedostolle
			request.setAttribute("reseptit", reseptit);
			request.getRequestDispatcher("/WEB-INF/reseptit.jsp").forward(request, response);
			
		}
	

}
