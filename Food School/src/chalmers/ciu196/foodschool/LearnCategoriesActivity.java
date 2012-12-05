package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LearnCategoriesActivity extends Activity {

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
		startActivity(startFood);
		//finish();
	}
}
