package dataAccessObjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.FoodOrigin;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/*
 * This DataAccessObject Class contains data from the database that's stored and returned in a List Collection
 * The returned list object can then be accessed in the JSP page using JSTL(Java Server Pages Tag Library) & EL(Expression language)
 * Here is an outline if whats hapening below:
 * 	1) Connect to the Database
 * 	2) Create the query using MySQL
 * 	3) Bind the returned values from each query with Getters & Setters form the Bean Class
 * 	4) Store each query object in an List
 * 	5) Return the list to be used elsewhere
 */
public class FoodOriginDAO {

	public static List<FoodOrigin> foodOriginlist() throws Exception {
			
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
			String sql = "SELECT * FROM FOOD_ORIGIN "
					    + "ORDER BY ORIGIN";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				FoodOrigin fOrigin = new FoodOrigin();
				fOrigin.setFoodOriginid(rs.getInt("FOOD_ORIGIN_ID"));
				fOrigin.setOrigin(rs.getString("ORIGIN"));
				result.add(fOrigin);
			}
			rs.close();
	        stmt.close();
	        conn.close();
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace(); 
		}
    	return result;
	}
}