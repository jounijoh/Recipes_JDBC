package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//aloitussivun servlet
@WebServlet("/")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//haetaan ja lähetetään sivun tiedot jsp.tiedostosta selaimeen
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}
}
