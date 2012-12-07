package chalmers.ciu196.foodschool;

import android.content.Context;
import android.os.CountDownTimer;
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
	
	/* Constructor */
	public GameTimerBar(Context appContext, ProgressBar bar, long startTime, long interval)
	{
		super(startTime, interval);
		this.progressBar = bar;
		this.context = appContext;
	}

	/* Implementing inherited methods */
	@Override
	public void onFinish() {
		/* Set the bar to 0 */
		progressBar.setProgress(FINISHED);
		Toast.makeText(context, "Time's up!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTick(long millisUntilFinished) {
		/* Update the bar with the time remaining */
		progressBar.setProgress((int) millisUntilFinished/1000);
	}
	
}
