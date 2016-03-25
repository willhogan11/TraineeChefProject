package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import beans.FoodOrigin;


@WebServlet(asyncSupported = true, urlPatterns = { "/RecipeEntry" })
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class RecipeEntry extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    List<FoodOrigin> foodOriginResult = new ArrayList<FoodOrigin>();
        
    	try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");		
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM FOOD_ORIGIN";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				FoodOrigin fOrigin = new FoodOrigin();
				fOrigin.setOrigin(rs.getString("ORIGIN"));
				foodOriginResult.add(fOrigin);
			}
			rs.close();
	        stmt.close();
	        conn.close();
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		request.setAttribute("foodOriginResult", foodOriginResult);
		request.getRequestDispatcher("jsp/RecipeEntry.jsp").forward(request, response);
	
	} // End doGet
	
	
	
	
/*		
	public List<FoodOrigin>list() throws Exception{
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    List<FoodOrigin> foodOriginList = new ArrayList<FoodOrigin>();
	    
        
    	try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");		
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM FOOD_ORIGIN";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				FoodOrigin fo = new FoodOrigin();
				fo.setOrigin(rs.getString("foodOrigin"));
				foodOriginList.add(fo);
			}
			rs.close();
	        stmt.close();
	        conn.close();
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace(); 
		}
    	return foodOriginList;
	}
	
	
	*/
	
	
	
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