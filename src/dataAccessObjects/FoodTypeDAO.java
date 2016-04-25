package dataAccessObjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import beans.FoodType;

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
public class FoodTypeDAO {
	
	public static List<FoodType> foodTypelist() throws Exception {
		
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    List<FoodType> result = new ArrayList<FoodType>();
        
    	try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");		
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM FOOD_TYPE "
					   + "ORDER BY TYPE_NAME";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				FoodType fType = new FoodType();
				fType.setId(rs.getInt("FOOD_TYPE_ID"));
				fType.setType(rs.getString("TYPE_NAME"));
				result.add(fType);
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