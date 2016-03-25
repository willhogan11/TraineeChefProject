package beans;

// Recipe Bean Class
public class Recipe {
	
	private int recipeId;
	private String name;
	private String description;
	private int prepTime;
	private String ingredients;
	private String directions;
	private int chefId;
	private int foodTypeId;
	private int foodOriginId;
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
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
	
}