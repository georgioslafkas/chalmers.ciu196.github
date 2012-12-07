package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PlayTapActivity extends Activity {
	ProgressBar tapProgBar;
	int progress = 0;
	GameCountDownTimer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_tap);
		
		tapProgBar = (ProgressBar) findViewById(R.id.progBarTap);
		tapProgBar.setProgress(progress);
		
		timer = new GameCountDownTimer(10000, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_tap, menu);
		return true;
	}
	
	/* Implementing count down timer class as an inner class */
	public class GameCountDownTimer extends CountDownTimer {
		Context context;
		public GameCountDownTimer(long startTime, long interval)
		{
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			tapProgBar.setProgress(progress);
			Toast.makeText(context.getApplicationContext(), "Time's up!", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onTick(long millisUntilFinished) {
			progress++;
			tapProgBar.setProgress(progress);
		}
	}//end inner class
}//end class
