package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class LearnFoodActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_food);
		
		/* Get the intent that started this activity */
		Intent startedThis = getIntent();
		/* Retrieve which category was tapped, by reading the
		 * string that was sent with
		 */
		String categoryToShow = startedThis.getStringExtra("category");
		Toast.makeText(this, categoryToShow, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_learn_food, menu);
		return true;
	}
	
	/* Click handler that takes you to the detail
	 * activity for a specific food.
	 * NOTE: This should send extra info in order to
	 * start the activity with the proper content,
	 * e.g. tapping "Apple" should bring the 
	 * information on apples etc.
	 */
	public void startDetailActivity(View v)
	{
		Intent startDetailFood = new Intent(this, LearnDetailActivity.class);
		startDetailFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startDetailFood);
		//finish();
	}

}
