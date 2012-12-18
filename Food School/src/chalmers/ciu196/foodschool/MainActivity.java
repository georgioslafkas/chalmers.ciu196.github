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
	
	// Database related variables =============================================
	private DbManager databaseManager;
	// End of Database related variables ======================================
	
	@Override
	protected void onResume(){
		super.onResume();
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
	
	/**** SAMPLE FOOD CREATION ****
	 * This is how you create an object
	 * for usage in this application.
	 * Use apple as an example for the
	 * rest of the foods.
	 **** ******************** ****/
	Food auxfood=new Food();
	
	//--------------CEREALS-------------------
	auxfood.setName("bread");
	auxfood.setDescription("Bread is prepared by cooking a dough of flour and other ingredients. There are hundreds of types of bread made from different types of flours and with different ingredients. The nutritional content varies depending on the ingredients used.");
	auxfood.setId(R.drawable.img_cereals_bread);
	ArrayList<Integer> auximageids = new ArrayList<Integer>();
	auximageids.add(R.drawable.cereals_detail_bread_large);
	auximageids.add(R.drawable.cereals_detail_bread_braidedbread);
	auximageids.add(R.drawable.cereals_detail_bread_sandwich);
	auximageids.add(R.drawable.cereals_detail_bread_slicedbread);
	auxfood.setImage_ids(auximageids);
	ArrayList<Integer> auxsoundids = new ArrayList<Integer>();
	auxsoundids.add(R.raw.bread);
	auxsoundids.add(R.raw.description_cereals_bread);
	auxsoundids.add(R.raw.quiz_cereals_bread);
	auxfood.setSound_ids(auxsoundids);
	ArrayList<String> auxquestions=new ArrayList<String>();
	auxquestions.add("This cereal product is made from flour and other ingredients. There are hundreds of types made from different kinds of flour");
	auxfood.setQuestions(auxquestions);
	ArrayList<String> auxanswers=new ArrayList<String>();
	auxanswers.add("That's right, it is bread!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	auxfood.setName("maize");
	auxfood.setDescription("Maize (also known as corn) is one of the world's major cereal crops and it is used as flour to make bread, breadkfast cereal, popcorn and a variety of meals. Sweet maize is grown and sold as a vegetable. It is a great source of dietary fibre and contains vitamin C, niacin, folate and potassium, which helps balancing the body's fluids.");
	auxfood.setId(R.drawable.img_cereals_corn);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_corn);
	auximageids.add(R.drawable.cereals_detail_corn_large);
	auximageids.add(R.drawable.cereals_detail_corn_corngrains);
	auximageids.add(R.drawable.cereals_detail_corn_cornplant);
	auximageids.add(R.drawable.cereals_detail_corn_popcorn);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.maize);
	auxsoundids.add(R.raw.description_cereals_maize);
	auxsoundids.add(R.raw.quiz_cereals_maize);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal crop is used as flour to make bread, breakfast cereal, popcorn and a variety of meals. It also grown as sweet corn to be sold as a vegetable. It contains dietary fibre, vitamin C and potassium, among others");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is maize!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	auxfood.setName("pasta");
	auxfood.setDescription("Pasta comes in many shapes and it is usually made from wheat flour. Pasta contains complex carbohydrates which release energy slowly compared to sugar, providing energy for a longer time. It is also a source of iron and vitamin B.");
	auxfood.setId(R.drawable.img_cereals_pasta);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_pasta);
	auximageids.add(R.drawable.cereals_detail_pasta_large);
	auximageids.add(R.drawable.cereals_detail_pasta_lasagna);
	auximageids.add(R.drawable.cereals_detail_pasta_ravioli);
	auximageids.add(R.drawable.cereals_detail_pasta_spaghetti);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.pasta);
	auxsoundids.add(R.raw.description_cereals_pasta);
	auxsoundids.add(R.raw.quiz_cereals_pasta);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal product is usually made from wheat flour and can be found in many shapes. It provides you with energy for a long time because of its complex carbohydrates.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is pasta!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	auxfood.setName("maize");
	auxfood.setDescription("Maize (also known as corn) is one of the world's major cereal crops and it is used as flour to make bread, breadkfast cereal, popcorn and a variety of meals. Sweet maize is grown and sold as a vegetable. It is a great source of dietary fibre and contains vitamin C, niacin, folate and potassium, which helps balancing the body's fluids.");
	auxfood.setId(R.drawable.img_cereals_corn);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_corn);
	auximageids.add(R.drawable.cereals_detail_corn_large);
	auximageids.add(R.drawable.cereals_detail_corn_corngrains);
	auximageids.add(R.drawable.cereals_detail_corn_cornplant);
	auximageids.add(R.drawable.cereals_detail_corn_popcorn);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.maize);
	auxsoundids.add(R.raw.description_cereals_maize);
	auxsoundids.add(R.raw.quiz_cereals_maize);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal crop is used as flour to make bread, breakfast cereal, popcorn and a variety of meals. It also grown as sweet corn to be sold as a vegetable. It contains dietary fibre, vitamin C and potassium, among others");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is maize!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	auxfood.setName("rice");
	auxfood.setDescription("Rice is an excellent source of energy. In fact, it is the main source of energy for a lot of countries around the world. It is packed with itamins andminerals like itamin E, B and potassium. It is also low in fat.");
	auxfood.setId(R.drawable.img_cereals_rice);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_rice);
	auximageids.add(R.drawable.cereals_detail_rice_large);
	auximageids.add(R.drawable.cereals_detail_rice_ricebag);
	auximageids.add(R.drawable.cereals_detail_rice_riceplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.rice);
	auxsoundids.add(R.raw.description_cereals_rice);
	auxsoundids.add(R.raw.quiz_cereals_rice);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal crop is the main source of energy for a lot of countries around the world. It is packed with vitamins and minerals, and it is also low in fat.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is rice!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);

	auxfood.setName("maize");
	auxfood.setDescription("Maize (also known as corn) is one of the world's major cereal crops and it is used as flour to make bread, breadkfast cereal, popcorn and a variety of meals. Sweet maize is grown and sold as a vegetable. It is a great source of dietary fibre and contains vitamin C, niacin, folate and potassium, which helps balancing the body's fluids.");
	auxfood.setId(R.drawable.img_cereals_corn);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_corn);
	auximageids.add(R.drawable.cereals_detail_corn_large);
	auximageids.add(R.drawable.cereals_detail_corn_corngrains);
	auximageids.add(R.drawable.cereals_detail_corn_cornplant);
	auximageids.add(R.drawable.cereals_detail_corn_popcorn);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.maize);
	auxsoundids.add(R.raw.description_cereals_maize);
	auxsoundids.add(R.raw.quiz_cereals_maize);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal crop is used as flour to make bread, breakfast cereal, popcorn and a variety of meals. It also grown as sweet corn to be sold as a vegetable. It contains dietary fibre, vitamin C and potassium, among others");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is maize!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	auxfood.setName("wheat");
	auxfood.setDescription("Wheat is the leading source of vegetable protein in human food. It has a valuable content of protein. It contains iron which is an important component of blood. It is mostly used to make flour for a variety of food products like bread, cereal and pasta.");
	auxfood.setId(R.drawable.img_cereals_wheat);
	auximageids.clear();
	auximageids.add(R.drawable.img_cereals_wheat);
	auximageids.add(R.drawable.cereals_detail_wheat_large);
	auximageids.add(R.drawable.cereals_detail_wheat_wheatbread);
	auximageids.add(R.drawable.cereals_detail_wheat_flour);
	auximageids.add(R.drawable.cereals_detail_wheat_wheatplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.wheat);
	auxsoundids.add(R.raw.description_cereals_wheat);
	auxsoundids.add(R.raw.quiz_cereals_wheat);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This cereal crop is the leading source of vegetable protein in human food. It contains iron, which is an important component of blood. It is used to make flour for a variety of products like bread and pasta.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is wheat!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, cereals);
	
	//--------------DAIRY-------------------
	auxfood.setName("butter");
	auxfood.setDescription("Butter contains 'good' fat. It is used as a spread and for cooking and baking. It is rich in vitamin A, which helps your eyes, bones and skin. It also contains vitamin E, K and D. Vitamin D is essential in the absorption of calcium. It is a good source of iodine, which helps regulate the hormonesin the body.");
	auxfood.setId(R.drawable.img_dairy_butter);
	auximageids.clear();
	auximageids.add(R.drawable.img_dairy_butter);
	auximageids.add(R.drawable.dairy_detail_butter_large);
	auximageids.add(R.drawable.dairy_detail_butter_breadbutter);
	auximageids.add(R.drawable.dairy_detail_butter_cake);
	auximageids.add(R.drawable.dairy_detail_butter_croissant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.butter);
	auxsoundids.add(R.raw.description_dairy_butter);
	auxsoundids.add(R.raw.quiz_dairy_butter);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This dairy product is a 'good' fat source that is used as a spread and for food preparation. Its vitamins help your eyes, bones and skin.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is butter!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, dairy);
	
	auxfood.setName("cheese");
	auxfood.setDescription("There are hundreds of types of cheese made from milk from different animals, not only cows' milk. Cheese is valued for its portability, long life, and high content of fat, protein, calcium, and phosphorus. Calcium makes it good for your teeth and bones.");
	auxfood.setId(R.drawable.img_dairy_cheese);
	auximageids.clear();
	auximageids.add(R.drawable.img_dairy_cheese);
	auximageids.add(R.drawable.dairy_detail_cheese_large);
	auximageids.add(R.drawable.dairy_detail_cheese_cheeseblock);
	auximageids.add(R.drawable.dairy_detail_cheese_cheeseslice);
	auximageids.add(R.drawable.dairy_detail_cheese_sandwich);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.cheese);
	auxsoundids.add(R.raw.description_dairy_cheese);
	auxsoundids.add(R.raw.quiz_dairy_cheese);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("There are hundreds of types of this dairy product, coming from different animals. Its high content of calcium means that it is good for your teeth and bones.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Good job, it is cheese!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, dairy);
	
	auxfood.setName("milk");
	auxfood.setDescription("Milk is the base of all dairy products. It is collected from many kinds of livestock, for example cattle, goats and sheep. It is a gread source of calcium, which helps keep your bones and teeth strong. It is also a good source of protein.");
	auxfood.setId(R.drawable.img_dairy_milk);
	auximageids.clear();
	auximageids.add(R.drawable.img_dairy_milk);
	auximageids.add(R.drawable.dairy_detail_milk_large);
	auximageids.add(R.drawable.dairy_detail_milk_cereal);
	auximageids.add(R.drawable.dairy_detail_milk_cow);
	auximageids.add(R.drawable.dairy_detail_milk_icecream);
	auximageids.add(R.drawable.dairy_detail_milk_milkcarton);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.milk);
	auxsoundids.add(R.raw.description_dairy_milk);
	auxsoundids.add(R.raw.quiz_dairy_milk);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This white liquid is the base for all dairy products. It is collected from many kinds of livestock, and it is a great source of calcium, keeping your bones and teeth strong.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("You are really good, it is milk!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, dairy);
	
	auxfood.setName("yogurt");
	auxfood.setDescription("Yogurt is made from milk using 'good' bacteria. It is a good regulator of the functions of your digestive system. It is rich in calcium, which helps keep your bones and teeth strong and healthy.");
	auxfood.setId(R.drawable.img_dairy_yogurt);
	auximageids.clear();
	auximageids.add(R.drawable.img_dairy_yogurt);
	auximageids.add(R.drawable.dairy_detail_yogurt_large);
	auximageids.add(R.drawable.dairy_detail_yogurt_frozenyogurt);
	auximageids.add(R.drawable.dairy_detail_yogurt_yogurtpack);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.yogurt);
	auxsoundids.add(R.raw.description_dairy_yogurt);
	auxsoundids.add(R.raw.quiz_dairy_yogurt);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This dairty product is made from milk and using 'good' bacteria. It is good fro your digestive system, your bones and your teeth.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is yogurt!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, dairy);
	
	//--------------FRUITS-------------------
	auxfood.setName("apple");
	auxfood.setDescription("Apples are sweet, delicious, and good for you. They contain vitamin C, which helps keep your immune system strong. They also protect your heart, brain, lungs and other vital organs.");
	auxfood.setId(R.drawable.img_fruits_apple);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_apple);
	auximageids.add(R.drawable.fruits_detail_apple_large);
	auximageids.add(R.drawable.fruits_detail_apple_applebasket);
	auximageids.add(R.drawable.fruits_detail_apple_applejuice);
	auximageids.add(R.drawable.fruits_detail_apple_appletree);
	auximageids.add(R.drawable.fruits_detail_apple_peeledapple);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.apple);
	auxsoundids.add(R.raw.description_fruits_apple);
	auxsoundids.add(R.raw.quiz_fruits_apple);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This sweet fruit helps keep your immune system strong, and protect your heart, brain, lungs and other vital organs.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is apple!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("banana");
	auxfood.setDescription("Bananas are a great snack. They are high in natural sugar and fibre, and they keep you full for a long time. They have a lot of potassium, which helps keep your heart, nervous system and kidneys healthy.");
	auxfood.setId(R.drawable.img_fruits_banana);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_banana);
	auximageids.add(R.drawable.fruits_detail_banana_large);
	auximageids.add(R.drawable.fruits_detail_banana_bananasplit);
	auximageids.add(R.drawable.fruits_detail_banana_bananatree);
	auximageids.add(R.drawable.fruits_detail_banana_peeledbanana);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.banana);
	auxsoundids.add(R.raw.description_fruits_banana);
	auxsoundids.add(R.raw.quiz_fruits_banana);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This sugary fruit is a great snack because it keeps you full for a long time. Thanks to potassium, it helps keep your heart, brain and kidneys healthy.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is banana!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("cherries");
	auxfood.setDescription("Cherries are small fruits that contain antioxidants, which are good for the body in many different ways. They can help reduce headaches, iprove your sleep and prevent cancer.");
	auxfood.setId(R.drawable.img_fruits_cherry);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_cherry);
	auximageids.add(R.drawable.fruits_detail_cherry_large);
	auximageids.add(R.drawable.fruits_detail_cherry_cannedcherries);
	auximageids.add(R.drawable.fruits_detail_cherry_cherrydrink);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.cherry);
	auxsoundids.add(R.raw.description_fruits_cherries);
	auxsoundids.add(R.raw.quiz_fruits_cherries);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("These small fruits contain antioxidants that can help your body reduce headaches, improve your sleep and prevent cancer.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is cherries!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("grapes");
	auxfood.setDescription("Grapes are sweet, juicy and packed with essential vitamins and minerals. They provide dietary fibre, vitamin C and potassium. The energy you get from grapes lasts longer because it is slowly digested.");
	auxfood.setId(R.drawable.img_fruits_grapes);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_grapes);
	auximageids.add(R.drawable.fruits_detail_grapes_large);
	auximageids.add(R.drawable.fruits_detail_grapes_grapejuice);
	auximageids.add(R.drawable.fruits_detail_grapes_raisins);
	auximageids.add(R.drawable.fruits_detail_grapes_wine);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.grapes);
	auxsoundids.add(R.raw.description_fruits_grapes);
	auxsoundids.add(R.raw.quiz_fruits_grapes);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("These sweet and juicy fruits are great for the body because they contain essential vitamins and mienrals, including vitamin C and potassium.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is grapes!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	
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
