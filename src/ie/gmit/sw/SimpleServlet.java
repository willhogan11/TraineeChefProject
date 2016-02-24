package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(asyncSupported = true, description = "A simple servlet", urlPatterns = { "/AdvancedServlet" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().print("<h3>Hello in HTML</h3>"); // Display in HTML
		response.getWriter().print("Hello from GET method!"); // Display from Servlet
	}
}