package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ChefDatabaseEntry
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ChefDatabaseEntry" })
public class ChefDatabaseEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChefDatabaseEntry() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		String url = "jdbc:mysql://localhost/users";
	    String user = "root";
	    String password = null;
	    Connection conn = null;*/
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		request.setAttribute("Name", name);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		getServletContext().getAttribute(name);
		System.out.println(name);
		
	}

}
