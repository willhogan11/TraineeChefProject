package dataAccessObjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import beans.Ingredient;

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
public class IngredientDAO {
	
	public static List<Ingredient> ingredientList() throws Exception {
		
		String url = "jdbc:mysql://localhost/traineechefdb";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String password = null;
	    List<Ingredient> result = new ArrayList<Ingredient>();
        
    	try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");		
			Class.forName("com.mysql.jdbc.Driver");
			
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM INGREDIENTS "
					    + "ORDER BY NAME";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Ingredient ing = new Ingredient();
				ing.setName(rs.getString("NAME"));
				result.add(ing);
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