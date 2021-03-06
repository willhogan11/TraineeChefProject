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
import beans.*;


/*
 * This class is responsible for Entering recipes into the database from the front end section 
 * of the Web application using a HTTP POST request 
 * Steps:
 * 	1) Make a connection to the Database
 * 	2) Create the SQL delete query and select parameters using the Bean class getters & setters methods
 * 	3) Bind the values from the getters and setters to the request parameters
 * 	4) Execute the query
 * 	5) Redirect the user to the Success JSP page
 */

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
		
		// Set Attributes that save the values of each
		request.setAttribute("studentName", studentName);
	    request.setAttribute("studentSurname", studentSurname);
	    
	    System.out.println(studentName + " " + studentSurname);

		session.setAttribute("studentName", studentName);
		session.setAttribute("studentSurname", studentSurname);
		
		request.setAttribute("recipeName", "Recipe " + recipeName + " Entered");
		session.setAttribute("recipeName", "Recipe " + recipeName + " Entered");
		
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
	    recipe.setPrepTimeHours(Integer.parseInt(request.getParameter("prepTimeHours")));
	    recipe.setPrepTimeMins(Integer.parseInt(request.getParameter("prepTimeMins")));
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
	    	
			String sql1 = "INSERT INTO RECIPE(NAME, DESCRIPTION, PREP_TIME_HOURS, PREP_TIME_MINS, INGREDIENTS, DIRECTIONS, IMAGE, CHEF_ID, FOOD_TYPE_ID, FOOD_ORIGIN_ID) "
					   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.PreparedStatement prest1 = conn.prepareStatement(sql1);
			
			prest1.setString(1, recipe.getRecipeName());
			prest1.setString(2, recipe.getDescription());
			prest1.setInt(3, recipe.getPrepTimeHours());
			prest1.setInt(4, recipe.getPrepTimeMins());
			prest1.setString(5, recipe.getIngredients());
			prest1.setString(6, recipe.getDirections());
			
			// fetches input stream of the upload file for the blob column
			if (inputStream != null) {
				prest1.setBlob(7, inputStream);
			}
			prest1.setInt(8, chef.getId());
			prest1.setInt(9, foodType.getId());
			prest1.setInt(10, foodOrigin.getFoodOriginid());
			
			// sends the statement to the database server
            prest1.executeUpdate();
            prest1.close();
			conn.close();	
			
	    }catch (Exception e) {
            e.printStackTrace();
	    }
	    response.sendRedirect("jsp/Success.jsp");
	}
}