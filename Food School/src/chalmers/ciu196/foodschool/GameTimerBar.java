package chalmers.ciu196.foodschool;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

/* This class implements a count down
 * progress bar, to be used in the games
 * of the application.
 */
public class GameTimerBar extends CountDownTimer {

	private static final int FINISHED = 0; /* To empty the bar after count down */
	private ProgressBar progressBar;	/* The progress bar used */
	private Context context;	/* Context, used for Toasting that time is up */
	private int activity;
	
	/* Constructor */
	public GameTimerBar(Context appContext, ProgressBar bar, long startTime, long interval, int act)
	{
		super(startTime, interval);
		this.progressBar = bar;
		this.context = appContext;
		this.activity = act;
	}
	
	/* Implementing inherited methods */
	@Override
	public void onFinish() {
		PlayQuizActivity quiz = (PlayQuizActivity) PlayQuizActivity.activityInstance;
		PlayTapActivity tap = (PlayTapActivity) PlayTapActivity.activityInstance;
		/* Set the bar to 0 */
		progressBar.setProgress(FINISHED);
		Toast.makeText(context, "Time's up!", Toast.LENGTH_SHORT).show();

		if (this.getActivityThatUsesMe() == 1)
			PlayQuizActivity.cooldownTimer.start();
		else if (this.getActivityThatUsesMe() == 2)
			PlayTapActivity.tapCoolDownTimer.start();
	}

	@Override
	public void onTick(long millisUntilFinished) {
		/* Update the bar with the time remaining */
		progressBar.setProgress((int) millisUntilFinished/1000);
	}
	
	public void setActivityThatUsesMe(int act)
	{
		this.activity = act;
	}
	public int getActivityThatUsesMe()
	{
		return activity;
	}
}
