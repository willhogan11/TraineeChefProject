package dataAccessObjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import beans.FoodType;

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