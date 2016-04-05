package dataAccessObjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.FoodOrigin;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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