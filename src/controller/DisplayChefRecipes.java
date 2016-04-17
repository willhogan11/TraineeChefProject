package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
import com.sun.xml.internal.txw2.Document;

import beans.Chef;

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
		
	/*	String test = request.getParameter("test");	
		String chefId = request.getParameter("chef_Id");
		
		request.setAttribute("chefId", chefId);
		request.setAttribute("test", test);*/
		
		Chef chef = new Chef();
		int chefIdString = Integer.parseInt(request.getParameter("chef_Id"));
		chef.setId(chefIdString);
		
		
		// Make a connection to the database
		String url = "jdbc:mysql://localhost/users";
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
						  "WHERE R.CHEF_ID = ?";
			 
			 // This might work for data access object structure
			 // DisplayResultsSetDAO sql = new DisplayResultsSetDAO();
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()){
				 
				 
				 
			 	/*int id = rs.getInt("ID");
			 	String name = rs.getString("NAME");
			 	int age = rs.getInt("AGE");*/
			 }
			 rs.close();
			 conn.close();
			 
			}
			catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		request.getRequestDispatcher("jsp/DisplayChefRecipes.jsp").forward(request, response);
	}
}