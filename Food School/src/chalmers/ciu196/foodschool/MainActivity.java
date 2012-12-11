package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


import chalmers.ciu196.foodschool.Database.DbManager;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Intent;
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
	
	// create two test objects one of class Food and one of class FoodCategory
	FoodCategory fruits = new FoodCategory("test", "test", "imgpath", "soundpath", 1);
	Food apple = new Food();
	
	// add values to the apple 
	apple.setName("apple");
	apple.setDescription("rea fruit");
	apple.setId(11);
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
	dbManager().storeFood(apple);
	
	// test object of FoodCategory created to load object from database
	FoodCategory testLoadCat = new FoodCategory();
	testLoadCat = dbManager().getCategory(fruits.getCatName());
	Log.d("Db4o", "Category "+testLoadCat.getCatName()+" was succesfully stored and retrieved from database.");
	
	// test object of Food created to load object from database
	Food testLoadFood = new Food();
	testLoadFood = dbManager().getFood(apple.getName());
	Log.d("Db4o", "Food "+testLoadFood.getName()+" was successfully stored and retrieved from database.");
	
	// End of database related code ===========================================
	
	// Code for XML creation
	XStream xstream = new XStream(new DomDriver());
	xstream.alias("food", Food.class);
	xstream.alias("category", FoodCategory.class);
	String food = xstream.toXML(apple);
	Log.d("XStream Food to XML", food);
	
	String cat = xstream.toXML(fruits);
	Log.d("XStream Category to XML", cat);
	
	
	
	
	// Read the XML file with our resources
	
	// End of code for XML creation

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
