package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public interface FoodManager {
	
	// Declare methods for manipulation of FoodCategory type objects
	
	public int getCatCount(); // Return number of categories
	public FoodCategory getFoodCatAt(int index); // Returns category in position <index> 
	public ArrayList<String> getFoodCatNames(); // Retrieve a list with the names of the categories
	public void addCategory(FoodCategory fc); // Create a new category (just add it to the list of categories)
	public ArrayList<FoodCategory> getAllCategories(); // Returns the array list with all the different categories

	
	// Declare methods for manipulation of Food type objects
	public void addFoodToCategory(Food food, FoodCategory fc); //add a food to a specific category
	public int getFoodCountFromCat(FoodCategory fc); // Return number of foods from one category
	public int getTotalFoodCount(); //return number of all foods in total
	public Food getFoodFromCategoryAt(FoodCategory fc, int index); // Returns food in position <index> from category
	public ArrayList<Food> getAllFoodsFromCat(FoodCategory fc); //Return all foods from one category
	public ArrayList<String> getAllFoodNames(); // Retrieve a list with the names of the foods
	public ArrayList<String> getAllFoodNamesFromCat(FoodCategory fc); // Retrieve a list with the names of the foods that belong in a certain category
	public ArrayList<Food> getAllFoods(); //return every type of food there is
}
