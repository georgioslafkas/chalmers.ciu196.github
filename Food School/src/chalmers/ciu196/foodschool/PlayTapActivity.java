package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;

public class PlayTapActivity extends Activity {
	GameTimerBar timer; /* timer is the count down timer */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	private static final int COOL_DOWN = 3000; /* 3 seconds cool down till next quiz */
	private final int NOT_FOUND = -1; /* If extras sent along aren't found */
	public static CoolDownTimer tapCoolDownTimer; /* a cool down timer for this activity */
	
	ArrayList<Food> foods = new ArrayList<Food>(); /* the list of foods for the category selected */
	public int currentFood; /* current food index, used inside the list */
	Intent goToPlayQuiz; /* the intent that takes us back to the quiz activity */
	public static Activity activityInstance = null; /* an instance of this activity, used in the cool down timer */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_tap);
		
		PlayTapActivity.activityInstance = this;	/* Initialize the instance of this activity */
		/* Set timers and progress bar */
		ProgressBar tapProgBar = (ProgressBar) findViewById(R.id.progBarTap);
		timer = new GameTimerBar(getApplicationContext(), tapProgBar, TOTAL_TIME, INTERVAL, 2);
		tapCoolDownTimer = new CoolDownTimer(COOL_DOWN, INTERVAL, 2);
		tapCoolDownTimer.setActivityThatUsesMe(2);
	}

	@Override
	public void onResume()
	{
		super.onResume();
		/* Initialize the intent that takes back to the quiz */
		goToPlayQuiz = new Intent(this, PlayQuizActivity.class);
		goToPlayQuiz.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		/* Retrieve the intent that brought us here,
		 * to gain access to the extras that were
		 * sent along
		 */
		Intent startedThis = getIntent();
		/* Retrieve the extra information */
		ArrayList<Food> foods = (ArrayList<Food>) startedThis.getSerializableExtra("foodlist");
		currentFood = startedThis.getIntExtra("currentFood", NOT_FOUND);
		
		/* Send the extra information back to quiz,
		 * after having incremented the current food
		 * index, so that it will load the next food
		 * from the list
		 */
		goToPlayQuiz.putExtra("foodlist", foods);
		currentFood++;
		goToPlayQuiz.putExtra("currentFood", currentFood);
		
		/* Start the timer for this game */
		timer.start();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
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
		getMenuInflater().inflate(R.menu.activity_play_tap, menu);
		return true;
	}
}//end class
