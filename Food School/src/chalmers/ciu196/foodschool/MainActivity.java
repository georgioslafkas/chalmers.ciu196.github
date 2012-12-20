package chalmers.ciu196.foodschool;


import java.util.ArrayList;
import chalmers.ciu196.foodschool.Database.DbManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public ArrayList<Integer> test = new ArrayList<Integer>();
	// Database related variables =============================================
	private DbManager databaseManager;
	// End of Database related variables ======================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

		initObjects();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		startService(new Intent(this,MediaServiceA.class));
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
	
	/* This method creates and initializes all the
	 * objects that the application is using.
	 * NOTE: Should be removed when parsing delay
	 * problem is solved.
	 */
	public void initObjects()
	{
		/* Get the instance of the food manager */
		FoodManager foodManager = SimpleFoodManager.getManager();
		
		/* Category objects */
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
		
		/***** Food object creation *****
		* Here we create all the objects
		* and set their properties.
		*/
		//--------------CEREALS-------------------
		Food bread = new Food();
		ArrayList<Integer> breadimages = new ArrayList<Integer>();
		ArrayList<Integer> breadsounds = new ArrayList<Integer>();
		ArrayList<String> breadquestions = new ArrayList<String>();
		ArrayList<String> breadanswers = new ArrayList<String>();
		
		bread.setName("bread");
		bread.setDescription("Bread is prepared by cooking a dough of flour and other ingredients. There are hundreds of types of bread made from different types of flours and with different ingredients. The nutritional content varies depending on the ingredients used.");
		bread.setId(R.drawable.img_cereals_bread);
		breadimages.add(R.drawable.cereals_detail_bread_large);
		breadimages.add(R.drawable.cereals_detail_bread_braidedbread);
		breadimages.add(R.drawable.cereals_detail_bread_sandwich);
		breadimages.add(R.drawable.cereals_detail_bread_slicedbread);
		bread.setImage_ids(breadimages);
		breadsounds.add(R.raw.bread);
		breadsounds.add(R.raw.description_cereals_bread);
		breadsounds.add(R.raw.quiz_cereals_bread);
		bread.setSound_ids(breadsounds);
		
		breadquestions.add("This cereal product is made from flour and other ingredients. There are hundreds of types made from different kinds of flour");
		bread.setQuestions(breadquestions);

		breadanswers.add("That's right, it is bread!");
		bread.setAnswers(breadanswers);
		foodManager.addFoodToCategory(bread, cereals);
		
		Food maize = new Food();
		ArrayList<Integer> maizeimages = new ArrayList<Integer>();
		ArrayList<Integer> maizesounds = new ArrayList<Integer>();
		ArrayList<String> maizequestions = new ArrayList<String>();
		ArrayList<String> maizeanswers = new ArrayList<String>();
		
		maize.setName("maize");
		maize.setDescription("Maize (also known as corn) is one of the world's major cereal crops and it is used as flour to make bread, breadkfast cereal, popcorn and a variety of meals. Sweet maize is grown and sold as a vegetable. It is a great source of dietary fibre and contains vitamin C, niacin, folate and potassium, which helps balancing the body's fluids.");
		maize.setId(R.drawable.img_cereals_corn);
		
		maizeimages.add(R.drawable.cereals_detail_corn_large);
		maizeimages.add(R.drawable.cereals_detail_corn_corngrains);
		maizeimages.add(R.drawable.cereals_detail_corn_cornplant);
		maizeimages.add(R.drawable.cereals_detail_corn_popcorn);
		maize.setImage_ids(maizeimages);
		
		maizesounds.add(R.raw.maize);
		maizesounds.add(R.raw.description_cereals_maize);
		maizesounds.add(R.raw.quiz_cereals_maize);
		maize.setSound_ids(maizesounds);
		
		maizequestions.add("This cereal crop is used as flour to make bread, breakfast cereal, popcorn and a variety of meals. It also grown as sweet corn to be sold as a vegetable. It contains dietary fibre, vitamin C and potassium, among others");
		maize.setQuestions(maizequestions);
		
		maizeanswers.add("Well done, it is maize!");
		maize.setAnswers(maizeanswers);
		foodManager.addFoodToCategory(maize, cereals);
		
		Food pasta = new Food();
		ArrayList<Integer> pastaimages = new ArrayList<Integer>();
		ArrayList<Integer> pastasounds = new ArrayList<Integer>();
		ArrayList<String> pastaquestions = new ArrayList<String>();
		ArrayList<String> pastaanswers = new ArrayList<String>();
		
		pasta.setName("pasta");
		pasta.setDescription("Pasta comes in many shapes and it is usually made from wheat flour. Pasta contains complex carbohydrates which release energy slowly compared to sugar, providing energy for a longer time. It is also a source of iron and vitamin B.");
		pasta.setId(R.drawable.img_cereals_pasta);
		
		pastaimages.add(R.drawable.cereals_detail_pasta_large);
		pastaimages.add(R.drawable.cereals_detail_pasta_lasagna);
		pastaimages.add(R.drawable.cereals_detail_pasta_ravioli);
		pastaimages.add(R.drawable.cereals_detail_pasta_spaghetti);
		pasta.setImage_ids(pastaimages);
		
		pastasounds.add(R.raw.pasta);
		pastasounds.add(R.raw.description_cereals_pasta);
		pastasounds.add(R.raw.quiz_cereals_pasta);
		pasta.setSound_ids(pastasounds);
		
		pastaquestions.add("This cereal product is usually made from wheat flour and can be found in many shapes. It provides you with energy for a long time because of its complex carbohydrates.");
		pasta.setQuestions(pastaquestions);
		
		pastaanswers.add("Excellent, it is pasta!");
		pasta.setAnswers(pastaanswers);
		foodManager.addFoodToCategory(pasta, cereals);
		
		Food rice = new Food();
		ArrayList<Integer> riceimages = new ArrayList<Integer>();
		ArrayList<Integer> ricesounds = new ArrayList<Integer>();
		ArrayList<String> ricequestions = new ArrayList<String>();
		ArrayList<String> riceanswers = new ArrayList<String>();
		
		rice.setName("rice");
		rice.setDescription("Rice is an excellent source of energy. In fact, it is the main source of energy for a lot of countries around the world. It is packed with itamins andminerals like itamin E, B and potassium. It is also low in fat.");
		rice.setId(R.drawable.img_cereals_rice);
		
		riceimages.add(R.drawable.cereals_detail_rice_large);
		riceimages.add(R.drawable.cereals_detail_rice_ricebag);
		riceimages.add(R.drawable.cereals_detail_rice_riceplant);
		rice.setImage_ids(riceimages);
		
		ricesounds.add(R.raw.rice);
		ricesounds.add(R.raw.description_cereals_rice);
		ricesounds.add(R.raw.quiz_cereals_rice);
		rice.setSound_ids(ricesounds);
		
		ricequestions.add("This cereal crop is the main source of energy for a lot of countries around the world. It is packed with vitamins and minerals, and it is also low in fat.");
		rice.setQuestions(ricequestions);
		
		riceanswers.add("That's right, it is rice!");
		rice.setAnswers(riceanswers);
		foodManager.addFoodToCategory(rice, cereals);

		Food wheat = new Food();
		ArrayList<Integer> wheatimages = new ArrayList<Integer>();
		ArrayList<Integer> wheatsounds = new ArrayList<Integer>();
		ArrayList<String> wheatquestions = new ArrayList<String>();
		ArrayList<String> wheatanswers = new ArrayList<String>();
		
		wheat.setName("wheat");
		wheat.setDescription("Wheat is the leading source of vegetable protein in human food. It has a valuable content of protein. It contains iron which is an important component of blood. It is mostly used to make flour for a variety of food products like bread, cereal and pasta.");
		wheat.setId(R.drawable.img_cereals_wheat);
		
		wheatimages.add(R.drawable.cereals_detail_wheat_large);
		wheatimages.add(R.drawable.cereals_detail_wheat_wheatbread);
		wheatimages.add(R.drawable.cereals_detail_wheat_flour);
		wheatimages.add(R.drawable.cereals_detail_wheat_wheatplant);
		wheat.setImage_ids(wheatimages);
		
		wheatsounds.add(R.raw.wheat);
		wheatsounds.add(R.raw.description_cereals_wheat);
		wheatsounds.add(R.raw.quiz_cereals_wheat);
		wheat.setSound_ids(wheatsounds);
		
		wheatquestions.add("This cereal crop is the leading source of vegetable protein in human food. It contains iron, which is an important component of blood. It is used to make flour for a variety of products like bread and pasta.");
		wheat.setQuestions(wheatquestions);
		
		wheatanswers.add("Well done, it is wheat!");
		wheat.setAnswers(wheatanswers);
		foodManager.addFoodToCategory(wheat, cereals);
		
		//--------------DAIRY-------------------
		Food butter = new Food();
		ArrayList<Integer> butterimages = new ArrayList<Integer>();
		ArrayList<Integer> buttersounds = new ArrayList<Integer>();
		ArrayList<String> butterquestions = new ArrayList<String>();
		ArrayList<String> butteranswers = new ArrayList<String>();
		
		butter.setName("butter");
		butter.setDescription("Butter contains 'good' fat. It is used as a spread and for cooking and baking. It is rich in vitamin A, which helps your eyes, bones and skin. It also contains vitamin E, K and D. Vitamin D is essential in the absorption of calcium. It is a good source of iodine, which helps regulate the hormonesin the body.");
		butter.setId(R.drawable.img_dairy_butter);
		
		butterimages.add(R.drawable.dairy_detail_butter_large);
		butterimages.add(R.drawable.dairy_detail_butter_breadbutter);
		butterimages.add(R.drawable.dairy_detail_butter_cake);
		butterimages.add(R.drawable.dairy_detail_butter_croissant);
		butter.setImage_ids(butterimages);
		
		buttersounds.add(R.raw.butter);
		buttersounds.add(R.raw.description_dairy_butter);
		buttersounds.add(R.raw.quiz_dairy_butter);
		butter.setSound_ids(buttersounds);
		
		butterquestions.add("This dairy product is a 'good' fat source that is used as a spread and for food preparation. Its vitamins help your eyes, bones and skin.");
		butter.setQuestions(butterquestions);
		
		butteranswers.add("Excellent, it is butter!");
		butter.setAnswers(butteranswers);
		foodManager.addFoodToCategory(butter, dairy);
		
		Food cheese = new Food();
		ArrayList<Integer> cheeseimages = new ArrayList<Integer>();
		ArrayList<Integer> cheesesounds = new ArrayList<Integer>();
		ArrayList<String> cheesequestions = new ArrayList<String>();
		ArrayList<String> cheeseanswers = new ArrayList<String>();
		
		cheese.setName("cheese");
		cheese.setDescription("There are hundreds of types of cheese made from milk from different animals, not only cows' milk. Cheese is valued for its portability, long life, and high content of fat, protein, calcium, and phosphorus. Calcium makes it good for your teeth and bones.");
		cheese.setId(R.drawable.img_dairy_cheese);
		
		cheeseimages.add(R.drawable.dairy_detail_cheese_large);
		cheeseimages.add(R.drawable.dairy_detail_cheese_cheeseblock);
		cheeseimages.add(R.drawable.dairy_detail_cheese_cheeseslice);
		cheeseimages.add(R.drawable.dairy_detail_cheese_sandwich);
		cheese.setImage_ids(cheeseimages);
		
		cheesesounds.add(R.raw.cheese);
		cheesesounds.add(R.raw.description_dairy_cheese);
		cheesesounds.add(R.raw.quiz_dairy_cheese);
		cheese.setSound_ids(cheesesounds);
		
		cheesequestions.add("There are hundreds of types of this dairy product, coming from different animals. Its high content of calcium means that it is good for your teeth and bones.");
		cheese.setQuestions(cheesequestions);
		
		cheeseanswers.add("Good job, it is cheese!");
		cheese.setAnswers(cheeseanswers);
		foodManager.addFoodToCategory(cheese, dairy);
		
		Food milk = new Food();
		ArrayList<Integer> milkimages = new ArrayList<Integer>();
		ArrayList<Integer> milksounds = new ArrayList<Integer>();
		ArrayList<String> milkquestions = new ArrayList<String>();
		ArrayList<String> milkanswers = new ArrayList<String>();
		
		milk.setName("milk");
		milk.setDescription("Milk is the base of all dairy products. It is collected from many kinds of livestock, for example cattle, goats and sheep. It is a gread source of calcium, which helps keep your bones and teeth strong. It is also a good source of protein.");
		milk.setId(R.drawable.img_dairy_milk);
		
		milkimages.add(R.drawable.dairy_detail_milk_large);
		milkimages.add(R.drawable.dairy_detail_milk_cereal);
		milkimages.add(R.drawable.dairy_detail_milk_cow);
		milkimages.add(R.drawable.dairy_detail_milk_icecream);
		milkimages.add(R.drawable.dairy_detail_milk_milkcarton);
		milk.setImage_ids(milkimages);
		
		milksounds.add(R.raw.milk);
		milksounds.add(R.raw.description_dairy_milk);
		milksounds.add(R.raw.quiz_dairy_milk);
		milk.setSound_ids(milksounds);
		
		milkquestions.add("This white liquid is the base for all dairy products. It is collected from many kinds of livestock, and it is a great source of calcium, keeping your bones and teeth strong.");
		milk.setQuestions(milkquestions);
		
		milkanswers.add("You are really good, it is milk!");
		milk.setAnswers(milkanswers);
		foodManager.addFoodToCategory(milk, dairy);
		
		Food yogurt = new Food();
		ArrayList<Integer> yogurtimages = new ArrayList<Integer>();
		ArrayList<Integer> yogurtsounds = new ArrayList<Integer>();
		ArrayList<String> yogurtquestions = new ArrayList<String>();
		ArrayList<String> yogurtanswers = new ArrayList<String>();
		
		yogurt.setName("yogurt");
		yogurt.setDescription("Yogurt is made from milk using 'good' bacteria. It is a good regulator of the functions of your digestive system. It is rich in calcium, which helps keep your bones and teeth strong and healthy.");
		yogurt.setId(R.drawable.img_dairy_yogurt);
		
		yogurtimages.add(R.drawable.dairy_detail_yogurt_large);
		yogurtimages.add(R.drawable.dairy_detail_yogurt_frozenyogurt);
		yogurtimages.add(R.drawable.dairy_detail_yogurt_yogurtpack);
		yogurt.setImage_ids(yogurtimages);
		
		yogurtsounds.add(R.raw.yogurt);
		yogurtsounds.add(R.raw.description_dairy_yogurt);
		yogurtsounds.add(R.raw.quiz_dairy_yogurt);
		yogurt.setSound_ids(yogurtsounds);
		
		yogurtquestions.add("This dairty product is made from milk and using 'good' bacteria. It is good fro your digestive system, your bones and your teeth.");
		yogurt.setQuestions(yogurtquestions);
		
		yogurtanswers.add("Well done, it is yogurt!");
		yogurt.setAnswers(yogurtanswers);
		foodManager.addFoodToCategory(yogurt, dairy);
		
		//--------------FRUITS-------------------
		
		Food apple = new Food();
		ArrayList<Integer> appleimages = new ArrayList<Integer>();
		ArrayList<Integer> applesounds = new ArrayList<Integer>();
		ArrayList<String> applequestions = new ArrayList<String>();
		ArrayList<String> appleanswers = new ArrayList<String>();
		
		apple.setName("apple");
		apple.setDescription("Apples are sweet, delicious, and good for you. They contain vitamin C, which helps keep your immune system strong. They also protect your heart, brain, lungs and other vital organs.");
		apple.setId(R.drawable.img_fruits_apple);
		
		appleimages.add(R.drawable.fruits_detail_apple_large);
		appleimages.add(R.drawable.fruits_detail_apple_applebasket);
		appleimages.add(R.drawable.fruits_detail_apple_applejuice);
		appleimages.add(R.drawable.fruits_detail_apple_appletree);
		appleimages.add(R.drawable.fruits_detail_apple_peeledapple);
		apple.setImage_ids(appleimages);
		applesounds.add(R.raw.apple);
		applesounds.add(R.raw.description_fruits_apple);
		applesounds.add(R.raw.quiz_fruits_apple);
		apple.setSound_ids(applesounds);
		applequestions.add("This sweet fruit helps keep your immune system strong, and protect your heart, brain, lungs and other vital organs.");
		apple.setQuestions(applequestions);
		appleanswers.add("That's right, it is apple!");
		apple.setAnswers(appleanswers);
		foodManager.addFoodToCategory(apple, fruits);
		
		Food banana = new Food();
		ArrayList<Integer> bananaimages = new ArrayList<Integer>();
		ArrayList<Integer> bananasounds = new ArrayList<Integer>();
		ArrayList<String> bananaquestions = new ArrayList<String>();
		ArrayList<String> bananaanswers = new ArrayList<String>();
		
		banana.setName("banana");
		banana.setDescription("Bananas are a great snack. They are high in natural sugar and fibre, and they keep you full for a long time. They have a lot of potassium, which helps keep your heart, nervous system and kidneys healthy.");
		banana.setId(R.drawable.img_fruits_banana);
		bananaimages.add(R.drawable.fruits_detail_banana_large);
		bananaimages.add(R.drawable.fruits_detail_banana_bananasplit);
		bananaimages.add(R.drawable.fruits_detail_banana_bananatree);
		bananaimages.add(R.drawable.fruits_detail_banana_peeledbanana);
		banana.setImage_ids(bananaimages);
		bananasounds.add(R.raw.banana);
		bananasounds.add(R.raw.description_fruits_banana);
		bananasounds.add(R.raw.quiz_fruits_banana);
		banana.setSound_ids(bananasounds);
		bananaquestions.add("This sugary fruit is a great snack because it keeps you full for a long time. Thanks to potassium, it helps keep your heart, brain and kidneys healthy.");
		banana.setQuestions(bananaquestions);
		bananaanswers.add("Excellent, it is banana!");
		banana.setAnswers(bananaanswers);
		foodManager.addFoodToCategory(banana, fruits);
		
		Food cherries = new Food();
		ArrayList<Integer> cherryimages = new ArrayList<Integer>();
		ArrayList<Integer> cherrysounds = new ArrayList<Integer>();
		ArrayList<String> cherryquestions = new ArrayList<String>();
		ArrayList<String> cherryanswers = new ArrayList<String>();
		
		cherries.setName("cherries");
		cherries.setDescription("Cherries are small fruits that contain antioxidants, which are good for the body in many different ways. They can help reduce headaches, iprove your sleep and prevent cancer.");
		cherries.setId(R.drawable.img_fruits_cherry);
		cherryimages.add(R.drawable.fruits_detail_cherry_large);
		cherryimages.add(R.drawable.fruits_detail_cherry_cannedcherries);
		cherryimages.add(R.drawable.fruits_detail_cherry_cherrydrink);
		cherries.setImage_ids(cherryimages);
		cherrysounds.add(R.raw.cherry);
		cherrysounds.add(R.raw.description_fruits_cherries);
		cherrysounds.add(R.raw.quiz_fruits_cherries);
		cherries.setSound_ids(cherrysounds);
		cherryquestions.add("These small fruits contain antioxidants that can help your body reduce headaches, improve your sleep and prevent cancer.");
		cherries.setQuestions(cherryquestions);
		cherryanswers.add("Well done, it is cherries!");
		cherries.setAnswers(cherryanswers);
		foodManager.addFoodToCategory(cherries, fruits);
		
		Food grapes = new Food();
		ArrayList<Integer> grapesimages = new ArrayList<Integer>();
		ArrayList<Integer> grapessounds = new ArrayList<Integer>();
		ArrayList<String> grapesquestions = new ArrayList<String>();
		ArrayList<String> grapesanswers = new ArrayList<String>();
		
		grapes.setName("grapes");
		grapes.setDescription("Grapes are sweet, juicy and packed with essential vitamins and minerals. They provide dietary fibre, vitamin C and potassium. The energy you get from grapes lasts longer because it is slowly digested.");
		grapes.setId(R.drawable.img_fruits_grapes);
		
		grapesimages.add(R.drawable.fruits_detail_grapes_large);
		grapesimages.add(R.drawable.fruits_detail_grapes_grapejuice);
		grapesimages.add(R.drawable.fruits_detail_grapes_raisins);
		grapesimages.add(R.drawable.fruits_detail_grapes_wine);
		grapes.setImage_ids(grapesimages);
		
		grapessounds.add(R.raw.grapes);
		grapessounds.add(R.raw.description_fruits_grapes);
		grapessounds.add(R.raw.quiz_fruits_grapes);
		grapes.setSound_ids(grapessounds);
		
		grapesquestions.add("These sweet and juicy fruits are great for the body because they contain essential vitamins and mienrals, including vitamin C and potassium.");
		grapes.setQuestions(grapesquestions);
		
		grapesanswers.add("That's right, it is grapes!");
		grapes.setAnswers(grapesanswers);
		foodManager.addFoodToCategory(grapes, fruits);
		
		Food lemon = new Food();
		ArrayList<Integer> lemonimages = new ArrayList<Integer>();
		ArrayList<Integer> lemonsounds = new ArrayList<Integer>();
		ArrayList<String> lemonquestions = new ArrayList<String>();
		ArrayList<String> lemonanswers = new ArrayList<String>();
		
		lemon.setName("lemon");
		lemon.setDescription("Lemons are sour, citrus fruits, so you probably wil not eat one by itself. It is rich in vitamin C, which helps keep your immune system strong and prevent deseases. Its juice can be combined with sugar or honey to make delicious drinks or cure your sore throat. It is also great for improving the taste of other food.");
		lemon.setId(R.drawable.img_fruits_lemon);
		
		lemonimages.add(R.drawable.fruits_detail_lemon_large);
		lemonimages.add(R.drawable.fruits_detail_lemon_lemonade);
		lemonimages.add(R.drawable.fruits_detail_lemon_lemonjam);
		lemonimages.add(R.drawable.fruits_detail_lemon_lemontea);
		lemonimages.add(R.drawable.fruits_detail_lemon_pressedlemon);
		lemon.setImage_ids(lemonimages);
		
		lemonsounds.add(R.raw.lemon);
		lemonsounds.add(R.raw.description_fruits_lemon);
		lemonsounds.add(R.raw.quiz_fruits_lemon);
		lemon.setSound_ids(lemonsounds);
		
		lemonquestions.add("This sour, citrus fruit might not be good to eat by itself, but its juice combines with sugar or honey to make delicious drinks. Its high content of vitamin C helps your immune system stay strong and fight diseases.");
		lemon.setQuestions(lemonquestions);
		
		lemonanswers.add("Very well, it is a lemon!");
		lemon.setAnswers(lemonanswers);
		foodManager.addFoodToCategory(lemon, fruits);
		
		Food lime = new Food();
		ArrayList<Integer> limeimages = new ArrayList<Integer>();
		ArrayList<Integer> limesounds = new ArrayList<Integer>();
		ArrayList<String> limequestions = new ArrayList<String>();
		ArrayList<String> limeanswers = new ArrayList<String>();
		
		lime.setName("lime");
		lime.setDescription("Limes have a sour tate because they are very low in sugars. They are rich in vitamin C, which helps keep away diseases. Its juice is also good for your skin. Its peel and juice are great for flavoring food.");
		lime.setId(R.drawable.img_fruits_lime);
		
		limeimages.add(R.drawable.fruits_detail_lime_large);
		limeimages.add(R.drawable.fruits_detail_lime_limepeel);
		limeimages.add(R.drawable.fruits_detail_lime_pressedlime);
		lime.setImage_ids(limeimages);
		
		limesounds.add(R.raw.lime);
		limesounds.add(R.raw.description_fruits_lime);
		limesounds.add(R.raw.quiz_fruits_lime);
		lime.setSound_ids(limesounds);
		
		limequestions.add("This sour fruit is very lowin sugar but rich in vitamin C, which helps your body fight deseases. Its juice is good for your skin, also.");
		lime.setQuestions(limequestions);
		
		limeanswers.add("Great job, it is a lime!");
		lime.setAnswers(limeanswers);
		foodManager.addFoodToCategory(lime, fruits);
		
		Food orange = new Food();
		ArrayList<Integer> orangeimages = new ArrayList<Integer>();
		ArrayList<Integer> orangesounds = new ArrayList<Integer>();
		ArrayList<String> orangequestions = new ArrayList<String>();
		ArrayList<String> orangeanswers = new ArrayList<String>();
		
		orange.setName("orange");
		orange.setDescription("Oranges are citruis fruits. They can be sweet or sour, depending on the variety. One orange contains enough vitamin C for two days, which help keep your immune system protecting your body from diseases. They also contain fibre and beta carotene, which is converted to vitamin A by the body and is good for your eyes.");
		orange.setId(R.drawable.img_fruits_orange);
		
		orangeimages.add(R.drawable.fruits_detail_orange_large);
		orangeimages.add(R.drawable.fruits_detail_orange_orangejuice);
		orangeimages.add(R.drawable.fruits_detail_orange_orangetree);
		orangeimages.add(R.drawable.fruits_detail_orange_pressedorange);
		orange.setImage_ids(orangeimages);
		
		orangesounds.add(R.raw.orange);
		orangesounds.add(R.raw.description_fruits_orange);
		orangesounds.add(R.raw.quiz_fruits_orange);
		orange.setSound_ids(orangesounds);
		
		orangequestions.add("This citrus fruit can be found in many varieties, sweet or sour. One of them has enough vitamin C for two days, which is reat for your immune system.");
		orange.setQuestions(orangequestions);
		
		orangeanswers.add("Excellent, it is an orange!");
		orange.setAnswers(orangeanswers);
		foodManager.addFoodToCategory(orange, fruits);
		
		Food peach = new Food();
		ArrayList<Integer> peachimages = new ArrayList<Integer>();
		ArrayList<Integer> peachsounds = new ArrayList<Integer>();
		ArrayList<String> peachquestions = new ArrayList<String>();
		ArrayList<String> peachanswers = new ArrayList<String>();
		
		peach.setName("peach");
		peach.setDescription("Peaches are juicy, sweet and nutritious. They are a godd source of vitamin C, which helps your immune system, dietary fibre, which keeps your digestive system healthy, and beta carotene, which helps your skin and eyes stay healthy. they also contain small amounts of other vitamins and minerals.");
		peach.setId(R.drawable.img_fruits_peach);
		
		peachimages.add(R.drawable.fruits_detail_peach_large);
		peachimages.add(R.drawable.fruits_detail_peach_cannedpeaches);
		peachimages.add(R.drawable.fruits_detail_peach_peachjuice);
		peachimages.add(R.drawable.fruits_detail_peach_peachseed);
		peach.setImage_ids(peachimages);
		
		peachsounds.add(R.raw.peach);
		peachsounds.add(R.raw.description_fruits_peach);
		peachsounds.add(R.raw.quiz_fruits_peach);
		peach.setSound_ids(peachsounds);
		
		peachquestions.add("This juicy and sweet fruit is good for your immune system, your digestive system, your skin and your eyes.");
		peach.setQuestions(peachquestions);
		
		peachanswers.add("Very well, it is a peach!");
		peach.setAnswers(peachanswers);
		foodManager.addFoodToCategory(peach, fruits);
		
		Food pear = new Food();
		ArrayList<Integer> pearimages = new ArrayList<Integer>();
		ArrayList<Integer> pearsounds = new ArrayList<Integer>();
		ArrayList<String> pearquestions = new ArrayList<String>();
		ArrayList<String> pearanswers = new ArrayList<String>();
		
		pear.setName("pear");
		pear.setDescription("Pears are sweet and juicy. They are digestede slowly, meaning that they provide energy for a longer time than other types of food. They contain vitamin C, which helps your immune system, copper, which helps yoru brain learn and remember, and dietary fibre, which keeps your digestive system healthy.");
		pear.setId(R.drawable.img_fruits_pear);
		
		pearimages.add(R.drawable.fruits_detail_pear_large);
		pearimages.add(R.drawable.fruits_detail_pear_pearjuice);
		pearimages.add(R.drawable.fruits_detail_pear_peartree);
		pear.setImage_ids(pearimages);
		
		pearsounds.add(R.raw.pear);
		pearsounds.add(R.raw.description_fruits_pears);
		pearsounds.add(R.raw.quiz_fruits_pear);
		pear.setSound_ids(pearsounds);
		
		pearquestions.add("This fruit is digested slowly and provides your body with energy for a long time. It contains substances that help your immune system, your brain and your digestive system.");
		pear.setQuestions(pearquestions);
		
		pearanswers.add("Well done, it is a pear!");
		pear.setAnswers(pearanswers);
		foodManager.addFoodToCategory(pear, fruits);
		
		Food pineapple = new Food();
		ArrayList<Integer> pineappleimages = new ArrayList<Integer>();
		ArrayList<Integer> pineapplesounds = new ArrayList<Integer>();
		ArrayList<String> pineapplequestions = new ArrayList<String>();
		ArrayList<String> pineappleanswers = new ArrayList<String>();
		
		pineapple.setName("pineapple");
		pineapple.setDescription("Pineapple is a tropical fruit with high levels of vitamin C, which helps your immune system stay strong. It also contains high levels of the mineral manganese. Manganese helps your body produce energy, keeps your bones strong and helps your body digest fat.");
		pineapple.setId(R.drawable.img_fruits_pineapple);
		
		pineappleimages.add(R.drawable.fruits_detail_pineapple_large);
		pineappleimages.add(R.drawable.fruits_detail_pineapple_drypineapple);
		pineappleimages.add(R.drawable.fruits_detail_pineapple_pineapplejuice);
		pineappleimages.add(R.drawable.fruits_detail_pineapple_pineappleplant);
		pineappleimages.add(R.drawable.fruits_detail_pineapple_slicedpineapple);
		pineapple.setImage_ids(pineappleimages);
		
		pineapplesounds.add(R.raw.pineapple);
		pineapplesounds.add(R.raw.description_fruits_pineapple);
		pineapplesounds.add(R.raw.quiz_fruits_pineapple);
		pineapple.setSound_ids(pineapplesounds);
		
		pineapplequestions.add("This tropical fruit contains high amounts of vitamin C and manganese. It helps keep your body healthy by keeping your immune system strong, helping your body produce energy and digest fat, and keeping your bones strong.");
		pineapple.setQuestions(pineapplequestions);
		
		pineappleanswers.add("Your answer is right! It is a pineapple!");
		pineapple.setAnswers(pineappleanswers);
		foodManager.addFoodToCategory(pineapple, fruits);
		
		Food strawberries = new Food();
		ArrayList<Integer> strawberriesimages = new ArrayList<Integer>();
		ArrayList<Integer> strawberriessounds = new ArrayList<Integer>();
		ArrayList<String> strawberriesquestions = new ArrayList<String>();
		ArrayList<String> strawberriesanswers = new ArrayList<String>();
		
		strawberries.setName("strawberries");
		strawberries.setDescription("Strawberries are part of the berry family, lke raspeberries and blackberries. They have a high content of vitamin C, which keeps your immunes system strong, dietary fibre, which is good for your digestive system, folate, which is essential to keep the body functioning.");
		strawberries.setId(R.drawable.img_fruits_strawberries);
		
		strawberriesimages.add(R.drawable.fruits_detail_strawberries_large);
		strawberriesimages.add(R.drawable.fruits_detail_strawberries_cannedstrawberries);
		strawberriesimages.add(R.drawable.fruits_detail_strawberries_drystrawberries);
		strawberriesimages.add(R.drawable.fruits_detail_strawberries_strawberryicecream);
		strawberriesimages.add(R.drawable.fruits_detail_strawberries_strawberryjam);
		strawberries.setImage_ids(strawberriesimages);
		
		strawberriessounds.add(R.raw.strawberries);
		strawberriessounds.add(R.raw.description_fruits_strawberries);
		strawberriessounds.add(R.raw.quiz_fruits_strawberries);
		strawberries.setSound_ids(strawberriessounds);
		
		strawberriesquestions.add("These members of the berry family have a high content of vitamin C, dietary fibre and folate. Which means tehy contain elements that keep your immune system, digestive system and other functions in you body working properly.");
		strawberries.setQuestions(strawberriesquestions);
		
		strawberriesanswers.add("That's right, it is strawberries!");
		strawberries.setAnswers(strawberriesanswers);
		foodManager.addFoodToCategory(strawberries, fruits);
		
		Food watermelon = new Food();
		ArrayList<Integer> watermelonimages = new ArrayList<Integer>();
		ArrayList<Integer> watermelonsounds = new ArrayList<Integer>();
		ArrayList<String> watermelonquestions = new ArrayList<String>();
		ArrayList<String> watermelonanswers = new ArrayList<String>();
		
		watermelon.setName("watermelon");
		watermelon.setDescription("Watermelon is the refreshing fruit by excellence due to it being mostly water. It is a good source of vitamin C, which keeps your immune system strong, and beta carotene which, when transformed into vitamin A, is good for your eyes.");
		watermelon.setId(R.drawable.img_fruits_watermelon);
		
		watermelonimages.add(R.drawable.fruits_detail_watermelon_large);
		watermelonimages.add(R.drawable.fruits_detail_watermelon_slicedwatermelon);
		watermelonimages.add(R.drawable.fruits_detail_watermelon_watermelonjuice);
		watermelonimages.add(R.drawable.fruits_detail_watermelon_watermelonsherbet);
		watermelon.setImage_ids(watermelonimages);
		
		watermelonsounds.add(R.raw.watermelon);
		watermelonsounds.add(R.raw.description_fruits_watermelon);
		watermelonsounds.add(R.raw.quiz_fruits_watermelon);
		watermelon.setSound_ids(watermelonsounds);
		
		watermelonquestions.add("This refreshing fruit is a good source of vitamin C and beta carotene. These two substances help your body fight diseases and your eyes stay strong.");
		watermelon.setQuestions(watermelonquestions);
		
		watermelonanswers.add("Really nice! It is a watermelon!");
		watermelon.setAnswers(watermelonanswers);
		foodManager.addFoodToCategory(watermelon, fruits);
		
		//--------------PROTEIN-------------------
		
		Food beef = new Food();
		ArrayList<Integer> beefimages = new ArrayList<Integer>();
		ArrayList<Integer> beefsounds = new ArrayList<Integer>();
		ArrayList<String> beefquestions = new ArrayList<String>();
		ArrayList<String> beefanswers = new ArrayList<String>();
		
		beef.setName("beef");
		beef.setDescription("Beef is the name of meat from cattle. A variety of products com from beef. Beef is an excellent source of complete protein and vital minerals such as zinc, selenium, phosphorus and iron, and B vitamins.");
		beef.setId(R.drawable.img_protein_beef);
		
		beefimages.add(R.drawable.protein_detail_beef_large);
		beefimages.add(R.drawable.protein_detail_beef_cow);
		beefimages.add(R.drawable.protein_detail_beef_meatballs);
		beefimages.add(R.drawable.protein_detail_beef_skeweredmeat);
		beef.setImage_ids(beefimages);
		
		beefsounds.add(R.raw.beef);
		beefsounds.add(R.raw.description_protein_beef);
		beefsounds.add(R.raw.quiz_protein_beef);
		beef.setSound_ids(beefsounds);
		
		beefquestions.add("This meat comes from cattle and it is used for a variety of products. As all types of meat, it is a source of protein. It also contains several vital minerals, such as iron.");
		beef.setQuestions(beefquestions);
		
		beefanswers.add("That's right, it is a beef!");
		beef.setAnswers(beefanswers);
		foodManager.addFoodToCategory(beef, meats);
		
		Food chicken = new Food();
		ArrayList<Integer> chickenimages = new ArrayList<Integer>();
		ArrayList<Integer> chickensounds = new ArrayList<Integer>();
		ArrayList<String> chickenquestions = new ArrayList<String>();
		ArrayList<String> chickenanswers = new ArrayList<String>();
		
		chicken.setName("chicken");
		chicken.setDescription("Poultry is the second most widely eatin meat in the world. Most commonly, it refers to chicken but it also comes from duck and turkey, among others. You must cook chicken before you eat it becaus it could contain salmonella. Chicken is a good source of protein, calcium and potassium.");
		chicken.setId(R.drawable.img_protein_chicken);
		
		chickenimages.add(R.drawable.protein_detail_chicken_large);
		chickenimages.add(R.drawable.protein_detail_chicken_bakedchicken);
		chickenimages.add(R.drawable.protein_detail_chicken_chicken);
		chickenimages.add(R.drawable.protein_detail_chicken_chickensoup);
		chicken.setImage_ids(chickenimages);
		
		chickensounds.add(R.raw.chicken);
		chickensounds.add(R.raw.description_protein_chicken);
		chickensounds.add(R.raw.quiz_protein_chicken);
		chicken.setSound_ids(chickensounds);
		
		chickenquestions.add("This is the second most widely eaten meat in the world. You must always cook it carefully because you might get sick otherwise. It is a good source of protein, calcium and potassium.");
		chicken.setQuestions(chickenquestions);
		
		chickenanswers.add("Well done, it is chicken!");
		chicken.setAnswers(chickenanswers);
		foodManager.addFoodToCategory(chicken, meats);
		
		Food eggs = new Food();
		ArrayList<Integer> eggsimages = new ArrayList<Integer>();
		ArrayList<Integer> eggssounds = new ArrayList<Integer>();
		ArrayList<String> eggsquestions = new ArrayList<String>();
		ArrayList<String> eggsanswers = new ArrayList<String>();
		
		eggs.setName("eggs");
		eggs.setDescription("Chicken eggs are the most commonly eaten eggs. They supply all essential amino acids for humans and provide several vitamins and minerals, like choline, which helps regulate the brain, nervous system, and cardiovascular system.");
		eggs.setId(R.drawable.img_protein_egg);
		
		eggsimages.add(R.drawable.protein_detail_egg_large);
		eggsimages.add(R.drawable.protein_detail_egg_boiledegg);
		eggsimages.add(R.drawable.protein_detail_egg_friedegg);
		eggs.setImage_ids(eggsimages);
		
		eggssounds.add(R.raw.eggs);
		eggssounds.add(R.raw.description_protein_eggs);
		eggssounds.add(R.raw.quiz_protein_eggs);
		eggs.setSound_ids(eggssounds);
		
		eggsquestions.add("This protein source supply all essential amino acids for humans and provides several vitamins and minerals. Choline, for example, helsp regulate the brain, nervous system, and cardiovascular system.");
		eggs.setQuestions(eggsquestions);
		
		eggsanswers.add("You are right, it is eggs!");
		eggs.setAnswers(eggsanswers);
		foodManager.addFoodToCategory(eggs, meats);
		
		Food fish = new Food();
		ArrayList<Integer> fishimages = new ArrayList<Integer>();
		ArrayList<Integer> fishsounds = new ArrayList<Integer>();
		ArrayList<String> fishquestions = new ArrayList<String>();
		ArrayList<String> fishanswers = new ArrayList<String>();
		
		fish.setName("fish");
		fish.setDescription("Fish provides a good source of high quality protein and contains many vitamins and minerals. Some types of fish are good for your heart and brains because they contain omega 3 fatty acids.");
		fish.setId(R.drawable.img_protein_fish);
		
		fishimages.add(R.drawable.protein_detail_fish_large);
		fishimages.add(R.drawable.protein_detail_fish_cookedfish);
		fishimages.add(R.drawable.protein_detail_fish_friedfish);
		fish.setImage_ids(fishimages);
		
		fishsounds.add(R.raw.fish);
		fishsounds.add(R.raw.description_protein_fish);
		fishsounds.add(R.raw.quiz_protein_fish);
		fish.setSound_ids(fishsounds);
		
		fishquestions.add("This protein source provides high quality protein and contains many vitamins and mineral. it also contains Omega 3, which is good for your heart and brain.");
		fish.setQuestions(fishquestions);
		
		fishanswers.add("Well done, it is fish!");
		fish.setAnswers(fishanswers);
		foodManager.addFoodToCategory(fish, meats);
		
		Food pork = new Food();
		ArrayList<Integer> porkimages = new ArrayList<Integer>();
		ArrayList<Integer> porksounds = new ArrayList<Integer>();
		ArrayList<String> porkquestions = new ArrayList<String>();
		ArrayList<String> porkanswers = new ArrayList<String>();
		
		pork.setName("pork");
		pork.setDescription("Pork is the name for meat from domestic pig. It is mostly eaten cooked and often cured into ham and similar products. Pork should be eaten with moderation because of its high conten of 'bad' fat.");
		pork.setId(R.drawable.img_protein_pork);
		
		porkimages.add(R.drawable.protein_detail_pork_large);
		porkimages.add(R.drawable.protein_detail_pork_bacon);
		porkimages.add(R.drawable.protein_detail_pork_pig);
		pork.setImage_ids(porkimages);
		
		porksounds.add(R.raw.pork);
		porksounds.add(R.raw.description_protein_pork);
		porksounds.add(R.raw.quiz_protein_pork);
		pork.setSound_ids(porksounds);
		
		porkquestions.add("This protein source should be eaten with moderation, due to its high content of 'bad' fat. It is mostly eaten cooked and it is often cured into ham and similar products.");
		pork.setQuestions(porkquestions);
		
		porkanswers.add("Excellent, it is pork!");
		pork.setAnswers(porkanswers);
		foodManager.addFoodToCategory(pork, meats);
		
		Food sausage = new Food();
		ArrayList<Integer> sausageimages = new ArrayList<Integer>();
		ArrayList<Integer> sausagesounds = new ArrayList<Integer>();
		ArrayList<String> sausagequestions = new ArrayList<String>();
		ArrayList<String> sausageanswers = new ArrayList<String>();
		
		sausage.setName("sausage");
		sausage.setDescription("Sausages are usually made of different kinds of ground meat, either beef, pork or poultry, in a tight casing. There are a lot of different kinds depending on the region or country. Its nutritional value depends on what it is mde from. It usually contains other ingredients along with meat.");
		sausage.setId(R.drawable.img_protein_sausage);
		
		sausageimages.add(R.drawable.protein_detail_sausage_large);
		sausageimages.add(R.drawable.protein_detail_sausage_hotdog);
		sausageimages.add(R.drawable.protein_detail_sausage_sausage1);
		sausageimages.add(R.drawable.protein_detail_sausage_sausage2);
		sausage.setImage_ids(sausageimages);
		
		sausagesounds.add(R.raw.sausage);
		sausagesounds.add(R.raw.description_protein_sausage);
		sausagesounds.add(R.raw.quiz_protein_sausage);
		sausage.setSound_ids(sausagesounds);
		
		sausagequestions.add("This protein product can be made of different kinds of ground meat in a tight casing. There are a lot of different types depending on the region or country. Its nutritional value depends on the ingredients it is made from.");
		sausage.setQuestions(sausagequestions);
		
		sausageanswers.add("Good job, it is sausage!");
		sausage.setAnswers(sausageanswers);
		foodManager.addFoodToCategory(sausage, meats);
		
		//--------------VEGETABLES-------------------
		
		Food brocolli = new Food();
		ArrayList<Integer> brocolliimages = new ArrayList<Integer>();
		ArrayList<Integer> brocollisounds = new ArrayList<Integer>();
		ArrayList<String> brocolliquestions = new ArrayList<String>();
		ArrayList<String> brocollianswers = new ArrayList<String>();
		
		brocolli.setName("broccoli");
		brocolli.setDescription("Broccoli is a bush-shaped vegetable that contains a lot of nutritious substances. It is rich source of itamin C, which keeps your immune system strong and might help prevent cancer. Broccoli is also good for your heart, skin, bones and respiratory system.");
		brocolli.setId(R.drawable.img_vegetables_broccoli);
		
		brocolliimages.add(R.drawable.vegetables_detail_broccoli_large);
		brocolliimages.add(R.drawable.vegetables_detail_broccoli_broccoliplant);
		brocolliimages.add(R.drawable.vegetables_detail_broccoli_broccolisalad);
		brocolliimages.add(R.drawable.vegetables_detail_broccoli_broccolisoup);
		brocolli.setImage_ids(brocolliimages);
		
		brocollisounds.add(R.raw.broccoli);
		brocollisounds.add(R.raw.description_vegetables_broccoli);
		brocollisounds.add(R.raw.quiz_vegetables_broccoli);
		brocolli.setSound_ids(brocollisounds);
		
		brocolliquestions.add("This bush-shaped vegetable contains a lot of nutrients, like vitamin C, which helps your immune system and might helps prevent cancer. It is also good for your heart, skin, bones and respiratory system.");
		brocolli.setQuestions(brocolliquestions);
		
		brocollianswers.add("That's right, it is broccoli!");
		brocolli.setAnswers(brocollianswers);
		foodManager.addFoodToCategory(brocolli, vegetables);
		
		Food cabbage = new Food();
		ArrayList<Integer> cabbageimages = new ArrayList<Integer>();
		ArrayList<Integer> cabbagesounds = new ArrayList<Integer>();
		ArrayList<String> cabbagequestions = new ArrayList<String>();
		ArrayList<String> cabbageanswers = new ArrayList<String>();
		
		cabbage.setName("cabbage");
		cabbage.setDescription("Cabbage is a leafy vegetable. It contains vitamins and minerals, which help your digestive system, immune system, eyes, skin, and heart. It contains vitamin C, sulphur, iodine, and it is rich in fibre.");
		cabbage.setId(R.drawable.img_vegetables_cabbage);
		
		cabbageimages.add(R.drawable.vegetables_detail_cabbage_large);
		cabbageimages.add(R.drawable.vegetables_detail_cabbage_cabbageinside);
		cabbageimages.add(R.drawable.vegetables_detail_cabbage_redcabbage);
		cabbageimages.add(R.drawable.vegetables_detail_cabbage_shreddedcabbage);
		cabbage.setImage_ids(cabbageimages);
		
		cabbagesounds.add(R.raw.cabbage);
		cabbagesounds.add(R.raw.description_vegetables_cabbage);
		cabbagesounds.add(R.raw.quiz_vegetables_cabbage);
		cabbage.setSound_ids(cabbagesounds);
		
		cabbagequestions.add("This leafy vegetable is good for your digestive system, immune system, eyes, skin and heart.");
		cabbage.setQuestions(cabbagequestions);
		
		cabbageanswers.add("Of course it is a cabbage!Well done!");
		cabbage.setAnswers(cabbageanswers);
		foodManager.addFoodToCategory(cabbage, vegetables);
		
		Food carrot = new Food();
		ArrayList<Integer> carrotimages = new ArrayList<Integer>();
		ArrayList<Integer> carrotsounds = new ArrayList<Integer>();
		ArrayList<String> carrotquestions = new ArrayList<String>();
		ArrayList<String> carrotanswers = new ArrayList<String>();
		
		carrot.setName("carrot");
		carrot.setDescription("Carrots are a rich source of beta carotene, which the body converts to vitamin A. Vitamin A helps with night vision. They are a good source of dietary fibre, which helps your heart and your digestive system.");
		carrot.setId(R.drawable.img_vegetables_carrot);
		
		carrotimages.add(R.drawable.vegetables_detail_carrot_large);
		carrotimages.add(R.drawable.vegetables_detail_carrot_carrrotcake);
		carrotimages.add(R.drawable.vegetables_detail_carrot_carrotstick);
		carrotimages.add(R.drawable.vegetables_detail_carrot_shreddedcarrot);
		carrot.setImage_ids(carrotimages);
		
		carrotsounds.add(R.raw.carrot);
		carrotsounds.add(R.raw.description_vegetables_carrot);
		carrotsounds.add(R.raw.quiz_vegetables_carrot);
		carrot.setSound_ids(carrotsounds);
		
		carrotquestions.add("This vegetable is a rich source of beta carotene, which turns into vitamin A and helps your vision. It is also good for your heart and your digestive system.");
		carrot.setQuestions(carrotquestions);
		
		carrotanswers.add("Yes you are right, it is a carrot!");
		carrot.setAnswers(carrotanswers);
		foodManager.addFoodToCategory(carrot, vegetables);
		
		Food celery = new Food();
		ArrayList<Integer> celeryimages = new ArrayList<Integer>();
		ArrayList<Integer> celerysounds = new ArrayList<Integer>();
		ArrayList<String> celeryquestions = new ArrayList<String>();
		ArrayList<String> celeryanswers = new ArrayList<String>();
		
		celery.setName("celery");
		celery.setDescription("Eating celery helps clean your mouth and teeth. Celery contains vitamins, minerals and dietary fibre, which help regulate bowel movement, and relief anxiety.");
		celery.setId(R.drawable.img_vegetables_celery);
		
		celeryimages.add(R.drawable.vegetables_detail_celery_large);
		celeryimages.add(R.drawable.vegetables_detail_celery_celerystem);
		celeryimages.add(R.drawable.vegetables_detail_celery_celerysticks);
		celery.setImage_ids(celeryimages);
		
		celerysounds.add(R.raw.celery);
		celerysounds.add(R.raw.description_vegetables_celery);
		celerysounds.add(R.raw.quiz_vegetables_celery);
		celery.setSound_ids(celerysounds);
		
		celeryquestions.add("This vegetable helps clear your mouth and teeth. It also regulates bowel movement and reliefs anxiety.");
		celery.setQuestions(celeryquestions);
		
		celeryanswers.add("Excellent, it is celery!");
		celery.setAnswers(celeryanswers);
		foodManager.addFoodToCategory(celery, vegetables);
		
		Food cucumber = new Food();
		ArrayList<Integer> cucumberimages = new ArrayList<Integer>();
		ArrayList<Integer> cucumbersounds = new ArrayList<Integer>();
		ArrayList<String> cucumberquestions = new ArrayList<String>();
		ArrayList<String> cucumberanswers = new ArrayList<String>();
		
		cucumber.setName("cucumber");
		cucumber.setDescription("Cucumbers are mostly water, which is the reason they are so refreshing. They have small amounts of vitamins, like vitamins K and C, and minerasl, like calcium, iron and potassium.");
		cucumber.setId(R.drawable.img_vegetables_cucumber);
		
		cucumberimages.add(R.drawable.vegetables_detail_cucumber_large);
		cucumberimages.add(R.drawable.vegetables_detail_cucumber_cucumberplant);
		cucumberimages.add(R.drawable.vegetables_detail_cucumber_slicedcucumber);
		cucumber.setImage_ids(cucumberimages);
		
		cucumbersounds.add(R.raw.cucumber);
		cucumbersounds.add(R.raw.description_vegetables_cucumber);
		cucumbersounds.add(R.raw.quiz_vegetables_cucumber);
		cucumber.setSound_ids(cucumbersounds);
		
		cucumberquestions.add("This refreshing vegetable is mostly water. It contains small amounts of vitamins and minerals, like vitamin K, vitamin C, iron, calcium and potassium.");
		cucumber.setQuestions(cucumberquestions);
		
		cucumberanswers.add("Excellent, it is cucumber!");
		cucumber.setAnswers(cucumberanswers);
		foodManager.addFoodToCategory(cucumber, vegetables);
		
		Food eggplant = new Food();
		ArrayList<Integer> eggplantimages = new ArrayList<Integer>();
		ArrayList<Integer> eggplantsounds = new ArrayList<Integer>();
		ArrayList<String> eggplantquestions = new ArrayList<String>();
		ArrayList<String> eggplantanswers = new ArrayList<String>();
		
		eggplant.setName("eggplant");
		eggplant.setDescription("Eggplant is a top source of vitamin B6, which is important for your blood, brain and other tissues in your body. It is also a good source of dietary fibre and antioxidants.");
		eggplant.setId(R.drawable.img_vegetables_eggplant);
		
		eggplantimages.add(R.drawable.vegetables_detail_eggplant_large);
		eggplantimages.add(R.drawable.vegetables_detail_eggplant_eggplantplant);
		eggplantimages.add(R.drawable.vegetables_detail_eggplant_slicedeggplant);
		eggplant.setImage_ids(eggplantimages);
		
		eggplantsounds.add(R.raw.eggplant);
		eggplantsounds.add(R.raw.description_vegetables_eggplant);
		eggplantsounds.add(R.raw.quiz_vegetables_eggplant);
		eggplant.setSound_ids(eggplantsounds);
		
		eggplantquestions.add("This vegetable is a top source of vitamin B6, which is important for oyur blood, brain and other tissues in your body.");
		eggplant.setQuestions(eggplantquestions);
		
		eggplantanswers.add("Very well, it is eggplant!");
		eggplant.setAnswers(eggplantanswers);
		foodManager.addFoodToCategory(eggplant, vegetables);
		
		Food garlic = new Food();
		ArrayList<Integer> garlicimages = new ArrayList<Integer>();
		ArrayList<Integer> garlicsounds = new ArrayList<Integer>();
		ArrayList<String> garlicquestions = new ArrayList<String>();
		ArrayList<String> garlicanswers = new ArrayList<String>();
		
		garlic.setName("garlic");
		garlic.setDescription("In high quantities, garlic is a good source of dietary fibre, potassium, iron, zinc and vitamin C. They are rarely eaten in high quantities but are often use to add taste to other foods.");
		garlic.setId(R.drawable.img_vegetables_garlic);
		
		garlicimages.add(R.drawable.vegetables_detail_garlic_large);
		garlicimages.add(R.drawable.vegetables_detail_garlic_garlicclove);
		garlicimages.add(R.drawable.vegetables_detail_garlic_garlicplant);
		garlic.setImage_ids(garlicimages);
		
		garlicsounds.add(R.raw.garlic);
		garlicsounds.add(R.raw.description_vegetables_garlic);
		garlicsounds.add(R.raw.quiz_vegetables_garlic);
		garlic.setSound_ids(garlicsounds);
		
		garlicquestions.add("This vegetable is a good source of dietary fibre, potassium, vitamin C, and other nutrients. It is rarely eaten in high quantities, though, and it is often use to add taste to other foods.");
		garlic.setQuestions(garlicquestions);
		
		garlicanswers.add("Good job, it is garlic!");
		garlic.setAnswers(garlicanswers);
		foodManager.addFoodToCategory(garlic, vegetables);
		
		Food lettuce = new Food();
		ArrayList<Integer> lettuceimages = new ArrayList<Integer>();
		ArrayList<Integer> lettucesounds = new ArrayList<Integer>();
		ArrayList<String> lettucequestions = new ArrayList<String>();
		ArrayList<String> lettuceanswers = new ArrayList<String>();
		
		lettuce.setName("lettuce");
		lettuce.setDescription("Lettuce is one of the most popular salad vegetables. the darker the lettuce leaf the more nutritious it is. Lettuce is mostly made of water which is why it is so refreshing. It is a source of vitamin C, dietary fibre, beta carotene and folate.");
		lettuce.setId(R.drawable.img_vegetables_lettuce);
		
		lettuceimages.add(R.drawable.vegetables_detail_lettuce_large);
		lettuceimages.add(R.drawable.vegetables_detail_lettuce_lettuceplant);
		lettuceimages.add(R.drawable.vegetables_detail_lettuce_lettucesalad);
		lettuce.setImage_ids(lettuceimages);
		
		lettucesounds.add(R.raw.lettuce);
		lettucesounds.add(R.raw.description_vegetables_lettuce);
		lettucesounds.add(R.raw.quiz_vegetables_lettuce);
		lettuce.setSound_ids(lettucesounds);
		
		lettucequestions.add("This leafy vegetable is one of the most popular salad vegetableb. The darkness of the leaf indicates how nutritious it is. It is a source of vitamin C, dietary fibre, beta carotene and folate.");
		lettuce.setQuestions(lettucequestions);
		
		lettuceanswers.add("Excellent, it is lettuce!");
		lettuce.setAnswers(lettuceanswers);
		foodManager.addFoodToCategory(lettuce, vegetables);
		
		Food onion = new Food();
		ArrayList<Integer> onionimages = new ArrayList<Integer>();
		ArrayList<Integer> onionsounds = new ArrayList<Integer>();
		ArrayList<String> onionquestions = new ArrayList<String>();
		ArrayList<String> onionanswers = new ArrayList<String>();
		
		onion.setName("onion");
		onion.setDescription("Onions are an excellent source of vitamin C and their green tops contain beta carotene, which is made into vitamin A in the body, and folate. They have no fat, and contain complex sugars that help the 'good' bacteria in your body.");
		onion.setId(R.drawable.img_vegetables_onion);
		
		onionimages.add(R.drawable.vegetables_detail_onion_large);
		onionimages.add(R.drawable.vegetables_detail_onion_onionplant);
		onionimages.add(R.drawable.vegetables_detail_onion_redonion);
		onionimages.add(R.drawable.vegetables_detail_onion_slicedonion);
		onion.setImage_ids(onionimages);
		
		onionsounds.add(R.raw.onion);
		onionsounds.add(R.raw.description_vegetables_onion);
		onionsounds.add(R.raw.quiz_vegetables_onion);
		onion.setSound_ids(onionsounds);
		
		onionquestions.add("This vegetable is an excellent source of vitamin C, beta carotene and folate. It has no fat, and contains complex sugars that help the 'good' bacteria in your body.");
		onion.setQuestions(onionquestions);
		
		onionanswers.add("That's right, it is onion!");
		onion.setAnswers(onionanswers);
		foodManager.addFoodToCategory(onion, vegetables);
		
		Food pepper = new Food();
		ArrayList<Integer> pepperimages = new ArrayList<Integer>();
		ArrayList<Integer> peppersounds = new ArrayList<Integer>();
		ArrayList<String> pepperquestions = new ArrayList<String>();
		ArrayList<String> pepperanswers = new ArrayList<String>();
		
		pepper.setName("pepper");
		pepper.setDescription("Bell peppers is a colorful vegetable with high leels of vitamin C, beta carotene, which is turnet to vitamin A by the bod, and vitamin E and folate. They help your immune system stay healthy, protect your bones, improve your vision, and regulate bowel movement.");
		pepper.setId(R.drawable.img_vegetables_pepper);
		
		pepperimages.add(R.drawable.vegetables_detail_pepper_large);
		pepperimages.add(R.drawable.vegetables_detail_pepper_pepperplant);
		pepperimages.add(R.drawable.vegetables_detail_pepper_pepperseeds);
		pepperimages.add(R.drawable.vegetables_detail_pepper_slicedpepper);
		pepper.setImage_ids(pepperimages);
		
		peppersounds.add(R.raw.pepper);
		peppersounds.add(R.raw.description_vegetables_pepper);
		peppersounds.add(R.raw.quiz_vegetables_pepper);
		pepper.setSound_ids(peppersounds);
		
		pepperquestions.add("These colorful vegetables contain high levels of vitamin C, beta carotene, vitamin E and folate. These components help your immune system, bones, vision, and bowel movement");
		pepper.setQuestions(pepperquestions);
		
		pepperanswers.add("Great, it is pepper!");
		pepper.setAnswers(pepperanswers);
		foodManager.addFoodToCategory(pepper, vegetables);
		
		Food potato = new Food();
		ArrayList<Integer> potatoimages = new ArrayList<Integer>();
		ArrayList<Integer> potatosounds = new ArrayList<Integer>();
		ArrayList<String> potatoquestions = new ArrayList<String>();
		ArrayList<String> potatoanswers = new ArrayList<String>();
		
		potato.setName("potato");
		potato.setDescription("Potatoes are a good source of vitamin C, potassium, dietary fibre and vitamin B3. Potassium assists in nerve and muscle function. Potatoes are carbohydrates and give you energy for physical activities and they contain ery little fat.");
		potato.setId(R.drawable.img_vegetables_potato);
		
		potatoimages.add(R.drawable.vegetables_detail_potato);
		potatoimages.add(R.drawable.vegetables_detail_potato_fries);
		potatoimages.add(R.drawable.vegetables_detail_potato_mashedpotatoes);
		potatoimages.add(R.drawable.vegetables_detail_potato_potatochips);
		potatoimages.add(R.drawable.vegetables_detail_potato_potatoplant);
		potato.setImage_ids(potatoimages);
		
		potatosounds.add(R.raw.potato);
		potatosounds.add(R.raw.description_vegetables_potato);
		potatosounds.add(R.raw.quiz_vegetables_potato);
		potato.setSound_ids(potatosounds);
		
		potatoquestions.add("These vegetables are carbohydrate which give you energy for physical actiities. They are a good source of potassium, which assists in nerve and muscle function.");
		potato.setQuestions(potatoquestions);
		
		potatoanswers.add("Very nice, it is potatoes!");
		potato.setAnswers(potatoanswers);
		foodManager.addFoodToCategory(potato, vegetables);
		
		Food tomato = new Food();
		ArrayList<Integer> tomatoimages = new ArrayList<Integer>();
		ArrayList<Integer> tomatosounds = new ArrayList<Integer>();
		ArrayList<String> tomatoquestions = new ArrayList<String>();
		ArrayList<String> tomatoanswers = new ArrayList<String>();
		
		tomato.setName("tomato");
		tomato.setDescription("Tomatoes are the richest source of lycopene, which helps prevent cancer, and a agood source of vitamin C, vitamin e, folate and dietary fibre. The deeper the red, the higher the amount of beta carotene in a tomato.");
		tomato.setId(R.drawable.img_vegetables_tomato);
		
		tomatoimages.add(R.drawable.vegetables_detail_tomato_large);
		tomatoimages.add(R.drawable.vegetables_detail_tomato_salad);
		tomatoimages.add(R.drawable.vegetables_detail_tomato_tomatojuice);
		tomatoimages.add(R.drawable.vegetables_detail_tomato_tomatoplant);
		tomato.setImage_ids(tomatoimages);
		
		tomatosounds.add(R.raw.tomato);
		tomatosounds.add(R.raw.description_vegetables_tomato);
		tomatosounds.add(R.raw.quiz_vegetables_tomato);
		tomato.setSound_ids(tomatosounds);
		
		tomatoquestions.add("This vegetable is the richest source of lycopene, a substance that helps prevent cancer. It also contains vitamin C, vitamin E, folate and dietary fibre.");
		tomato.setQuestions(tomatoquestions);
		
		tomatoanswers.add("Well done, it is tomatoes!");
		tomato.setAnswers(tomatoanswers);
		foodManager.addFoodToCategory(tomato, vegetables);
	}
}
