package chalmers.ciu196.foodschool.Database;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.util.Log;

import chalmers.ciu196.foodschool.Food;
import chalmers.ciu196.foodschool.FoodCategory;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;


public class DbManager {
	
	private ObjectContainer database = null; // define database as the object container
	private String DATABASE_NAME = "FoodSchool.db4o"; // define the database's name
	private Context ctx;
	
	public DbManager(Context context){ // Constructor
		
		ctx = context;
	}
	
	@SuppressWarnings("unused")
	private ObjectContainer database(){
		try {
				if (database == null || database.ext().isClosed()) {  
					database = Db4oEmbedded.openFile(config(),db4oDBFullPath(ctx));
					
					return database;
				}
			} catch (Exception e) {
				Log.e(DbManager.class.getName(), e.toString());
				return null;
			}
		return null;
	}

	// Create an instance of the configuration @return
	private EmbeddedConfiguration config() { 
		EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
		return configuration;
		}
	
	// @param ctx
	// @ return  returns the path of the database
	private String db4oDBFullPath(Context ctx) {
		return ctx.getDir("data", 0) + "/" + DATABASE_NAME;
		}
	
	// Save a food and create an id for it
    public void saveFood(Food food) {
    	if(food.getId() == 0){
    		food.setId(getNextId());
    		database().store(food);
	    	database().commit();
    	}
    }
    
    // Save a category and create an id for it
    public int saveCategory (FoodCategory category){
    	
    	if(category.getCatId() == 0)
    		category.setCatId(getNextId());
    	database().store(category);
	    database().commit();
	    return category.getCatId();
    	
    }
    
    // Fetch a foods by Id using bd4o's Query By Example (QBE)
    private ObjectSet<Food> fetchFoodsById(int Id) {
    	Food food = new Food();
    	food.setId(Id);
    	return database().queryByExample(food);
    }
    
    // Check how many food are stored in the database
    public int countFoods(int Id){
    	ObjectSet<Food> foods = fetchFoodsById(Id);
    	return foods == null ? 0 : foods.size();
    }
	
    // Fetch food categories by Id using db4o's Query By Example (QBE)
    private ObjectSet<FoodCategory> fetchCategoriesById(int Id) {
    	FoodCategory foodCat = new FoodCategory();
    	foodCat.setCatId(Id);
    	return database().queryByExample(foodCat);
    }
    
    // Fetch all the categories
    public List<FoodCategory> fetchAllCategories(){
    	return database().query(FoodCategory.class);
    }
    
    // Commit changes to database
    public void commit(){
    	database().commit();
    }
    
    // Roll-back changes
    public void rollback(){
    	database().rollback();
    }
    
    // Fetch Category by Id using db4o's Query By Example (QBE)
    public FoodCategory fetchCategoryById(int Id) {
    	ObjectSet<FoodCategory> result = fetchCategoriesById(Id);
        if (result.hasNext())
        	return (FoodCategory)result.next();
        else
        	return null;
    }
    
    // Fetch a category by name using db4o's Query By Example (QBE)
    public FoodCategory fetchCategoryByName(String name){ // Get a food using the name of it
		FoodCategory categoryToSearch = new FoodCategory();
		categoryToSearch.setName(name);
		
		try {
			   FoodCategory result = (FoodCategory) getDatabase().queryByExample(categoryToSearch);
			   return result;
			} finally {
				getDatabase().close();
			}
	}
    
   // Returns list with all foods
    public List<Food> fetchAllFoods(){
    	return database().query(Food.class);
    }
    
    // Returns foods of a single category
    public List<Food> fetchFoodOfCategory(final FoodCategory category){
    	List<Food> result = database().query(new Predicate<Food>(){
    		
			private static final long serialVersionUID = 1L;

			public boolean match(Food food){
    			if (food.getCategory().equals(category)){
    				return true;
    			}
    			return false;
    		}
    	});
    	return result;
    }
    
    // Returns a food by Id using db4o's Query By Example (QBE)
    public Food fetchFoodById(int Id) {
        ObjectSet<Food> food = fetchFoodsById(Id);
        if (food.hasNext())
        	return (Food)food.next();
        else
        	return null;
    }
    
    // Fetch a food by name using db4o's Query By Example (QBE)
    public Food fetchFoodByName(String name){ // Get a food using the name of it
		Food foodToSearch = new Food();
		foodToSearch.setName(name);
		
		try {
			   Food result = (Food) getDatabase().queryByExample(foodToSearch);
			   return result;
			} finally {
				getDatabase().close();
			}
	}
    
    // Check how many foods are stored
    public int foodCount(){
    	List<Food> foods = fetchAllFoods();
    	return foods == null ? 0: foods.size();
    }
    
    // Retrieve the next id
    public int getNextId() {
		ObjectSet<IncrementId> result = database().queryByExample(IncrementId.class);
		IncrementId ii = null;
		int nextId;
		if(result.hasNext()){
			ii = (IncrementId)result.next();
		}
		else{
			ii = new IncrementId();	
		}
		nextId = ii.getNextID();
		database().store(ii);
		return nextId;
	}
    
 // close database
 	public void close() {
 		if (database != null) {
 			database.close();
 			database = null;
 		}
 	}
 	
 	// @return returns the database
 	public ObjectContainer getDatabase() {
 		return this.database;
 	}
    
 	// Backup database
 	public void backup(String path){
    	database().ext().backup(path);
    }
 	
 	// Restore database
 	public void restore(String path){
    	deleteDatabase();
    	new File(path).renameTo(new File(db4oDBFullPath(ctx)));
    	new File(path).delete();
    }
    
    // DELETE FUNCTIONS CREATED FOR FUTURE USE ========================================================
    // DO NOT TRY TO DELETE STUFF IF NOT SURE =========================================================
    
    
    // Delete database
    public void deleteDatabase(){
    	close();
    	new File(db4oDBFullPath(ctx)).delete();
    }
    
   // Delete a food using the id
    public void deleteFood(int Id) {
        //Search by Id
    	ObjectSet<Food> result = (ObjectSet<Food>) fetchFoodById(Id);
        //Delete object
    	while(result.hasNext())
    		database().delete((Food)result.next());
    	database().commit();
    }
    
   // Delete a food category
    public void deleteCategory(int Id) {
        //Search by Id
    	ObjectSet<FoodCategory> result = fetchCategoriesById(Id);
        //Delete object
    	while(result.hasNext())
    		database().delete((FoodCategory)result.next());
    	database().commit();
    }
    
    // END OF DELETE SECTION =========================================================================
 
	
} // End of class
