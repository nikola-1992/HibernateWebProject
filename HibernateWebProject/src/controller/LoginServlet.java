package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dao.RegistracijaDAO;
import model.Role;
import model.User;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "servlet za login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		boolean proveraUsera = service.daLiPostojiUserUbazi(userName);
		
		if(proveraUsera) {
			boolean proveraPassworda = service.daLiPasswordOdgovaraUseru(userName, password);
				if(proveraPassworda) {
					User user = service.vratiUseraPoUserName(userName);
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
						
					if(user.getRole()==Role.ADMINISTRATOR) {
						response.sendRedirect("view/admin.jsp");
					}else {
						response.sendRedirect("view/user.jsp");
					}
					
				}else {
					response.sendRedirect("login.html");
				}
			
		}else {
			response.sendRedirect("login.html");
		}
		
		
	}

}
