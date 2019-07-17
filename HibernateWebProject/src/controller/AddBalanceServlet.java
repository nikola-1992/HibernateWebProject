package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;

/**
 * Servlet implementation class AddBalanceServlet
 */
@WebServlet(description = "balance adding", urlPatterns = { "/AddBalanceServlet" })
public class AddBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idUser = request.getParameter("idUser");
		String balanceAdded = request.getParameter("balanceAdded");
		
		AdminDAO dao = new AdminDAO();
		dao.addBalanceToUser(idUser, balanceAdded);
		response.sendRedirect("view/admin.jsp");
		
		
		
	}

}
