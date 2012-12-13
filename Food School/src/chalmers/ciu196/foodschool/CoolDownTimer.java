package chalmers.ciu196.foodschool;

import android.os.CountDownTimer;

/* This class implements a timer that counts
 * till the next question will be displayed.
 */
public class CoolDownTimer extends CountDownTimer {
	private int timesFinished = 0; /* how many times this timer has finished,
									* this will indicate how many questions
									* have been displayed */
	/* Constructor */
	public CoolDownTimer(long startTime, long interval)
	{
		super(startTime, interval);
	}


	/* Implementing inherited methods */
	@Override
	public void onFinish() {
		/* When this timer finishes, it's time for
		 * the count down timer to start, since the next
		 * question is displayed.
		 */
		PlayQuizActivity.timer.start();
		/* Get an instance of the quiz activity */
		PlayQuizActivity quiz = (PlayQuizActivity) PlayQuizActivity.activityInstance;
		/* Use it to call the loadNextQuestion function inside PlayActivity.
		 * Increase timesFinished and use it to fetch the next question in the list.
		 */
		 timesFinished++;
		quiz.loadNextQuestion(quiz.foods, timesFinished);
		quiz.setPossibleAnswers(quiz.categoryToPlay, quiz.foods, timesFinished);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		/* Nothing for now */
	}
}

