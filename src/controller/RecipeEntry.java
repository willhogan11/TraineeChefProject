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
import dataAccessObjects.*;
import beans.*;


@WebServlet(asyncSupported = true, urlPatterns = { "/RecipeEntry" })
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class RecipeEntry extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
  
		try {
			request.setAttribute("foodOriginResult", FoodOriginDAO.foodOriginlist());
			request.setAttribute("foodTypeResult", FoodTypeDAO.foodTypelist());
			request.setAttribute("prepTimeResult", PrepTimeDAO.prepTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("jsp/RecipeEntry.jsp").forward(request, response);
		response.sendRedirect("jsp/RecipeEntry.jsp");
	
	} // End doGet
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost/traineechefdb";
	    String user = "root";
	    String password = null;
	    Connection conn = null;
	    
	    String message = null;
		InputStream inputStream = null; // input stream of the upload file
	    HttpSession session = request.getSession();
		
		Chef chef = new Chef();
		Recipe recipe = new Recipe();
		FoodType foodType = new FoodType();
		FoodOrigin foodOrigin = new FoodOrigin();
		
		chef.setId(1);
	    chef.setStudentName(request.getParameter("studentName"));
	    chef.setStudentSurname(request.getParameter("studentSurname"));
	    
	    
	    int foodTypeId = Integer.parseInt(request.getParameter("foodType"));
	    foodType.setId(foodTypeId);
	    
	    int foodOriginId = Integer.parseInt(request.getParameter("foodOrigin"));
	    foodOrigin.setFoodOriginid(foodOriginId);
	    
	    // foodType.setType(request.getParameter("foodType"));
	    // foodOrigin.setOrigin(request.getParameter("foodOrigin"));
	    
	    recipe.setRecipeName(request.getParameter("recipeName"));
	    recipe.setDescription(request.getParameter("description"));
	    
	    /*Double prepTime = Double.parseDouble(request.getParameter("prepTime"));
	    recipe.setPrepTime(prepTime);*/
	    
	    recipe.setPrepTime(Double.parseDouble(request.getParameter("prepTime")));
	    
	    recipe.setIngredients(request.getParameter("ingredientsReturned"));
	    recipe.setDirections(request.getParameter("directions"));
	    
        // Obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        } //  End if
        
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			
			String sql = "INSERT INTO CHEF(F_NAME, SURNAME) "
					   + "VALUES(?, ?)";
	    	
			String sql1 = "INSERT INTO RECIPE(NAME, DESCRIPTION, PREP_TIME, INGREDIENTS, DIRECTIONS, IMAGE, CHEF_ID, FOOD_TYPE_ID, FOOD_ORIGIN_ID) "
					   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, chef.getStudentName());
			prest.setString(2, chef.getStudentSurname());
			
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
			
			prest.executeUpdate();
			
			// sends the statement to the database server
            int row = prest1.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
            
            prest.close();
            prest1.close();
			conn.close();
			
			
			// sets the message in request scope
            request.setAttribute("Message", message);
			// session.setAttribute("msg", "You Successfully Created a User!");
			// session.setAttribute("SavedInsert", "NAME: " + name + "<br>SURNAME: " + surname);
			
			// String fbUser = name + "<br>" + surname;
			// request.setAttribute("fbUser", fbUser);
			// request.setAttribute("testData", testdata);
			
			// forwards to the message page
            // getServletContext().getRequestDispatcher("jsp/Success.jsp").forward(request, response);
            // getServletContext().getAttribute(name);
            // getServletContext().getAttribute(fbUser);
            // getServletContext().getAttribute(testdata);
            
			response.sendRedirect("jsp/Success.jsp");
            
            if(request.getAttribute("logout") != null){
            	session.invalidate();
            	System.out.println("Logged Out");
            	response.sendRedirect("Index.jsp");
            }
			
	    }catch (Exception e) {
            e.printStackTrace();
	    }
	}
}