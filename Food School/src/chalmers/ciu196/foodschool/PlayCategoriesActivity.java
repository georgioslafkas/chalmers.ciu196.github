package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class PlayCategoriesActivity extends Activity {
	/* These variables represent the category of food
	 * the user can choose to play with */
	private final int FRUITS = 1,
					  VEGETABLES = 2,
					  MEAT = 3,
					  DAIRY = 4,
					  CEREALS = 5,
					  ALL = 6;
	
	private final int firstFood = 0;	/* Starting index in food list is always 0 */
	public static int categoryToPlay = -1; /* Category picked
											* Static, because we need it
											* in other activities */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_categories);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		stopService(new Intent(this,MediaServiceB.class));
		stopService(new Intent(this,MediaServiceA.class));

	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
	}
	
	@Override
	public void onRestart()
	{
		super.onRestart();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_categories, menu);
		return true;
	}
	
	/* Click handler that takes you to the quiz activity
	 * for that type of food that you choose.
	 * NOTE: This should send extra info in order to
	 * start the activity with the proper content,
	 * e.g. tapping "Fruit" should start the fruit quiz etc.
	 */
	public void startPlayQuizActivity(View v)
	{
		Intent startQuiz = new Intent(this, PlayQuizActivity.class);
		startQuiz.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startQuiz.putExtra("currentFood", firstFood); /* Send along the first index */
		/* Determine which button the user tapped */
		switch (v.getId())
		{
			case R.id.btnFruit:
				/* Set the respective category */
				categoryToPlay = FRUITS;
				break;	
			case R.id.btnVegetables:
				/* Set the respective category */
				categoryToPlay = VEGETABLES;
				break;
			case R.id.btnMeat:
				/* Set the respective category */
				categoryToPlay = MEAT;
				break;
			case R.id.btnDairy:
				/* Set the respective category */
				categoryToPlay = DAIRY;
				break;
			case R.id.btnCereals:
				/* Set the respective category */
				categoryToPlay = CEREALS;
				break;
			case R.id.btnAll:
				/* Set the respective category */
				categoryToPlay = ALL;
				break;
			default:
				break;
		}
		startActivity(startQuiz);
	}
}
