package chalmers.ciu196.foodschool;

import chalmers.ciu196.foodschool.Database.DbManager;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private MediaPlayer mediaPlayer;
	
	// Database related variables =============================================
	private DbManager databaseManager;
	// End of Database related variables ======================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	// DATABASE related code ==================================================
	
	dbManager();
	FoodManager foodManager = SimpleFoodManager.getManager();
	
	/* Temporary variables for testing */
	FoodCategory fruits = new FoodCategory("Fruits", "Fruit products", "imgpath", "soundpath", 1);
	FoodCategory vegetables = new FoodCategory("Vegetables", "Vegetable products", "", "", 2);
	FoodCategory meats = new FoodCategory("Meats", "Meat products", "", "", 3);
	FoodCategory dairy = new FoodCategory("Dairy", "Dairy products", "", "", 4);
	FoodCategory cereals = new FoodCategory("Cereals", "Cereal products", "", "", 5);
	foodManager.addCategory(fruits);
	foodManager.addCategory(vegetables);
	foodManager.addCategory(meats);
	foodManager.addCategory(dairy);
	foodManager.addCategory(cereals);
	
	Food apple = new Food();
	Food orange = new Food();
	Food banana = new Food();
	foodManager.addFoodToCategory(apple, fruits);
	foodManager.addFoodToCategory(orange, fruits);
	foodManager.addFoodToCategory(banana, fruits);
	
	Food tomato = new Food();
	Food cucumber = new Food();
	Food cabbage = new Food();
	foodManager.addFoodToCategory(tomato, vegetables);
	foodManager.addFoodToCategory(cucumber, vegetables);
	foodManager.addFoodToCategory(cabbage, vegetables);
	
	Food pork = new Food();
	Food salmon = new Food();
	Food chicken = new Food();
	foodManager.addFoodToCategory(pork, meats);
	foodManager.addFoodToCategory(salmon, meats);
	foodManager.addFoodToCategory(chicken, meats);
	
	Food gouda = new Food();
	Food yoghurt = new Food();
	Food milk = new Food();
	foodManager.addFoodToCategory(gouda, dairy);
	foodManager.addFoodToCategory(yoghurt, dairy);
	foodManager.addFoodToCategory(milk, dairy);
	
	Food corn = new Food();
	Food oats = new Food();
	Food bread = new Food();
	foodManager.addFoodToCategory(corn, cereals);
	foodManager.addFoodToCategory(oats, cereals);
	foodManager.addFoodToCategory(bread, cereals);
	
	apple.setName("apple");
	apple.setDescription("rea fruit");
	apple.setId(11);
	apple.setSound_path("path");
	orange.setName("orange");
	orange.setDescription("round fruit");
	apple.setId(12);
	orange.setSound_path("path");
	banana.setName("banana");
	banana.setDescription("long fruit");
	banana.setId(13);
	banana.setSound_path("path");
	
	tomato.setName("tomato");
	tomato.setDescription("juicy vegetable");
	tomato.setId(21);
	tomato.setSound_path("path");
	cucumber.setName("cucumber");
	cucumber.setDescription("long vegetable");
	cucumber.setId(22);
	cucumber.setSound_path("path");
	cabbage.setName("cabbage");
	cabbage.setDescription("leafy vegetable");
	cabbage.setId(23);
	cabbage.setSound_path("path");
	
	pork.setName("pork");
	pork.setDescription("red meat");
	pork.setId(31);
	pork.setSound_path("path");
	salmon.setName("salmon");
	salmon.setDescription("fish meat");
	salmon.setId(32);
	salmon.setSound_path("path");
	chicken.setName("chicken");
	chicken.setDescription("white meat");
	chicken.setId(33);
	chicken.setSound_path("path");
	
	gouda.setName("gouda");
	gouda.setDescription("yellow cheese");
	gouda.setId(41);
	gouda.setSound_path("path");
	yoghurt.setName("yoghurt");
	yoghurt.setDescription("creamy dairy");
	yoghurt.setId(42);
	yoghurt.setSound_path("path");
	milk.setName("milk");
	milk.setDescription("liquid dairy");
	milk.setId(43);
	milk.setSound_path("path");
	
	corn.setName("corn");
	corn.setDescription("yellow grain");
	corn.setId(51);
	corn.setSound_path("path");
	oats.setName("oats");
	oats.setDescription("flakes grain");
	oats.setId(52);
	oats.setSound_path("path");
	bread.setName("bread");
	bread.setDescription("mashed grain");
	corn.setId(53);
	corn.setSound_path("path");
	
	dbManager().storeFoodCat(fruits);
	dbManager().storeFoodCat(vegetables);
	dbManager().storeFoodCat(meats);
	dbManager().storeFoodCat(dairy);
	dbManager().storeFoodCat(cereals);
	
	dbManager().storeFood(apple);
	dbManager().storeFood(orange);
	dbManager().storeFood(banana);
	
	dbManager().storeFood(tomato);
	dbManager().storeFood(cucumber);
	dbManager().storeFood(cabbage);
	
	dbManager().storeFood(gouda);
	dbManager().storeFood(yoghurt);
	dbManager().storeFood(milk);
	
	dbManager().storeFood(pork);
	dbManager().storeFood(salmon);
	dbManager().storeFood(chicken);
	
	dbManager().storeFood(corn);
	dbManager().storeFood(oats);
	dbManager().storeFood(bread);
	
	System.out.println(foodManager.getFoodCatNames());
	System.out.println(foodManager.getAllFoodNames());
	System.out.println(foodManager.getFoodCountFromCat(vegetables));
	
	FoodCategory testLoadCat = new FoodCategory();
	testLoadCat = dbManager().getCategory(fruits.getCatName());
	Log.d("Db4o", "Category "+testLoadCat.getCatName()+" was succesfully stored and retrieved from database.");
	
	Food testLoadFood = new Food();
	testLoadFood = dbManager().getFood(apple.getName());
	Log.d("Db4o", "Food "+testLoadFood.getName()+" was successfully stored and retrieved from database.");
	// End of database related code ===========================================

	}
	
	// DATABASE related code ==================================================
	private DbManager dbManager() {
		if (databaseManager == null) {
			databaseManager = new DbManager(this);
			databaseManager.database();
		}
		return databaseManager;
	}
	// End of database related code ===========================================
	
	@Override
	protected void onResume(){
		super.onResume();
		mediaPlayer= MediaPlayer.create(this, R.raw.foodschoolbso1);

		Log.d("COsa","COsa");
		/* Start playing music when this activity starts. */
		mediaPlayer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		/* Stop playing music when this activity stops. */
		mediaPlayer.stop();
	}
	
	// Database related variables =============================================

    //Close database before exiting the application
	
	@Override
	protected void onPause() {
         super.onDestroy();
         dbManager().close();
         databaseManager = null;
     }
	
	// End of Database related variables ======================================

	/* Learn button click listener, takes you to the food
	 * categories, which displays the grid with all the food
	 * types.
	 */
	public void startLearnActivity(View v)
	{
		
		Intent startLearn = new Intent(this, LearnCategoriesActivity.class);
		startLearn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startLearn);
		//finish();
	}
	
	/* Play button click listener, takes you to the food
	 * categories, which displays the grid with all the food
	 * types.
	 */
	public void startPlayActivity(View v)
	{
		Intent startPlay = new Intent(this, PlayCategoriesActivity.class);
		startPlay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startPlay);
		//finish();
	}
}
