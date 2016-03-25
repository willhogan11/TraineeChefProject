package ie.gmit.sw.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ie.gmit.sw.beans.Person;

/**
 * Servlet implementation class PassObjects
 */
@WebServlet("/PassObjects")
public class PassObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Person> list1 = new ArrayList<Person>();
		
		list1.add(new Person("Will"));
		list1.add(new Person("John"));
		list1.add(new Person("Frank"));
		list1.add(new Person("Wally"));
		
		request.setAttribute("list1", list1);
		
		request.getRequestDispatcher("/receiveObjects.jsp").forward(request, response);
		
		/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/receiveObjects.jsp");
		dispatcher.forward(request, response);*/
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
