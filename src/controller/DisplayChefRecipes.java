package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.sun.xml.internal.txw2.Document;

import beans.Chef;
import beans.FoodOrigin;
import beans.FoodType;
import beans.Recipe;

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
		Recipe recipe = new Recipe();
		FoodOrigin foodOrigin = new FoodOrigin();
		FoodType foodType = new FoodType();
		
		int chefIdString = Integer.parseInt(request.getParameter("chef_Id"));
		chef.setId(chefIdString);
		
		List<String> resultSet = new ArrayList<String>();
		
		
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
			 String sql = "SELECT R.NAME, R.DESCRIPTION, R.PREP_TIME, R.INGREDIENTS, R.DIRECTIONS, FO.ORIGIN, FT.TYPE_NAME " +
						  "FROM RECIPE AS R " +
						  	"INNER JOIN FOOD_ORIGIN AS FO " + 
						  		"ON R.FOOD_ORIGIN_ID = FO.FOOD_ORIGIN_ID " +
						  	"INNER JOIN FOOD_TYPE AS FT " +
						  		"ON R.FOOD_TYPE_ID = FT.FOOD_TYPE_ID " +
						  "WHERE R.CHEF_ID = '" + chef.getId() + "' ";
			 
			 // This might work for data access object structure
			 // DisplayResultsSetDAO sql = new DisplayResultsSetDAO();
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()){
				 
			 	String NAME = rs.getString("R.NAME");
			 	String DESCRIPTION = rs.getString("R.DESCRIPTION");
			 	double PREP_TIME = rs.getDouble("R.PREP_TIME");
			 	String INGREDIENTS = rs.getString("R.INGREDIENTS");
			 	String DIRECTIONS = rs.getString("R.DIRECTIONS");
			 	String ORIGIN = rs.getString("FO.ORIGIN");
			 	String TYPE_NAME = rs.getString("FT.TYPE_NAME");
			 	
			 	recipe.setRecipeName(NAME);
			 	recipe.setDescription(DESCRIPTION);
			 	recipe.setPrepTime(PREP_TIME);
			 	recipe.setIngredients(INGREDIENTS);
			 	recipe.setDirections(DIRECTIONS);
			 	foodOrigin.setOrigin(ORIGIN);
			 	foodType.setType(TYPE_NAME);
			 }
			 request.setAttribute("recipeName", recipe.getRecipeName());
		 	 request.setAttribute("recipeDescription", recipe.getDescription());
		 	 request.setAttribute("recipePrepTime", recipe.getPrepTime());
		 	 request.setAttribute("recipeIngredients", recipe.getIngredients());
		 	 request.setAttribute("recipeDirections", recipe.getDirections());
		 	 request.setAttribute("foodOrigin", foodOrigin.getOrigin());
		 	 request.setAttribute("foodType", foodType.getType());
		 	 
		 	 
		 	 // 1) Need to Store result set in an Arraylist to access with JSTL in DisplayChefRecipes.jsp table
		 	 // 2) Need to research iteration of List to display result set in table
			 
			rs.close();
			conn.close();
			 
			}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("jsp/DisplayChefRecipes.jsp").forward(request, response);
	}
}