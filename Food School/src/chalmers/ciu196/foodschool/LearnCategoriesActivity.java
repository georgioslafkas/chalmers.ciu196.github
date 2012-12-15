package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class LearnCategoriesActivity extends Activity {
	private final int FRUITS = 1,
					  VEGETABLES = 2,
					  MEAT = 3,
					  DAIRY = 4,
					  CEREALS = 5;
	
	private final int firstFood = 0;
	public static int categoryToLearn = -1;				  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_categories);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_learn_categories, menu);
		return true;
	}

	/* Click handler that takes you to the food activity
	 * that displays all the different foods.
	 * NOTE: This should send extra info in order to
	 * start the activity with the proper content,
	 * e.g. tapping "Fruit" should fill the grid
	 * with the fruits etc.
	 */
	public void startLearnFoodActivity(View v)
	{
		Intent startFood = new Intent(this, LearnFoodActivity.class);
		startFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startFood.putExtra("currentFood", firstFood); /* Send along the first index */
		/* Determine which button the user tapped */
		switch (v.getId())
		{
			case R.id.btnFruit:
				/* Set the respective category */
				categoryToLearn = FRUITS;
				break;	
			case R.id.btnVegetables:
				/* Set the respective category */
				categoryToLearn = VEGETABLES;
				break;
			case R.id.btnMeat:
				/* Set the respective category */
				categoryToLearn = MEAT;
				break;
			case R.id.btnDairy:
				/* Set the respective category */
				categoryToLearn = DAIRY;
				break;
			case R.id.btnCereals:
				/* Set the respective category */
				categoryToLearn = CEREALS;
				break;
			default:
				break;
		}
		startActivity(startFood);
	}
	/* Home button listener */
	public void goHome(View v)
	{
		Intent goHome = new Intent(this, MainActivity.class);
		goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goHome);
	}
}
