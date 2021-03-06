package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Statement;
import beans.Chef;
import beans.Recipe;

/*
 * This class is responsible for Displaying any existing recipes from the database in a JSP page using a HTTP GET request 
 * These values are retrieved using a MySQL query located below
 * Steps:
 * 	1) Make a connection to the Database
 * 	2) Create the SQL delete query and select parameters using the Bean class getters & setters methods
 * 	3) Execute the query
 * 	4) Redirect the user to the DisplayChefRecipes JSP page
 */

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
		
		Chef chef = new Chef();
		int chefIdString = Integer.parseInt(request.getParameter("chef_Id"));
		chef.setId(chefIdString);
		List<Object> resultSet = new ArrayList<Object>();

		// Make a connection to the database
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
			 String sql = "SELECT R.RECIPE_ID, R.NAME, R.DESCRIPTION, R.PREP_TIME_HOURS, R.PREP_TIME_MINS," +
			 		            " R.INGREDIENTS, R.DIRECTIONS, FO.ORIGIN, FT.TYPE_NAME, R.IMAGE " +
						  "FROM RECIPE AS R " +
						  	"INNER JOIN FOOD_ORIGIN AS FO " + 
						  		"ON R.FOOD_ORIGIN_ID = FO.FOOD_ORIGIN_ID " +
						  	"INNER JOIN FOOD_TYPE AS FT " +
						  		"ON R.FOOD_TYPE_ID = FT.FOOD_TYPE_ID " +
						  "WHERE R.CHEF_ID = '" + chef.getId() + "' ";
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()){

				 Recipe recipe = new Recipe();
				 
				 recipe.setRecipeId(rs.getInt("R.RECIPE_ID"));
				 recipe.setRecipeName(rs.getString("R.NAME"));
				 recipe.setDescription(rs.getString("R.DESCRIPTION"));
				 recipe.setPrepTimeHours(rs.getInt("R.PREP_TIME_HOURS"));
				 recipe.setPrepTimeMins(rs.getInt("R.PREP_TIME_MINS"));
				 recipe.setIngredients(rs.getString("R.INGREDIENTS"));
				 recipe.setDirections(rs.getString("R.DIRECTIONS"));
				 recipe.setFoodOrigin(rs.getString("FO.ORIGIN"));
				 recipe.setFoodType(rs.getString("FT.TYPE_NAME"));
				 
				 resultSet.add(recipe);
				 recipe.equals(null);
			 }
			request.setAttribute("resultSet", resultSet);
			
			rs.close();
			conn.close();
			 
			}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/DisplayChefRecipes.jsp").forward(request, response);
	}
}