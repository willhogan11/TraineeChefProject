package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Statement;

import beans.Recipe;

/*
 * This class is responsible for Deleting Recipes from the database using a HTTP GET request 
 * These values are located by get the currently selected elements id using code from the dataAccesssObjects folder in this project
 * to send the request to delete the row from the database. 
 * Steps:
 * 	1) Make a connection to the Database
 * 	2) Create the SQL delete query and select parameters using the Bean class getters & setters methods
 * 	3) Execute the query
 * 	4) Redirect the user to the Recipe delete success page
 */

/**
 * Servlet implementation class DeleteRecipe
 */
@WebServlet("/DeleteRecipe")
public class DeleteRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Recipe recipe = new Recipe();
		String deleteRecipe = request.getParameter("deleteRecipe");	
		recipe.setRecipeId(Integer.parseInt(deleteRecipe));
		request.setAttribute("deleteRecipe", deleteRecipe);
		
		System.out.println("String deleteRecipe " + deleteRecipe); // Debugging Purposes
		
		String url = "jdbc:mysql://localhost/traineechefdb";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = null;
		
		try {
			 Class.forName(driver).newInstance();
			 Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			 System.out.println("Connection Established");		
			 Class.forName("com.mysql.jdbc.Driver");
			 Statement stmt = (Statement) conn.createStatement();
			 String sql = "DELETE FROM RECIPE WHERE RECIPE_ID = '" + recipe.getRecipeId() + "' ";
			 stmt.executeUpdate(sql);
			 
			 stmt.close();
			 conn.close();
			 
		}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("jsp/DeleteRecipeSuccess.jsp").forward(request, response);
	}
}
