package controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import beans.*;
import dataAccessObjects.*;


/**
 * Servlet implementation class AddIngredients
 */
@WebServlet("/AddIngredients")
public class AddIngredients extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("ingredientTypeResult", IngredientDAO.ingredientList());
			request.setAttribute("measureTypeResult", MeasurementDAO.measureType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("jsp/AddIngredients.jsp").forward(request, response);
		
	} // End doGet
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String user = "root";
	    String password = null;
	    Connection conn = null;
	    
	    Ingredient ingredient = new Ingredient();
	    String ingredientName = request.getParameter("ingredientName");
	    ingredient.setName(ingredientName);
	    request.setAttribute("Added to Database ", ingredientName);

	    response.setContentType("text/html");
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
	    	
			String sql = "INSERT INTO INGREDIENTS (NAME) VALUES(?)";
			java.sql.PreparedStatement prest = conn.prepareStatement(sql);

			prest.setString(1, ingredient.getName());
			prest.executeUpdate();

			prest.close();
			conn.close();
			
	    }catch (Exception e) {
            e.printStackTrace();
	    }
	    
	    System.out.println("value from 'getName()' " + ingredient.getName()); // Console Test
	    
	    getServletContext().getRequestDispatcher("/jsp/AddIngredients.jsp").forward(request, response);
        getServletContext().getAttribute(ingredientName);
        
        request.getAttribute(ingredientName);
	    
	    // response.getWriter().print("Ingredient " + ingredient.getName() + " successfully added to Database");
	    // response.sendRedirect("/jsp/AddIngredients.jsp");
	    
	    
	} // End doPost
}