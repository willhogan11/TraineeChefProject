package ie.gmit.sw;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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


@WebServlet(asyncSupported = true, urlPatterns = { "/UserEntryServlet" })
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UserEntryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
/*	private String url;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.url = getServletContext().getInitParameter("");
	}*/


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		String url = "jdbc:mysql://localhost/users";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    
		// Set response content type, in this case HTML
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
    	try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");		
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM USERTABLE";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				
				out.println("ID: " + id);
				out.println(" NAME: " + name);
				out.println(" AGE: " + age + "<br>");
			}
			rs.close();
	        stmt.close();
	        conn.close();
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	/*	// System.out.println("XML Servlet Call"); // Check on console that this executed
		response.setContentType("text/html");
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
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost/users";
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
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
	    	
			String sql = "INSERT INTO USERTABLE(NAME, SURNAME, AGE, IMAGE) VALUES(?, ?, ?, ?)";
			java.sql.PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, name);
			prest.setString(2, surname);
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
			 // forwards to the message page
            getServletContext().getRequestDispatcher("/Success.jsp").forward(request, response);
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