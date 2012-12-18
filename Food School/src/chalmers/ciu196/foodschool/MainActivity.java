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
	
	auxfood.setName("lemon");
	auxfood.setDescription("Lemons are sour, citrus fruits, so you probably wil not eat one by itself. It is rich in vitamin C, which helps keep your immune system strong and prevent deseases. Its juice can be combined with sugar or honey to make delicious drinks or cure your sore throat. It is also great for improving the taste of other food.");
	auxfood.setId(R.drawable.img_fruits_lemon);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_lemon);
	auximageids.add(R.drawable.fruits_detail_lemon_large);
	auximageids.add(R.drawable.fruits_detail_lemon_lemonade);
	auximageids.add(R.drawable.fruits_detail_lemon_lemonjam);
	auximageids.add(R.drawable.fruits_detail_lemon_lemontea);
	auximageids.add(R.drawable.fruits_detail_lemon_pressedlemon);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.lemon);
	auxsoundids.add(R.raw.description_fruits_lemon);
	auxsoundids.add(R.raw.quiz_fruits_lemon);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This sour, citrus fruit might not be good to eat by itself, but its juice combines with sugar or honey to make delicious drinks. Its high content of vitamin C helps your immune system stay strong and fight diseases.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Very well, it is a lemon!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("lime");
	auxfood.setDescription("Limes have a sour tate because they are very low in sugars. They are rich in vitamin C, which helps keep away diseases. Its juice is also good for your skin. Its peel and juice are great for flavoring food.");
	auxfood.setId(R.drawable.img_fruits_lime);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_lime);
	auximageids.add(R.drawable.fruits_detail_lime_large);
	auximageids.add(R.drawable.fruits_detail_lime_limepeel);
	auximageids.add(R.drawable.fruits_detail_lime_pressedlime);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.lime);
	auxsoundids.add(R.raw.description_fruits_lime);
	auxsoundids.add(R.raw.quiz_fruits_lime);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This sour fruit is very lowin sugar but rich in vitamin C, which helps your body fight deseases. Its juice is good for your skin, also.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Great job, it is a lime!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("orange");
	auxfood.setDescription("Oranges are citruis fruits. They can be sweet or sour, depending on the variety. One orange contains enough vitamin C for two days, which help keep your immune system protecting your body from diseases. They also contain fibre and beta carotene, which is converted to vitamin A by the body and is good for your eyes.");
	auxfood.setId(R.drawable.img_fruits_orange);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_orange);
	auximageids.add(R.drawable.fruits_detail_orange_large);
	auximageids.add(R.drawable.fruits_detail_orange_orangejuice);
	auximageids.add(R.drawable.fruits_detail_orange_orangetree);
	auximageids.add(R.drawable.fruits_detail_orange_pressedorange);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.orange);
	auxsoundids.add(R.raw.description_fruits_orange);
	auxsoundids.add(R.raw.quiz_fruits_orange);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This citrus fruit can be found in many varieties, sweet or sour. One of them has enough vitamin C for two days, which is reat for your immune system.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is an orange!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("peach");
	auxfood.setDescription("Peaches are juicy, sweet and nutritious. They are a godd source of vitamin C, which helps your immune system, dietary fibre, which keeps your digestive system healthy, and beta carotene, which helps your skin and eyes stay healthy. they also contain small amounts of other vitamins and minerals.");
	auxfood.setId(R.drawable.img_fruits_peach);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_peach);
	auximageids.add(R.drawable.fruits_detail_peach_large);
	auximageids.add(R.drawable.fruits_detail_peach_cannedpeaches);
	auximageids.add(R.drawable.fruits_detail_peach_peachjuice);
	auximageids.add(R.drawable.fruits_detail_peach_peachseed);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.peach);
	auxsoundids.add(R.raw.description_fruits_peach);
	auxsoundids.add(R.raw.quiz_fruits_peach);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This juicy and sweet fruit is good for your immune system, your digestive system, your skin and your eyes.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Very well, it is a peach!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("pear");
	auxfood.setDescription("Pears are sweet and juicy. They are digestede slowly, meaning that they provide energy for a longer time than other types of food. They contain vitamin C, which helps your immune system, copper, which helps yoru brain learn and remember, and dietary fibre, which keeps your digestive system healthy.");
	auxfood.setId(R.drawable.img_fruits_pear);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_pear);
	auximageids.add(R.drawable.fruits_detail_pear_large);
	auximageids.add(R.drawable.fruits_detail_pear_pearjuice);
	auximageids.add(R.drawable.fruits_detail_pear_peartree);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.pear);
	auxsoundids.add(R.raw.description_fruits_pears);
	auxsoundids.add(R.raw.quiz_fruits_pear);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This fruit is digested slowly and provides your body with energy for a long time. It contains substances that help your immune system, your brain and your digestive system.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is a pear!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("pineapple");
	auxfood.setDescription("Pineapple is a tropical fruit with high levels of vitamin C, which helps your immune system stay strong. It also contains high levels of the mineral manganese. Manganese helps your body produce energy, keeps your bones strong and helps your body digest fat.");
	auxfood.setId(R.drawable.img_fruits_pineapple);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_pineapple);
	auximageids.add(R.drawable.fruits_detail_pineapple_large);
	auximageids.add(R.drawable.fruits_detail_pineapple_drypineapple);
	auximageids.add(R.drawable.fruits_detail_pineapple_pineapplejuice);
	auximageids.add(R.drawable.fruits_detail_pineapple_pineappleplant);
	auximageids.add(R.drawable.fruits_detail_pineapple_slicedpineapple);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.pineapple);
	auxsoundids.add(R.raw.description_fruits_pineapple);
	auxsoundids.add(R.raw.quiz_fruits_pineapple);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This tropical fruit contains high amounts of vitamin C and manganese. It helps keep your body healthy by keeping your immune system strong, helping your body produce energy and digest fat, and keeping your bones strong.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Your answer is right! It is a pineapple!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("strawberries");
	auxfood.setDescription("Strawberries are part of the berry family, lke raspeberries and blackberries. They have a high content of vitamin C, which keeps your immunes system strong, dietary fibre, which is good for your digestive system, folate, which is essential to keep the body functioning.");
	auxfood.setId(R.drawable.img_fruits_strawberries);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_strawberries);
	auximageids.add(R.drawable.fruits_detail_strawberries_large);
	auximageids.add(R.drawable.fruits_detail_strawberries_cannedstrawberries);
	auximageids.add(R.drawable.fruits_detail_strawberries_drystrawberries);
	auximageids.add(R.drawable.fruits_detail_strawberries_strawberryicecream);
	auximageids.add(R.drawable.fruits_detail_strawberries_strawberryjam);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.strawberries);
	auxsoundids.add(R.raw.description_fruits_strawberries);
	auxsoundids.add(R.raw.quiz_fruits_strawberries);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("These members of the berry family have a high content of vitamin C, dietary fibre and folate. Which means tehy contain elements that keep your immune system, digestive system and other functions in you body working properly.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is strawberries!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	auxfood.setName("watermelon");
	auxfood.setDescription("Watermelon is the refreshing fruit by excellence due to it being mostly water. It is a good source of vitamin C, which keeps your immune system strong, and beta carotene which, when transformed into vitamin A, is good for your eyes.");
	auxfood.setId(R.drawable.img_fruits_watermelon);
	auximageids.clear();
	auximageids.add(R.drawable.img_fruits_watermelon);
	auximageids.add(R.drawable.fruits_detail_watermelon_large);
	auximageids.add(R.drawable.fruits_detail_watermelon_slicedwatermelon);
	auximageids.add(R.drawable.fruits_detail_watermelon_watermelonjuice);
	auximageids.add(R.drawable.fruits_detail_watermelon_watermelonsherbet);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.watermelon);
	auxsoundids.add(R.raw.description_fruits_watermelon);
	auxsoundids.add(R.raw.quiz_fruits_watermelon);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This refreshing fruit is a good source of vitamin C and beta carotene. These two substances help your body fight diseases and your eyes stay strong.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Really nice! It is a watermelon!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, fruits);
	
	//--------------PROTEIN-------------------
	auxfood.setName("beef");
	auxfood.setDescription("Beef is the name of meat from cattle. A variety of products com from beef. Beef is an excellent source of complete protein and vital minerals such as zinc, selenium, phosphorus and iron, and B vitamins.");
	auxfood.setId(R.drawable.img_protein_beef);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_beef);
	auximageids.add(R.drawable.protein_detail_beef_large);
	auximageids.add(R.drawable.protein_detail_beef_cow);
	auximageids.add(R.drawable.protein_detail_beef_meatballs);
	auximageids.add(R.drawable.protein_detail_beef_skeweredmeat);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.beef);
	auxsoundids.add(R.raw.description_protein_beef);
	auxsoundids.add(R.raw.quiz_protein_beef);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This meat comes from cattle and it is used for a variety of products. As all types of meat, it is a source of protein. It also contains several vital minerals, such as iron.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is a beef!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	auxfood.setName("chicken");
	auxfood.setDescription("Poultry is the second most widely eatin meat in the world. Most commonly, it refers to chicken but it also comes from duck and turkey, among others. You must cook chicken before you eat it becaus it could contain salmonella. Chicken is a good source of protein, calcium and potassium.");
	auxfood.setId(R.drawable.img_protein_chicken);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_chicken);
	auximageids.add(R.drawable.protein_detail_chicken_large);
	auximageids.add(R.drawable.protein_detail_chicken_bakedchicken);
	auximageids.add(R.drawable.protein_detail_chicken_chicken);
	auximageids.add(R.drawable.protein_detail_chicken_chickensoup);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.chicken);
	auxsoundids.add(R.raw.description_protein_chicken);
	auxsoundids.add(R.raw.quiz_protein_chicken);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This is the second most widely eaten meat in the world. You must always cook it carefully because you might get sick otherwise. It is a good source of protein, calcium and potassium.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is chicken!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	auxfood.setName("eggs");
	auxfood.setDescription("Chicken eggs are the most commonly eaten eggs. They supply all essential amino acids for humans and provide several vitamins and minerals, like choline, which helps regulate the brain, nervous system, and cardiovascular system.");
	auxfood.setId(R.drawable.img_protein_egg);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_egg);
	auximageids.add(R.drawable.protein_detail_egg_large);
	auximageids.add(R.drawable.protein_detail_egg_boiledegg);
	auximageids.add(R.drawable.protein_detail_egg_friedegg);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.eggs);
	auxsoundids.add(R.raw.description_protein_eggs);
	auxsoundids.add(R.raw.quiz_protein_eggs);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This protein source supply all essential amino acids for humans and provides several vitamins and minerals. Choline, for example, helsp regulate the brain, nervous system, and cardiovascular system.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("You are right, it is eggs!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	auxfood.setName("fish");
	auxfood.setDescription("Fish provides a good source of high quality protein and contains many vitamins and minerals. Some types of fish are good for your heart and brains because they contain omega 3 fatty acids.");
	auxfood.setId(R.drawable.img_protein_fish);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_fish);
	auximageids.add(R.drawable.protein_detail_fish_large);
	auximageids.add(R.drawable.protein_detail_fish_cookedfish);
	auximageids.add(R.drawable.protein_detail_fish_friedfish);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.fish);
	auxsoundids.add(R.raw.description_protein_fish);
	auxsoundids.add(R.raw.quiz_protein_fish);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This protein source provides high quality protein and contains many vitamins and mineral. it also contains Omega 3, which is good for your heart and brain.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is fish!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	auxfood.setName("pork");
	auxfood.setDescription("Pork is the name for meat from domestic pig. It is mostly eaten cooked and often cured into ham and similar products. Pork should be eaten with moderation because of its high conten of 'bad' fat.");
	auxfood.setId(R.drawable.img_protein_pork);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_pork);
	auximageids.add(R.drawable.protein_detail_pork_large);
	auximageids.add(R.drawable.protein_detail_pork_bacon);
	auximageids.add(R.drawable.protein_detail_pork_pig);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.pork);
	auxsoundids.add(R.raw.description_protein_pork);
	auxsoundids.add(R.raw.quiz_protein_pork);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This protein source should be eaten with moderation, due to its high content of 'bad' fat. It is mostly eaten cooked and it is often cured into ham and similar products.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is pork!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	auxfood.setName("sausage");
	auxfood.setDescription("Sausages are usually made of different kinds of ground meat, either beef, pork or poultry, in a tight casing. There are a lot of different kinds depending on the region or country. Its nutritional value depends on what it is mde from. It usually contains other ingredients along with meat.");
	auxfood.setId(R.drawable.img_protein_sausage);
	auximageids.clear();
	auximageids.add(R.drawable.img_protein_sausage);
	auximageids.add(R.drawable.protein_detail_sausage_large);
	auximageids.add(R.drawable.protein_detail_sausage_hotdog);
	auximageids.add(R.drawable.protein_detail_sausage_sausage1);
	auximageids.add(R.drawable.protein_detail_sausage_sausage2);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.sausage);
	auxsoundids.add(R.raw.description_protein_sausage);
	auxsoundids.add(R.raw.quiz_protein_sausage);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This protein product can be made of different kinds of ground meat in a tight casing. There are a lot of different types depending on the region or country. Its nutritional value depends on the ingredients it is made from.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Good job, it is sausage!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, meats);
	
	//--------------PROTEIN-------------------
	auxfood.setName("broccoli");
	auxfood.setDescription("Broccoli is a bush-shaped vegetable that contains a lot of nutritious substances. It is rich source of itamin C, which keeps your immune system strong and might help prevent cancer. Broccoli is also good for your heart, skin, bones and respiratory system.");
	auxfood.setId(R.drawable.img_vegetables_broccoli);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_broccoli);
	auximageids.add(R.drawable.vegetables_detail_broccoli_large);
	auximageids.add(R.drawable.vegetables_detail_broccoli_broccoliplant);
	auximageids.add(R.drawable.vegetables_detail_broccoli_broccolisalad);
	auximageids.add(R.drawable.vegetables_detail_broccoli_broccolisoup);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.broccoli);
	auxsoundids.add(R.raw.description_vegetables_broccoli);
	auxsoundids.add(R.raw.quiz_vegetables_broccoli);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This bush-shaped vegetable contains a lot of nutrients, like vitamin C, which helps your immune system and might helps prevent cancer. It is also good for your heart, skin, bones and respiratory system.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is broccoli!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("cabbage");
	auxfood.setDescription("Cabbage is a leafy vegetable. It contains vitamins and minerals, which help your digestive system, immune system, eyes, skin, and heart. It contains vitamin C, sulphur, iodine, and it is rich in fibre.");
	auxfood.setId(R.drawable.img_vegetables_cabbage);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_cabbage);
	auximageids.add(R.drawable.vegetables_detail_cabbage_large);
	auximageids.add(R.drawable.vegetables_detail_cabbage_cabbageinside);
	auximageids.add(R.drawable.vegetables_detail_cabbage_redcabbage);
	auximageids.add(R.drawable.vegetables_detail_cabbage_shreddedcabbage);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.cabbage);
	auxsoundids.add(R.raw.description_vegetables_cabbage);
	auxsoundids.add(R.raw.quiz_vegetables_cabbage);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This leafy vegetable is good for your digestive system, immune system, eyes, skin and heart.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Of course it is a cabbage!Well done!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("carrot");
	auxfood.setDescription("Carrots are a rich source of beta carotene, which the body converts to vitamin A. Vitamin A helps with night vision. They are a good source of dietary fibre, which helps your heart and your digestive system.");
	auxfood.setId(R.drawable.img_vegetables_carrot);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_carrot);
	auximageids.add(R.drawable.vegetables_detail_carrot_large);
	auximageids.add(R.drawable.vegetables_detail_carrot_carrrotcake);
	auximageids.add(R.drawable.vegetables_detail_carrot_carrotstick);
	auximageids.add(R.drawable.vegetables_detail_carrot_shreddedcarrot);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.carrot);
	auxsoundids.add(R.raw.description_vegetables_carrot);
	auxsoundids.add(R.raw.quiz_vegetables_carrot);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable is a rich source of beta carotene, which turns into vitamin A and helps your vision. It is also good for your heart and your digestive system.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Yes you are right, it is a carrot!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("celery");
	auxfood.setDescription("Eating celery helps clean your mouth and teeth. Celery contains vitamins, minerals and dietary fibre, which help regulate bowel movement, and relief anxiety.");
	auxfood.setId(R.drawable.img_vegetables_celery);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_celery);
	auximageids.add(R.drawable.vegetables_detail_celery_large);
	auximageids.add(R.drawable.vegetables_detail_celery_celerystem);
	auximageids.add(R.drawable.vegetables_detail_celery_celerysticks);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.celery);
	auxsoundids.add(R.raw.description_vegetables_celery);
	auxsoundids.add(R.raw.quiz_vegetables_celery);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable helps clear your mouth and teeth. It also regulates bowel movement and reliefs anxiety.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is celery!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("cucumber");
	auxfood.setDescription("Cucumbers are mostly water, which is the reason they are so refreshing. They have small amounts of vitamins, like vitamins K and C, and minerasl, like calcium, iron and potassium.");
	auxfood.setId(R.drawable.img_vegetables_cucumber);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_cucumber);
	auximageids.add(R.drawable.vegetables_detail_cucumber_large);
	auximageids.add(R.drawable.vegetables_detail_cucumber_cucumberplant);
	auximageids.add(R.drawable.vegetables_detail_cucumber_slicedcucumber);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.cucumber);
	auxsoundids.add(R.raw.description_vegetables_cucumber);
	auxsoundids.add(R.raw.quiz_vegetables_cucumber);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This refreshing vegetable is mostly water. It contains small amounts of vitamins and minerals, like vitamin K, vitamin C, iron, calcium and potassium.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is cucumber!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("eggplant");
	auxfood.setDescription("Eggplant is a top source of vitamin B6, which is important for your blood, brain and other tissues in your body. It is also a good source of dietary fibre and antioxidants.");
	auxfood.setId(R.drawable.img_vegetables_eggplant);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_eggplant);
	auximageids.add(R.drawable.vegetables_detail_eggplant_large);
	auximageids.add(R.drawable.vegetables_detail_eggplant_eggplantplant);
	auximageids.add(R.drawable.vegetables_detail_eggplant_slicedeggplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.eggplant);
	auxsoundids.add(R.raw.description_vegetables_eggplant);
	auxsoundids.add(R.raw.quiz_vegetables_eggplant);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable is a top source of vitamin B6, which is important for oyur blood, brain and other tissues in your body.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Very well, it is eggplant!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("garlic");
	auxfood.setDescription("In high quantities, garlic is a good source of dietary fibre, potassium, iron, zinc and vitamin C. They are rarely eaten in high quantities but are often use to add taste to other foods.");
	auxfood.setId(R.drawable.img_vegetables_garlic);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_garlic);
	auximageids.add(R.drawable.vegetables_detail_garlic_large);
	auximageids.add(R.drawable.vegetables_detail_garlic_garlicclove);
	auximageids.add(R.drawable.vegetables_detail_garlic_garlicplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.garlic);
	auxsoundids.add(R.raw.description_vegetables_garlic);
	auxsoundids.add(R.raw.quiz_vegetables_garlic);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable is a good source of dietary fibre, potassium, vitamin C, and other nutrients. It is rarely eaten in high quantities, though, and it is often use to add taste to other foods.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Good job, it is garlic!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("lettuce");
	auxfood.setDescription("Lettuce is one of the most popular salad vegetables. the darker the lettuce leaf the more nutritious it is. Lettuce is mostly made of water which is why it is so refreshing. It is a source of vitamin C, dietary fibre, beta carotene and folate.");
	auxfood.setId(R.drawable.img_vegetables_lettuce);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_lettuce);
	auximageids.add(R.drawable.vegetables_detail_lettuce_large);
	auximageids.add(R.drawable.vegetables_detail_lettuce_lettuceplant);
	auximageids.add(R.drawable.vegetables_detail_lettuce_lettucesalad);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.lettuce);
	auxsoundids.add(R.raw.description_vegetables_lettuce);
	auxsoundids.add(R.raw.quiz_vegetables_lettuce);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This leafy vegetable is one of the most popular salad vegetableb. The darkness of the leaf indicates how nutritious it is. It is a source of vitamin C, dietary fibre, beta carotene and folate.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Excellent, it is lettuce!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("onion");
	auxfood.setDescription("Onions are an excellent source of vitamin C and their green tops contain beta carotene, which is made into vitamin A in the body, and folate. They have no fat, and contain complex sugars that help the 'good' bacteria in your body.");
	auxfood.setId(R.drawable.img_vegetables_onion);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_onion);
	auximageids.add(R.drawable.vegetables_detail_onion_large);
	auximageids.add(R.drawable.vegetables_detail_onion_onionplant);
	auximageids.add(R.drawable.vegetables_detail_onion_redonion);
	auximageids.add(R.drawable.vegetables_detail_onion_slicedonion);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.onion);
	auxsoundids.add(R.raw.description_vegetables_onion);
	auxsoundids.add(R.raw.quiz_vegetables_onion);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable is an excellent source of vitamin C, beta carotene and folate. It has no fat, and contains complex sugars that help the 'good' bacteria in your body.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("That's right, it is onion!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("pepper");
	auxfood.setDescription("Bell peppers is a colorful vegetable with high leels of vitamin C, beta carotene, which is turnet to vitamin A by the bod, and vitamin E and folate. They help your immune system stay healthy, protect your bones, improve your vision, and regulate bowel movement.");
	auxfood.setId(R.drawable.img_vegetables_pepper);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_pepper);
	auximageids.add(R.drawable.vegetables_detail_pepper_large);
	auximageids.add(R.drawable.vegetables_detail_pepper_pepperplant);
	auximageids.add(R.drawable.vegetables_detail_pepper_pepperseeds);
	auximageids.add(R.drawable.vegetables_detail_pepper_slicedpepper);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.pepper);
	auxsoundids.add(R.raw.description_vegetables_pepper);
	auxsoundids.add(R.raw.quiz_vegetables_pepper);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("These colorful vegetables contain high levels of vitamin C, beta carotene, vitamin E and folate. These components help your immune system, bones, vision, and bowel movement");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Great, it is pepper!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("potato");
	auxfood.setDescription("Potatoes are a good source of vitamin C, potassium, dietary fibre and vitamin B3. Potassium assists in nerve and muscle function. Potatoes are carbohydrates and give you energy for physical activities and they contain ery little fat.");
	auxfood.setId(R.drawable.img_vegetables_potato);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_potato);
	auximageids.add(R.drawable.vegetables_detail_potato);
	auximageids.add(R.drawable.vegetables_detail_potato_fries);
	auximageids.add(R.drawable.vegetables_detail_potato_mashedpotatoes);
	auximageids.add(R.drawable.vegetables_detail_potato_potatochips);
	auximageids.add(R.drawable.vegetables_detail_potato_potatoplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.potato);
	auxsoundids.add(R.raw.description_vegetables_potato);
	auxsoundids.add(R.raw.quiz_vegetables_potato);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("These vegetables are carbohydrate which give you energy for physical actiities. They are a good source of potassium, which assists in nerve and muscle function.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Very nice, it is potatoes!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
	
	auxfood.setName("tomato");
	auxfood.setDescription("Tomatoes are the richest source of lycopene, which helps prevent cancer, and a agood source of vitamin C, vitamin e, folate and dietary fibre. The deeper the red, the higher the amount of beta carotene in a tomato.");
	auxfood.setId(R.drawable.img_vegetables_tomato);
	auximageids.clear();
	auximageids.add(R.drawable.img_vegetables_tomato);
	auximageids.add(R.drawable.vegetables_detail_tomato_large);
	auximageids.add(R.drawable.vegetables_detail_tomato_salad);
	auximageids.add(R.drawable.vegetables_detail_tomato_tomatojuice);
	auximageids.add(R.drawable.vegetables_detail_tomato_tomatoplant);
	auxfood.setImage_ids(auximageids);
	auxsoundids.clear();
	auxsoundids.add(R.raw.tomato);
	auxsoundids.add(R.raw.description_vegetables_tomato);
	auxsoundids.add(R.raw.quiz_vegetables_tomato);
	auxfood.setSound_ids(auxsoundids);
	auxquestions.clear();
	auxquestions.add("This vegetable is teh richest source of lycopene, a substance that helps prevent cancer. It also contains vitamin C, vitamin E, folate and dietary fibre.");
	auxfood.setQuestions(auxquestions);
	auxanswers.clear();
	auxanswers.add("Well done, it is tomatoes!");
	auxfood.setAnswers(auxanswers);
	foodManager.addFoodToCategory(auxfood, vegetables);
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
