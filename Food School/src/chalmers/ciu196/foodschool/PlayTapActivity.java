package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PlayTapActivity extends Activity {
	GameTimerBar timer; /* timer is the count down timer */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_tap);
		
		ProgressBar tapProgBar = (ProgressBar) findViewById(R.id.progBarTap);
		timer = new GameTimerBar(getApplicationContext(), tapProgBar, TOTAL_TIME, INTERVAL);
	}

	@Override
	public void onResume()
	{
		super.onResume();
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
