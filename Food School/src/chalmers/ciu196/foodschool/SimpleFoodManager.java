package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public class SimpleFoodManager implements FoodManager {
	
	// This should be a singleton in order to avoid multiple instances
	private static SimpleFoodManager manager;
	
	// Method to retrieve the instance of the class
		public static synchronized SimpleFoodManager getManager()
		{
			if (manager == null)
			{
				manager = new SimpleFoodManager();
			}
			return manager;
		}
	
	public static ArrayList<Food> FoodCollection = new ArrayList<Food>();
	public static ArrayList<FoodCategory> FoodCategoryCollection = new ArrayList<FoodCategory>();
	
	
	
	
	// private constructor to ensure no multiple instances of the class are created
		private SimpleFoodManager()
		{	
			// create the Food Categories 
			
			// add the categories to the category collection
			
			
			// create the Foods 
			
			
			// add the foods to the category collection
			
		
		}

		
		
		
	public int countCat() { // Return number of categories
		// TODO Auto-generated method stub
		return 0;
	}

	public FoodCategory getFoodCat(int index) { // Returns category in position <index>
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getAllFoodCats() { // Retrieve a list with the names of the categories
		// TODO Auto-generated method stub
		return null;
	}

	public FoodCategory createCategory() { // Create a new category
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<FoodCategory> getAllCats() { // Returns the array list with all the different categories
		// TODO Auto-generated method stub
		return null;
	}

	public int countFoodInCat() { // Return number of foods per category
		// TODO Auto-generated method stub
		return 0;
	}

	public Food getFood(int index) { // Returns food in position <index>
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getAllFoods() { // Retrieve a list with the names of the foods
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getAllFoodsInCat(String catName) { // Retrieve a list with the names of the foods that belong in a certain category
		// TODO Auto-generated method stub
		return null;
	}

	public Food createFood() { // Create a new food
		// TODO Auto-generated method stub
		return null;
	}

}
