package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artikal;
import service.AdminService;

/**
 * Servlet implementation class DodajArtikalServlet
 */
@WebServlet(description = "dodavanje artikala", urlPatterns = { "/DodajArtikalServlet" })
public class DodajArtikalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String imeArtikla = request.getParameter("imeArtikla");
		String cena = request.getParameter("cena");
		String stanje = request.getParameter("stanje");
		String popust = request.getParameter("popust");
		
		Artikal artikal = new Artikal();
		artikal.setImeArtikla(imeArtikla);
		artikal.setCena(Double.parseDouble(cena));
		artikal.setStanje(Integer.parseInt(stanje));
		artikal.setPopust(Double.parseDouble(popust));
		
		AdminService service = new AdminService();
		service.dodajArtikal(artikal);
		
		response.sendRedirect("view/admin.jsp");
		
		
	}

}
