package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class PlayCategoriesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_categories);
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
		startActivity(startQuiz);
		finish();
	}
}
