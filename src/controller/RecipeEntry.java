package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.mysql.jdbc.Connection;
import com.sun.glass.ui.Application;

import dataAccessObjects.*;
import beans.*;


@WebServlet(asyncSupported = true, urlPatterns = { "/RecipeEntry" })
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class RecipeEntry extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost/traineechefdb";
	    String user = "root";
	    String password = null;
	    Connection conn = null;
	    
	    String[] stringSplit;
		InputStream inputStream = null; // input stream of the upload file
		
	    HttpSession session = request.getSession(); 
		String recipeName = request.getParameter("recipeName");
		
		// Get the Chef's username parameters
		String studentName = request.getParameter("studentName");
		String studentSurname = request.getParameter("studentSurname"); 
		
		request.getMethod();
		
		// Set Attributes that save the values of each
		request.setAttribute("studentName", studentName);
	    request.setAttribute("studentSurname", studentSurname);
	    
	    System.out.println(studentName + " " + studentSurname);

		session.setAttribute("studentName", studentName);
		session.setAttribute("studentSurname", studentSurname);
		
		request.setAttribute("recipeName", "You Successfully Entered a recipe for: " + recipeName);
		session.setAttribute("recipeName", "You Successfully Entered a recipe for: " + recipeName);
		
		Chef chef = new Chef();
		Recipe recipe = new Recipe();
		FoodType foodType = new FoodType();
		FoodOrigin foodOrigin = new FoodOrigin();
		
		// Need to set this up that on login through client side, 
		// data is fetched from server and textfields are prepopulated with data. 
		
		chef.setId(1); //  For Testing Purposes
	    
		String receivedFoodtype = request.getParameter("foodType");
		stringSplit = receivedFoodtype.split(" - ");
		int foodTypeId = Integer.parseInt(stringSplit[1]);
	    foodType.setId(foodTypeId);
	    
		String receivedFoodOrigin = request.getParameter("foodOrigin");
		stringSplit = receivedFoodOrigin.split(" - ");	    
		int foodOriginId = Integer.parseInt(stringSplit[1]);
	    foodOrigin.setFoodOriginid(foodOriginId);
	    
	    recipe.setRecipeName(request.getParameter("recipeName"));
	    recipe.setDescription(request.getParameter("description"));
	    recipe.setPrepTime(Double.parseDouble(request.getParameter("prepTime")));
	    recipe.setIngredients(request.getParameter("ingredientsReturned"));
	    recipe.setDirections(request.getParameter("directions"));
	    
        // Obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        
        if (filePart != null) {
            inputStream = filePart.getInputStream(); // obtains input stream of the upload file
        }
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
	    	
			String sql1 = "INSERT INTO RECIPE(NAME, DESCRIPTION, PREP_TIME, INGREDIENTS, DIRECTIONS, IMAGE, CHEF_ID, FOOD_TYPE_ID, FOOD_ORIGIN_ID) "
					   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.PreparedStatement prest1 = conn.prepareStatement(sql1);
			
			prest1.setString(1, recipe.getRecipeName());
			prest1.setString(2, recipe.getDescription());
			prest1.setDouble(3, recipe.getPrepTime());
			prest1.setString(4, recipe.getIngredients());
			prest1.setString(5, recipe.getDirections());
			
			// fetches input stream of the upload file for the blob column
			if (inputStream != null) {
				prest1.setBlob(6, inputStream);
			}
			prest1.setInt(7, chef.getId());
			prest1.setInt(8, foodType.getId());
			prest1.setInt(9, foodOrigin.getFoodOriginid());
			
			// sends the statement to the database server
            prest1.executeUpdate();
            prest1.close();
			conn.close();	
			
            
          /*  if(request.getAttribute("logout") != null){
            	session.invalidate();
            	System.out.println("Logged Out");
            	response.sendRedirect("Index.jsp");
            }*/
			
	    }catch (Exception e) {
            e.printStackTrace();
	    }
	    response.sendRedirect("jsp/Success.jsp");
	    // request.getRequestDispatcher("jsp/Success.jsp").forward(request, response);
	}
}