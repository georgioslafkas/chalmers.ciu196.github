package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class PlayQuizActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_quiz);
		
		/* Get the intent that started this activity */
		Intent startedThis = getIntent();
		/* Retrieve which category was tapped, by reading the
		 * string that was sent with
		 */
		String categoryToPlay = startedThis.getStringExtra("category");
		Toast.makeText(this, categoryToPlay, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_quiz, menu);
		return true;
	}

}
