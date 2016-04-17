package controller;

public class DisplayResultsSetDAO {
	
	public String displayRecipeResultSet(){
		String resultSet = "SELECT R.NAME, R.DESCRIPTION, R.PREP_TIME, R.INGREDIENTS, R.DIRECTIONS, FO.ORIGIN, FT.TYPE_NAME " +
							  "FROM RECIPE AS R " +
							  	"INNER JOIN FOOD_ORIGIN AS FO " + 
							  		"ON R.FOOD_ORIGIN_ID = FO.FOOD_ORIGIN_ID " +
							  	"INNER JOIN FOOD_TYPE AS FT " +
							  		"ON R.FOOD_TYPE_ID = FT.FOOD_TYPE_ID " +
							  "WHERE R.CHEF_ID = ?";
		return resultSet;
	}
}