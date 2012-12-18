package chalmers.ciu196.foodschool;


import java.util.ArrayList;
import chalmers.ciu196.foodschool.Database.DbManager;
import chalmers.ciu196.foodschool.Database.XmlParser;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public ArrayList<Integer> test = new ArrayList<Integer>();
	// Database related variables =============================================
	private DbManager databaseManager;
	// End of Database related variables ======================================
	
	@Override
	protected void onResume(){
		super.onResume();
		stopService(new Intent(this,MediaServiceB.class));
		startService(new Intent(this,MediaServiceA.class));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

	// DATABASE related code ==================================================
	
	dbManager();
	FoodManager foodManager = SimpleFoodManager.getManager();
	
	/* Temporary variables for testing */
	FoodCategory fruits = new FoodCategory("Fruits", "Fruit products", "imgpath", "soundpath", new ArrayList<Food>());
	FoodCategory vegetables = new FoodCategory("Vegetables", "Vegetable products", "", "", new ArrayList<Food>());
	FoodCategory meats = new FoodCategory("Meats", "Meat products", "", "", new ArrayList<Food>());
	FoodCategory dairy = new FoodCategory("Dairy", "Dairy products", "", "", new ArrayList<Food>());
	FoodCategory cereals = new FoodCategory("Cereals", "Cereal products", "", "", new ArrayList<Food>());
	foodManager.addCategory(fruits);
	foodManager.addCategory(vegetables);
	foodManager.addCategory(meats);
	foodManager.addCategory(dairy);
	foodManager.addCategory(cereals);
	
	Food apple = new Food();
	Food orange = new Food();
	Food banana = new Food();
	Food grapes = new Food();
	foodManager.addFoodToCategory(apple, fruits);
	foodManager.addFoodToCategory(orange, fruits);
	foodManager.addFoodToCategory(banana, fruits);
	foodManager.addFoodToCategory(grapes, fruits);
	
	Food tomato = new Food();
	Food cucumber = new Food();
	Food cabbage = new Food();
	Food carrot = new Food();
	foodManager.addFoodToCategory(tomato, vegetables);
	foodManager.addFoodToCategory(cucumber, vegetables);
	foodManager.addFoodToCategory(cabbage, vegetables);
	foodManager.addFoodToCategory(carrot, vegetables);
	
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
	
	/**** SAMPLE FOOD CREATION ****
	 * This is how you create an object
	 * for usage in this application.
	 * Use apple as an example for the
	 * rest of the foods.
	 **** ******************** ****/
	apple.setName("apple");
	apple.setDescription("red fruit"); /* This should have the actual description */
	apple.setId(R.drawable.img_fruits_apple);
	ArrayList<Integer> appleImages = new ArrayList<Integer>();
	appleImages.add(R.drawable.fruits_detail_apple_applebasket);
	appleImages.add(R.drawable.fruits_detail_apple_applejuice);
	appleImages.add(R.drawable.fruits_detail_apple_appletree);
	appleImages.add(R.drawable.fruits_detail_apple_peeledapple);
	apple.setImage_ids(appleImages);
	ArrayList<Integer> appleSounds = new ArrayList<Integer>();
	appleSounds.add(R.raw.apple);
	appleSounds.add(R.raw.description_fruits_apple);
	appleSounds.add(R.raw.quiz_fruits_apple);
	apple.setSound_ids(appleSounds);
	ArrayList<String> cosa=new ArrayList<String>();
	cosa.add("url1");
	cosa.add("url2");	
	apple.setImage_paths(cosa);
	
	ArrayList<Integer> orangeSounds = new ArrayList<Integer>();
	orangeSounds.add(R.raw.orange);
	orangeSounds.add(R.raw.description_fruits_orange);
	orangeSounds.add(R.raw.quiz_fruits_orange);
	orange.setSound_ids(orangeSounds);
	ArrayList<Integer> orangeImages = new ArrayList<Integer>();
	orangeImages.add(R.drawable.fruits_detail_orange_large);
	orangeImages.add(R.drawable.fruits_detail_orange_orangejuice);
	orangeImages.add(R.drawable.fruits_detail_orange_orangetree);
	orangeImages.add(R.drawable.fruits_detail_orange_pressedorange);
	orange.setImage_ids(orangeImages);
	orange.setName("orange");
	orange.setDescription("round fruit");
	orange.setId(R.drawable.img_fruits_orange);
	
	ArrayList<Integer> bananaSounds = new ArrayList<Integer>();
	bananaSounds.add(R.raw.banana);
	bananaSounds.add(R.raw.description_fruits_banana);
	bananaSounds.add(R.raw.quiz_fruits_banana);
	System.out.println("R.raw.banana is "+R.raw.quiz_fruits_banana);
	banana.setSound_ids(bananaSounds);
	banana.setName("banana");
	banana.setDescription("long fruit");
	banana.setId(R.drawable.img_fruits_banana);
	//banana.setSound_paths("path");
	
	ArrayList<Integer> grapesSounds = new ArrayList<Integer>();
	grapesSounds.add(R.raw.grapes);
	grapesSounds.add(R.raw.description_fruits_grapes);
	grapesSounds.add(R.raw.quiz_fruits_grapes);
	grapes.setSound_ids(grapesSounds);
	grapes.setName("grapes");
	grapes.setDescription("little tasties");
	grapes.setId(R.drawable.img_fruits_grapes);
	
	ArrayList<Integer> tomatoSounds = new ArrayList<Integer>();
	tomatoSounds.add(R.raw.tomato);
	tomatoSounds.add(R.raw.description_vegetables_tomato);
	tomatoSounds.add(R.raw.quiz_vegetables_tomato);
	tomato.setSound_ids(tomatoSounds);
	tomato.setName("tomato");
	tomato.setDescription("juicy vegetable");
	tomato.setId(R.drawable.img_vegetables_tomato);
	
	ArrayList<Integer> cucumberSounds = new ArrayList<Integer>();
	cucumberSounds.add(R.raw.cucumber);
	cucumberSounds.add(R.raw.description_vegetables_cucumber);
	cucumberSounds.add(R.raw.quiz_vegetables_cucumber);
	cucumber.setSound_ids(cucumberSounds);
	cucumber.setName("cucumber");
	cucumber.setDescription("long vegetable");
	cucumber.setId(R.drawable.img_vegetables_cucumber);

	ArrayList<Integer> cabbageSounds = new ArrayList<Integer>();
	cabbageSounds.add(R.raw.cabbage);
	cabbageSounds.add(R.raw.description_vegetables_cabbage);
	cabbageSounds.add(R.raw.quiz_vegetables_cabbage);
	cabbage.setSound_ids(cabbageSounds);
	cabbage.setName("cabbage");
	cabbage.setDescription("leafy vegetable");
	cabbage.setId(R.drawable.img_vegetables_cabbage);

	ArrayList<Integer> carrotSounds = new ArrayList<Integer>();
	carrotSounds.add(R.raw.carrot);
	carrotSounds.add(R.raw.description_vegetables_carrot);
	carrotSounds.add(R.raw.quiz_vegetables_carrot);
	carrot.setSound_ids(carrotSounds);
	carrot.setName("carrot");
	carrot.setDescription("long orange vegetable");
	carrot.setId(R.drawable.img_vegetables_carrot);
	
	pork.setName("pork");
	pork.setDescription("red meat");
	pork.setId(31);
	//pork.setSound_paths("path");
	salmon.setName("salmon");
	salmon.setDescription("fish meat");
	salmon.setId(32);
	//salmon.setSound_paths("path");
	chicken.setName("chicken");
	chicken.setDescription("white meat");
	chicken.setId(33);
	//chicken.setSound_paths("path");
	
	gouda.setName("gouda");
	gouda.setDescription("yellow cheese");
	gouda.setId(41);
	//gouda.setSound_paths("path");
	yoghurt.setName("yoghurt");
	yoghurt.setDescription("creamy dairy");
	yoghurt.setId(42);
	//yoghurt.setSound_paths("path");
	milk.setName("milk");
	milk.setDescription("liquid dairy");
	milk.setId(43);
	//milk.setSound_paths("path");
	
	corn.setName("corn");
	corn.setDescription("yellow grain");
	corn.setId(51);
	//corn.setSound_paths("path");
	oats.setName("oats");
	oats.setDescription("flakes grain");
	oats.setId(52);
	//oats.setSound_paths("path");
	bread.setName("bread");
	bread.setDescription("mashed grain");
	corn.setId(53);
	//corn.setSound_paths("path");

	apple.setCategory(fruits.getCatName());
	
	ArrayList<String> imgpaths = new ArrayList<String>();
	imgpaths.add("path1");
	imgpaths.add("path2");
	apple.setImage_paths(imgpaths);
	
	ArrayList<String> qstns = new ArrayList<String>();
	qstns.add("path1");
	qstns.add("path2");
	apple.setQuestions(qstns);
	
	ArrayList<String> answrs = new ArrayList<String>();
	answrs.add("path1");
	answrs.add("path2");
	apple.setAnswers(answrs);
	
	ArrayList<String> sndpaths = new ArrayList<String>();
	sndpaths.add("path1");
	sndpaths.add("path2");
	apple.setSound_paths(sndpaths);
	
	// end of adding values to the apple
	
	// store the objects to the database note that there is a separate method for objects of each class
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
	
	// test object of FoodCategory created to load object from database
	FoodCategory testLoadCat = new FoodCategory();
	testLoadCat = dbManager().getCategory(fruits.getCatName());
	Log.d("Db4o", "Category "+testLoadCat.getCatName()+" was succesfully stored and retrieved from database.");
	
	// test object of Food created to load object from database
	Food testLoadFood = new Food();
	testLoadFood = dbManager().getFood(apple.getName());
	Log.d("Db4o", "Food "+testLoadFood.getName()+" was successfully stored and retrieved from database.");
	// End of database related code ===========================================
	
	
	//XmlParser uf=new XmlParser();
	//CategoryCollection nene=new CategoryCollection();
	//nene=uf.categoryfromXML(R.raw.data, this);
	//Log.d("SOCOOOORRO",String.valueOf(nene.getList().get(0).getFoodsContained().get(0).getId()));
	//Log.d("SOCOOOORRO2",String.valueOf(R.drawable.img_cereals_bread));
	
	
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		stopService(new Intent(this,MediaServiceA.class));
	}
	
	// Database related variables =============================================

    //Close database before exiting the application
	
	@Override
	protected void onPause() {
         super.onPause();
         dbManager().close();
         databaseManager = null;
         stopService(new Intent(this,MediaServiceA.class));
     }
	
	@Override
	protected void onStop()
	{
		super.onStop();
		stopService(new Intent(this,MediaServiceA.class));
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
