package beans;

//Bean class that contains getters and setters used throughout the project
public class FoodOrigin {
	
	private int foodOriginid;
	private String origin;
	
	public int getFoodOriginid() {
		return foodOriginid;
	}
	public void setFoodOriginid(int foodOriginid) {
		this.foodOriginid = foodOriginid;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
}