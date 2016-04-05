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
		
	    chef.setStudentName(request.getParameter("studentName"));
	    chef.setStudentSurname(request.getParameter("studentSurname"));
	    
	    foodType.setType(request.getParameter("foodType"));
	    
	    int foodTypeId = Integer.parseInt(request.getParameter("foodType"));
	    foodType.setId(foodTypeId);
	    
	    int foodOriginId = Integer.parseInt(request.getParameter("foodOrigin"));
	    foodOrigin.setFoodOriginid(foodOriginId);
	    
	    recipe.setRecipeName(request.getParameter("recipeName"));
	    recipe.setDescription(request.getParameter("description"));
	    double prepTime = Double.parseDouble(request.getParameter("prepTime"));
	    recipe.setPrepTime(prepTime);
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
	    	
			String sql = "INSERT INTO RECIPE(NAME, DESCRIPTION, PREP_TIME, INGREDIENTS, DIRECTIONS, IMAGE, CHEF_ID, FOOD_TYPE_ID, FOOD_ORIGIN_ID) "
					   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement prest = conn.prepareStatement(sql);
			
			prest.setString(1, recipe.getRecipeName());
			prest.setString(2, recipe.getDescription());
			prest.setDouble(3,  recipe.getPrepTime());
			prest.setString(4,  recipe.getIngredients());
			prest.setString(5,  recipe.getDirections());
			
			// fetches input stream of the upload file for the blob column
			if (inputStream != null) {
				prest.setBlob(4, inputStream);
			}
			// sends the statement to the database server
            int row = prest.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }

			prest.close();
			conn.close();
			
			// sets the message in request scope
            request.setAttribute("Message", message);
			session.setAttribute("msg", "You Successfully Created a User!");
			// session.setAttribute("SavedInsert", "NAME: " + name + "<br>SURNAME: " + surname);
			
			// String fbUser = name + "<br>" + surname;
			// request.setAttribute("fbUser", fbUser);
			// request.setAttribute("testData", testdata);
			
			// forwards to the message page
            getServletContext().getRequestDispatcher("/Success.jsp").forward(request, response);
            // getServletContext().getAttribute(name);
            // getServletContext().getAttribute(fbUser);
            // getServletContext().getAttribute(testdata);
			// response.sendRedirect("Success.jsp");
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