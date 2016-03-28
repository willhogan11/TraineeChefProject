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
		
	    HttpSession session = request.getSession();
	    String message = null;
	    
	    InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
	    
	    String name = request.getParameter("name");
	    String surname = request.getParameter("surname");
		String age = request.getParameter("age");
		String testdata = request.getParameter("testdata");
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
	    	
			String sql = "INSERT INTO USERTABLE(NAME, SURNAME, AGE, IMAGE) VALUES(?, ?, ?, ?)";
			java.sql.PreparedStatement prest = conn.prepareStatement(sql);
			/*prest.setString(1, name);
			prest.setString(2, surname);*/
			prest.setString(3, age);
			
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
			session.setAttribute("SavedInsert", "NAME: " + name + "<br>SURNAME: " + surname);
			
			String fbUser = name + "<br>" + surname;
			request.setAttribute("fbUser", fbUser);
			request.setAttribute("testData", testdata);
			
			// forwards to the message page
            getServletContext().getRequestDispatcher("/Success.jsp").forward(request, response);
            getServletContext().getAttribute(name);
            getServletContext().getAttribute(fbUser);
            getServletContext().getAttribute(testdata);
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