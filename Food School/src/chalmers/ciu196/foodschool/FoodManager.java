package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public interface FoodManager {
	
	// PROBABLY NOT ALL THE METHODS WE NEED. NEEDS DISCUSSION BY THE GROUP
	
	// Declare methods for manipulation of FoodCategory type objects
	
	public int countCat(); // Return number of categories
	public FoodCategory getFoodCat(int index); // Returns category in position <index> 
	public String[] getAllFoodCats(); // Retrieve a list with the names of the categories
	public FoodCategory createCategory(); // Create a new category
	public ArrayList<FoodCategory> getAllCats(); // Returns the array list with all the different categories

	
	// Declare methods for manipulation of Food type objects
	public int countFoodInCat(); // Return number of foods per category
	public Food getFood(int index); // Returns food in position <index>
	public String[] getAllFoods(); // Retrieve a list with the names of the foods
	public String[] getAllFoodsInCat(String catName); // Retrieve a list with the names of the foods that belong in a certain category
	public Food createFood(); // Create a new food
	

}
