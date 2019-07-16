package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistracijaDAO;
import validacija.Validacija;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "ovo je ser za reg", urlPatterns = { "/RegistracioniServlet" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistracioniServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		RegistracijaDAO dao = new RegistracijaDAO();
		
		boolean ispitajPass = Validacija.proveriDaLiSuIstiPasswordi(password, repeatPassword);
		
		if(ispitajPass) {
			
			boolean daLiJePunUser = dao.daLiPostojiUserUbazi(userName);
				if(!(daLiJePunUser)) {
					boolean upisiUbazu = dao.upisiUseraUbazu(userName, password);
						if(upisiUbazu) {
							response.sendRedirect("index.html");
						}else {
							response.sendRedirect("registracija.html");
						}
				}else {
					response.sendRedirect("registracija.html");
				}
			
		}else {
			response.sendRedirect("registracija.html");
		}
		
	}

}
