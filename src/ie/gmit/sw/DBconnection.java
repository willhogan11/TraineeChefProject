package ie.gmit.sw;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBconnection {
	
	public Connection getDBconnection() {
		String url = "jdbc:mysql://localhost/users";
	    String user = "root";
	    String password = null;
	    Connection conn = null;
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}