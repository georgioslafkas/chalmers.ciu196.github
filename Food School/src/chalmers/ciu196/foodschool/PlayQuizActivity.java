package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PlayQuizActivity extends Activity {
	GameTimerBar timer; /* timer is the count down timer */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	
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
		
		/* Retrieve the progress bar from the UI */
		ProgressBar quizProgBar = (ProgressBar) findViewById(R.id.progBarQuiz);
		/* Set the count down bar */
		timer = new GameTimerBar(getApplicationContext(), quizProgBar, TOTAL_TIME, INTERVAL);
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		/* Start the count down */
		timer.start();
	}

	@Override
	public void onPause()
	{
		super.onPause();
		/* Cancel the count down */
		timer.cancel();
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		timer.cancel();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_quiz, menu);
		return true;
	}

}
