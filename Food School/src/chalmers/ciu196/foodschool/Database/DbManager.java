package chalmers.ciu196.foodschool.Database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.util.Log;
import chalmers.ciu196.foodschool.Food;
import chalmers.ciu196.foodschool.FoodCategory;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.AndroidSupport;
import com.db4o.config.EmbeddedConfiguration;

public class DbManager {
	
	private static ObjectContainer database = null; // define database as the object container
	private String DATABASE_NAME = "foodschool.db4o"; // define the database's name
	private Context ctx;
	
	public DbManager(Context context){ // Constructor
		ctx = context;
	}
	

	public ObjectContainer database(){ // get instance of db or create one if not exists
		try {
				if (database == null || database.ext().isClosed()) {
					database = Db4oEmbedded.openFile(dbConfig(), db4oDBFullPath(ctx));
					return database;
				}
			} catch (Exception e) {
				Log.e(DbManager.class.getName(), e.toString());
				return null;
			}
		return null;
	}
	

	// Create an instance of the configuration @return
	private EmbeddedConfiguration dbConfig() { 
		EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
		configuration.common().add(new AndroidSupport());
		configuration.idSystem().useSingleBTreeSystem();
        configuration.common().objectClass(Food.class).objectField("name").indexed(true);
        configuration.common().objectClass(Food.class).objectField("foodId").indexed(true);
        configuration.common().objectClass(Food.class).cascadeOnUpdate(true);
        configuration.common().objectClass(Food.class).cascadeOnActivate(true);
        configuration.common().objectClass(FoodCategory.class).objectField("name").indexed(true);
        configuration.common().objectClass(FoodCategory.class).objectField("catId").indexed(true);
        configuration.common().objectClass(FoodCategory.class).cascadeOnUpdate(true);
        configuration.common().objectClass(FoodCategory.class).cascadeOnActivate(true);
        return configuration;
		}
	
	// @param ctx
			// @ return  returns the path of the database
			private String db4oDBFullPath(Context ctx) {
				return ctx.getFilesDir() + "/" + DATABASE_NAME; 
				}

	// close database
	 	public void close() {
	 		if (database != null) {
	 			database.close();
	 		}
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
	    
	    
// END OF DELETE SECTION =========================================================================
	    
// SECTION RELATED TO FoodCategory METHODS

	    // Store a category in the database
	    public void storeFoodCat(FoodCategory category){  
	    	database.store(category);
	    	database.commit();
	    }
	   
	    // Fetch a food category by searching using the name of it
	    public FoodCategory getCategory (String name){  
	    	FoodCategory cat = new FoodCategory();
	    	FoodCategory catOff = new FoodCategory(); // create to eliminate the null pointer exception if method can't find the category we look for
	    	cat.setCatName(name);					  // it returns an empty category object
	    	ObjectSet<FoodCategory> result = database.queryByExample(cat);
	    	if (result.hasNext()){
	    		return (FoodCategory)result.next();
	    	}
			return catOff;
	    }
	    
	    // Fetch a list with all categories
	    public List<FoodCategory> getCatsList(){
	    	ArrayList<FoodCategory> ret = new ArrayList<FoodCategory>();
	    	ObjectSet<FoodCategory> result = getAllCats();
	    	while (result.hasNext()){
	    		ret.add((FoodCategory)result.next());
	    	}
	    	return ret;
	    }
	    
	    
	    // Fetch all categories
	    public ObjectSet<FoodCategory> getAllCats(){
	    	FoodCategory fc = new FoodCategory();
	    	final ObjectSet<FoodCategory> result = database.queryByExample(fc);
	    	return result;
	    }
	  
	    
// END OF SECTION RELATED TO FoodCategory METHODS
	    
// SECTION RELATED TO Food METHODS

	    // Store a food in the database
	    public void storeFood(Food food){  
	    	database.store(food);
	    	database.commit();
	    }
	    
	    // Fetch a food by searching using the name of it
	    public Food getFood (String name){
	    	Food food = new Food();
	    	Food foodOff = new Food(); // create to eliminate the null pointer exception if method can't find the food we look for 
	    	food.setName(name);		   // it returns an empty food object
	    	ObjectSet<Food> result = database.queryByExample(food);
	    	if (result.hasNext()){
	    		return (Food)result.next();
	    	}
			return foodOff;
	    }
	    
	 // Fetch a food by searching using the ID of it
	    public Food getFood (int id){
	    	Food food = new Food();
	    	food.setId(id);
	    	ObjectSet<Food> result = database.queryByExample(food);
	    	if (result.hasNext()){
	    		return (Food)result.next();
	    	}
			return null;
	    }
	    
	    // Fetch a list with all foods
	    public List<Food> getFoodsList(){
	    	ArrayList<Food> ret = new ArrayList<Food>();
	    	ObjectSet<Food> result = getAllFoods();
	    	while (result.hasNext()){
	    		ret.add((Food)result.next());
	    	}
	    	return ret;
	    }
	    
	    // Fetch all foods
	    public ObjectSet<Food> getAllFoods(){
	    	Food fc = new Food();
	    	final ObjectSet<Food> result = database.queryByExample(fc);
	    	return result;
	    }
	    
	    // Fetch a list with foods of a certain category
	    public List<Food> getFoodsListFromCat(String cat){
	    	ArrayList<Food> ret = new ArrayList<Food>();
	    	ObjectSet<Food> result = getAllFoodsFromCat(cat);
	    	while (result.hasNext()){
	    		ret.add((Food)result.next());
	    	}
	    	return ret;
	    }
	    
	    // Fetch all foods of a category
	    public ObjectSet<Food> getAllFoodsFromCat(String cat){
	    	Food fc = new Food();
	    	fc.setCategory(cat);
	    	final ObjectSet<Food> result = database.queryByExample(fc);
	    	return result;
	    }
	    
	    
// END OF SECTION RELATED TO Food METHODS
	
} // End of class
