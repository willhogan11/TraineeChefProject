package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayRecipes
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RecipeEntrySuccess" })
public class RecipeEntrySuccess extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		// response.setContentType("text/html");
		HttpSession session = request.getSession(); 
		String status = request.getParameter("status");
		session.setAttribute("status", "Welcome User " + status);
		System.out.println("Username is: " + status);
		System.out.println("Username is: " + session.getAttribute(status));
	
		response.sendRedirect("jsp/Menu.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		// response.setContentType("text/html");
		HttpSession session = request.getSession(); 
		String status = request.getParameter("status");
		session.setAttribute("status", "Welcome User " + status);
		System.out.println("Username is: " + status);
		System.out.println("Username is: " + session.getAttribute(status));
		
		response.sendRedirect("jsp/Menu.jsp");
		
	}
}