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
/*	private String url;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.url = getServletContext().getInitParameter("");
	}*/
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    List<FoodOrigin> result = new ArrayList<FoodOrigin>();
        
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
				result.add(fOrigin);
			}
			rs.close();
	        stmt.close();
	        conn.close();
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace(); 
		}
    	//return result;
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("jsp/RecipeEntry.jsp").forward(request, response);
		
		
		
		
		// System.out.println("XML Servlet Call"); // Check on console that this executed
/*		response.setContentType("text/html");
		String username = request.getParameter("username");
		
		// 1. Create a session object to hold the userName overcome Statelessness 
		// 2. Set the new session object attribute with a 'savedUserName' to remember the user in the session
		HttpSession session = request.getSession();
		
		// Null check
		if(username != "" && username != null){
			session.setAttribute("savedUserName", username);
		}
		
		// response.getWriter().print("Hello from the GET method" + userName);
		response.getWriter().print("Request parameter has username as " + username);
		response.getWriter().print("<br><br> Session parameter has username as " + (String) session.getAttribute("savedUserName"));*/
	
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
		
		
	    
	    
		
		// System.out.println("XML Servlet Call"); // Check on console that this executed
		/*response.setContentType("text/html");
		String username = request.getParameter("username");
		String surname = request.getParameter("surname");
		String age = request.getParameter("age");
		String prof = request.getParameter("prof");
		// String location = request.getParameter("location"); // Fine if one item to be selected
		
		String[] location = request.getParameterValues("location"); // Need this for multiple
		response.getWriter().print("Hello from POST method. Your details are: " + username + " " + surname + " " + age);
		response.getWriter().print("You are a " + prof + " and your locations / places are " + location.length);
		
		for (int i = 0; i < location.length; i++) {
			response.getWriter().print(" " + location[i] + " ");
		}*/
	}
}