package chalmers.ciu196.foodschool;



import android.os.CountDownTimer;

/* This class implements a timer that counts
 * till the next question will be displayed.
 */
public class CoolDownTimer extends CountDownTimer {
	private int timesFinished = 0; /* how many times this timer has finished,
									* this will indicate how many questions
									* have been displayed */
	private int activity;
	/* Constructor */
	public CoolDownTimer(long startTime, long interval, int act)
	{
		super(startTime, interval);
		this.activity = act;
	}


	/* Implementing inherited methods */
	@Override
	public void onFinish() {
		/* When this timer finishes, it's time for
		 * the count down timer to start, since the next
		 * question is displayed.
		 */
		//PlayQuizActivity.timer.start();
		/* Get an instance of the quiz activity */
		PlayQuizActivity quiz = (PlayQuizActivity) PlayQuizActivity.activityInstance;
		PlayTapActivity tap = (PlayTapActivity) PlayTapActivity.activityInstance;
		/* Use it to call the loadNextQuestion function inside PlayActivity.
		 * Increase timesFinished and use it to fetch the next question in the list.
		 */
			timesFinished++;
			if (this.getActivityThatUsesMe() == 1)
				quiz.startActivity(quiz.goToPlayTap);
			else if (this.getActivityThatUsesMe() == 2)
				tap.startActivity(tap.goToPlayQuiz);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		/* Nothing for now */
	}
	
	public void setActivityThatUsesMe(int act)
	{
		this.activity = act;
	}
	public int getActivityThatUsesMe()
	{
		return activity;
	}


	public int getTimesFinished() {
		return timesFinished;
	}
}

