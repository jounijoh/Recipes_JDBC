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
@WebServlet("/ostoslista")
public class ostoslistaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//haetaan id
		String strReseptinId = request.getParameter("id");
		int reseptinId = Integer.parseInt(strReseptinId);
		
		//haetaan resepti
		ReseptiDao reseptidao = new ReseptiJdbcDao();
		Resepti resepti = reseptidao.findById(reseptinId);
		
		//haetaan reseptin ainekset
		String ainekset = resepti.getAinekset();
	
		
		//pilkotaan ainekset listalle
		
		String[] aineksetLista = ainekset.split(",");
		//lähetetään lista jsplle
		request.setAttribute("ainekset", aineksetLista);
		request.getRequestDispatcher("/WEB-INF/ostoslista.jsp").forward(request, response);
		
		
	}
}
