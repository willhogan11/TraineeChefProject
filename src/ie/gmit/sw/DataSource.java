package ie.gmit.sw;

import java.io.IOException;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

/**
 * Servlet implementation class DataSource
 */
@WebServlet("/DataSource")
public class DataSource extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DataSource ds; // Declare a new DataSource instance. 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSource() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			
			InitialContext initContext = new InitialContext();
			Context env = (Context)initContext.lookup("java:/comp/env"); // Returns an object, which we cast to a thing of type Context
			ds = (DataSource)env.lookup("jdbc/traineechefdb"); // Returns an object of type datasource, cast to a ds instance
		} catch (NamingException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
