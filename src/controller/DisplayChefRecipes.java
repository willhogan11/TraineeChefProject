package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

/**
 * Servlet implementation class DisplayChefRecipes
 */
@WebServlet("/DisplayChefRecipes")
public class DisplayChefRecipes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 1) Need to find out how to redirect the 'test'(in this case) parameter
		 * 	  to the DisplayChefRecipe page and access it. 
		 * 2) Need to get CHEF_ID from DB early on (maybe using test 1 as static ID for now)
		 * 3) Need to Populate the jsp page with info in tables from the DB
		 *  */
		String test = request.getParameter("test");	
		request.setAttribute("test", test);
		System.out.println(test);
		
		request.getRequestDispatcher("jsp/DisplayChefRecipes.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
