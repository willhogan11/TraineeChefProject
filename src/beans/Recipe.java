package beans;
import java.io.InputStream;


//Bean class that contains getters and setters used throughout the project
public class Recipe {
	
	private int recipeId;
	private String recipeName;
	private String description;
	private int prepTimeHours;
	private int prepTimeMins;
	private String ingredients;
	private String directions;
	private String foodType;
	private String foodOrigin;
	private InputStream image;
	private int chefId;
	private int foodTypeId;
	private int foodOriginId;
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public int getChefId() {
		return chefId;
	}
	public void setChefId(int chefId) {
		this.chefId = chefId;
	}
	public int getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	public int getFoodOriginId() {
		return foodOriginId;
	}
	public void setFoodOriginId(int foodOriginId) {
		this.foodOriginId = foodOriginId;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodOrigin() {
		return foodOrigin;
	}
	public void setFoodOrigin(String foodOrigin) {
		this.foodOrigin = foodOrigin;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream sImage) {
		this.image = sImage;
	}
	public int getPrepTimeMins() {
		return prepTimeMins;
	}
	public void setPrepTimeMins(int prepTimeMins) {
		this.prepTimeMins = prepTimeMins;
	}
	public int getPrepTimeHours() {
		return prepTimeHours;
	}
	public void setPrepTimeHours(int prepTimeHours) {
		this.prepTimeHours = prepTimeHours;
	}
}