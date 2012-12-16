package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import android.content.Context;

import chalmers.ciu196.foodschool.Database.XmlParser;


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
	
	/* Array list that contains every food */
	public static ArrayList<Food> FoodCollection = new ArrayList<Food>();
	/* Array list that contains all the categories */
	public static ArrayList<FoodCategory> FoodCategoryCollection = new ArrayList<FoodCategory>();
	
	/* Array list that contains every food */
	public static ArrayList<Food> FoodCollectionB = new ArrayList<Food>();
	/* Array list that contains all the categories */
	public static ArrayList<FoodCategory> FoodCategoryCollectionB = new ArrayList<FoodCategory>();
	
	/* Private constructor to ensure 
	 * no multiple instances of the class are created
	 */
	private SimpleFoodManager()
	{
	}
	
	/*public void initialize(Context cont){
		XmlParser ains=new XmlParser();
		CategoryCollection test=ains.categoryfromXML(R.raw.data, cont);
		FoodCategoryCollectionB=test.getList();
		for (int i=0;i<FoodCategoryCollectionB.size();i++){
			for (int y=0;y<FoodCategoryCollectionB.get(i).getFoodsContained().size();y++){
				FoodCollectionB.add(FoodCategoryCollectionB.get(i).getFoodsContained().get(y));
			}
		}
		
	}*/
	
	/* Return number of categories */
	public int getCatCount() { 
		return FoodCategoryCollection.size();
	}

	/* Get the category at position <index> */
	public FoodCategory getFoodCatAt(int index) {
		return FoodCategoryCollection.get(index);
	}

	/* Get the name of every food category */
	public ArrayList<String> getFoodCatNames() {
		ArrayList<String> CategoryNames = new ArrayList<String>();
		for (int i = 0; i < FoodCategoryCollection.size(); i++)
		{
			CategoryNames.add(i, FoodCategoryCollection.get(i).getCatName());
		}
		return CategoryNames;
	}

	/* Add the category to the collection */
	public void addCategory(FoodCategory fc) {
		FoodCategoryCollection.add(fc);
	}

	/* Get all the food categories */
	public ArrayList<FoodCategory> getAllCategories() {
		return FoodCategoryCollection;
	}

	/* Get the number of foods in a category */
	public int getFoodCountFromCat(FoodCategory fc) {
		return fc.getFoodsContained().size();
	}

	/* Add a food to a category, and also to the collection of all foods */
	public void addFoodToCategory(Food food, FoodCategory fc) {
		FoodCollection.add(food);
		fc.getFoodsContained().add(food);
	}

	/* Get the total number of foods */
	public int getTotalFoodCount() {
		return FoodCollection.size();
	}

	/* Get food from position <index> in category <fc> */
	public Food getFoodFromCategoryAt(FoodCategory fc, int index) {
		return fc.getFoodsContained().get(index);
	}

	/* Get all the foods from category <fc> */
	public ArrayList<Food> getAllFoodsFromCat(FoodCategory fc) {
		return fc.getFoodsContained();
	}

	/* Get all food names */
	public ArrayList<String> getAllFoodNames() {
		ArrayList<String> allFoodNames = new ArrayList<String>();
		for (int i = 0; i < FoodCollection.size(); i++)
		{
			allFoodNames.add(FoodCollection.get(i).getName());
		}
		return allFoodNames;
	}

	/* Get all food names from category <fc> */
	public ArrayList<String> getAllFoodNamesFromCat(FoodCategory fc) {
		ArrayList<String> categoryFoodNames = new ArrayList<String>();
		for (int i = 0; i < fc.getFoodsContained().size(); i++)
		{
			categoryFoodNames.add(fc.getFoodsContained().get(i).getName());
		}
		return categoryFoodNames;
	}

	/* Get all the foods that exist */
	public ArrayList<Food> getAllFoods() {
		return FoodCollection;
	}

}
