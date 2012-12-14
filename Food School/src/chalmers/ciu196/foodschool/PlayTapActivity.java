package chalmers.ciu196.foodschool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PlayTapActivity extends Activity {
	public static GameTimerBar timer; /* timer is the count down timer */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	private static final int COOL_DOWN = 3000; /* 3 seconds cool down till next quiz */
	private final int NOT_FOUND = -1; /* If extras sent along aren't found */
	public static CoolDownTimer tapCoolDownTimer; /* a cool down timer for this activity */
	
	private static Random randomNo = new Random();
	ArrayList<Food> foods = new ArrayList<Food>(); /* the list of foods for the category selected */
	public int currentFood; /* current food index, used inside the list */
	Intent goToPlayQuiz; /* the intent that takes us back to the quiz activity */
	Intent goToEndGame; /* the intent that takes us to the end game screen */
	public static Activity activityInstance = null; /* an instance of this activity, used in the cool down timer */
	public Object correctAnswer = new Object(), wrongAnswer = new Object();
	public final int POSSIBLE_WRONG_ANSWERS = 7;
	
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
		foods = (ArrayList<Food>) startedThis.getSerializableExtra("foodlist");
		currentFood = startedThis.getIntExtra("currentFood", NOT_FOUND);
		
		/* Send the extra information back to quiz,
		 * after having incremented the current food
		 * index, so that it will load the next food
		 * from the list
		 */
		goToPlayQuiz.putExtra("foodlist", foods);
		setFoodToLookFor(foods, currentFood);
		setFoodButtons(currentFood, makeWrongImageList(currentFood, foods));
		/* Always increment AFTER all the methods
		 * for the tap game have been called
		 */
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
		if (currentFood == foods.size())
		{
			currentFood = 0;
			goToEndGame = new Intent(this, PlayEndActivity.class);
			goToEndGame.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(goToEndGame);
			finish();
		}
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		timer.cancel();
		if (currentFood == foods.size())
		{
			currentFood = 0;
			goToEndGame = new Intent(this, PlayEndActivity.class);
			goToEndGame.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(goToEndGame);
			finish();
		};
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_tap, menu);
		return true;
	}
	
	/* This method changes the icon
	 * on the bottom, which shows
	 * the food to look for in the
	 * grid
	 */
	public void setFoodToLookFor(ArrayList<Food> foods, int currentFood)
	{
		ImageButton btnToLookFor = (ImageButton) findViewById(R.id.btnLookFor);
		btnToLookFor.setImageResource(foods.get(currentFood).getId());
	}
	
	/* Generate a random number, 1-8 */
	public int generateRandomNumber()
	{
		return randomNo.nextInt(8)+1;
	}
	
	/* This method creates a list with random images.
	 * Those images are of foods different from the
	 * food currently in question, and are used on
	 * the buttons that are the wrong answers for
	 * the question.
	 */
	public ArrayList<Integer> makeWrongImageList(int currentFood, ArrayList<Food> foods)
	{
		/* List with the images (ids in the drawable folder) */
		ArrayList<Integer> wrongAnswerImages = new ArrayList<Integer>();
		/* A copy of the food list */
		ArrayList<Food> tempFoodList = new ArrayList<Food>(foods);
		
		/* Remove the food in question from this list 
		 * and shuffle it*/
		tempFoodList.remove(currentFood);
		Collections.shuffle(tempFoodList);
		
		/* Loop through the copy of the food list
		 * and add the images of those objects to
		 * the list with the images
		 */
		/* **************** UNCOMMENT THE LOOP WHEN DATABASE IS COMPLETE ************************* */
		/*for (int i = 0; i < POSSIBLE_WRONG_ANSWERS; i++)
			wrongAnswerImages.add(tempFoodList.get(i).getId()); */
		
		/* Return the list with the 3 wrong images */
		return wrongAnswerImages;
	}
	
	/* Set all the image buttons on the grid,
	 * works similarly to the PlayQuiz activity
	 * method
	 */
	public void setFoodButtons(int currentFood, List<Integer> wrongAnswerImages)
	{
		ImageButton btnTap1 = (ImageButton) findViewById(R.id.btnTap1);
		ImageButton btnTap2 = (ImageButton) findViewById(R.id.btnTap2);
		ImageButton btnTap3 = (ImageButton) findViewById(R.id.btnTap3);
		ImageButton btnTap4 = (ImageButton) findViewById(R.id.btnTap4);
		ImageButton btnTap5 = (ImageButton) findViewById(R.id.btnTap5);
		ImageButton btnTap6 = (ImageButton) findViewById(R.id.btnTap6);
		ImageButton btnTap7 = (ImageButton) findViewById(R.id.btnTap7);
		ImageButton btnTap8 = (ImageButton) findViewById(R.id.btnTap8);
		int correctButton = generateRandomNumber();
		
		switch (correctButton)
		{
			case 1:
				btnTap1.setTag(correctAnswer);
				btnTap1.setImageResource(foods.get(currentFood).getId());
				btnTap2.setTag(wrongAnswer);
				btnTap2.setImageResource(wrongAnswerImages.get(0));
				btnTap3.setTag(wrongAnswer);
				btnTap3.setImageResource(wrongAnswerImages.get(1));
				btnTap4.setTag(wrongAnswer);
				btnTap4.setImageResource(wrongAnswerImages.get(2));
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 2:
				btnTap1.setTag(wrongAnswer);
				btnTap1.setImageResource(wrongAnswerImages.get(0));
				btnTap2.setTag(correctAnswer);
				btnTap2.setImageResource(foods.get(currentFood).getId());
				btnTap3.setTag(wrongAnswer);
				btnTap3.setImageResource(wrongAnswerImages.get(1));
				btnTap4.setTag(wrongAnswer);
				btnTap4.setImageResource(wrongAnswerImages.get(2));
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 3:
				btnTap1.setTag(wrongAnswer);
				btnTap1.setImageResource(wrongAnswerImages.get(0));
				btnTap2.setTag(wrongAnswer);
				btnTap2.setImageResource(wrongAnswerImages.get(1));
				btnTap3.setTag(correctAnswer);
				btnTap3.setImageResource(foods.get(currentFood).getId());
				btnTap4.setTag(wrongAnswer);
				btnTap4.setImageResource(wrongAnswerImages.get(2));
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 4:
				btnTap1.setTag(wrongAnswer);
				btnTap1.setImageResource(wrongAnswerImages.get(0));
				btnTap2.setTag(wrongAnswer);
				btnTap2.setImageResource(wrongAnswerImages.get(1));
				btnTap3.setTag(wrongAnswer);
				btnTap3.setImageResource(wrongAnswerImages.get(2));
				btnTap4.setTag(correctAnswer);
				btnTap4.setImageResource(foods.get(currentFood).getId());
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 5:
				btnTap1.setTag(wrongAnswer);
				btnTap2.setTag(wrongAnswer);
				btnTap3.setTag(wrongAnswer);
				btnTap4.setTag(wrongAnswer);
				btnTap5.setTag(correctAnswer);
				btnTap5.setImageResource(foods.get(currentFood).getId());
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 6:
				btnTap1.setTag(wrongAnswer);
				btnTap2.setTag(wrongAnswer);
				btnTap3.setTag(wrongAnswer);
				btnTap4.setTag(wrongAnswer);
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(correctAnswer);
				btnTap6.setImageResource(foods.get(currentFood).getId());
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(wrongAnswer);
				break;
			case 7:
				btnTap1.setTag(wrongAnswer);
				btnTap2.setTag(wrongAnswer);
				btnTap3.setTag(wrongAnswer);
				btnTap4.setTag(wrongAnswer);
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(correctAnswer);
				btnTap7.setImageResource(foods.get(currentFood).getId());
				btnTap8.setTag(wrongAnswer);
				break;
			case 8:
				btnTap1.setTag(wrongAnswer);
				btnTap2.setTag(wrongAnswer);
				btnTap3.setTag(wrongAnswer);
				btnTap4.setTag(wrongAnswer);
				btnTap5.setTag(wrongAnswer);
				btnTap6.setTag(wrongAnswer);
				btnTap7.setTag(wrongAnswer);
				btnTap8.setTag(correctAnswer);
				btnTap8.setImageResource(foods.get(currentFood).getId());
				break;
		}
	}
	
	public void checkAnswer(View v)
	{
		/* Retrieve all the buttons for that layout */
		ImageButton btnTap1 = (ImageButton) findViewById(R.id.btnTap1);
		ImageButton btnTap2 = (ImageButton) findViewById(R.id.btnTap2);
		ImageButton btnTap3 = (ImageButton) findViewById(R.id.btnTap3);
		ImageButton btnTap4 = (ImageButton) findViewById(R.id.btnTap4);
		ImageButton btnTap5 = (ImageButton) findViewById(R.id.btnTap5);
		ImageButton btnTap6 = (ImageButton) findViewById(R.id.btnTap6);
		ImageButton btnTap7 = (ImageButton) findViewById(R.id.btnTap7);
		ImageButton btnTap8 = (ImageButton) findViewById(R.id.btnTap8);
		/* See which button was tapped and then 
		 * find out whether it is the one
		 * with the "correct" tag. Give feedback
		 * to the user accordingly. Afterwards
		 * take them to the next question
		 * or activity.
		 * Always send along the extra information required
		 * for the other activity to load the right content.
		 * */
		switch (v.getId())
		{
			
			case R.id.btnTap1:
				if (btnTap1.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap2:
				if (btnTap2.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap3:
				if (btnTap3.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap4:
				if (btnTap4.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap5:
				if (btnTap5.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap6:
				if (btnTap6.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap7:
				if (btnTap7.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
			case R.id.btnTap8:
				if (btnTap8.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "Good!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "Hmm that doesn't look like " + foods.get(currentFood-1).getName() + ", try again!", Toast.LENGTH_SHORT).show();
				timer.cancel();
				tapCoolDownTimer.start();
				break;
				default:
					Toast.makeText(getApplicationContext(), "Ohh you didn't pick every " + foods.get(currentFood-1).getName(), Toast.LENGTH_SHORT).show();
					timer.cancel();
					tapCoolDownTimer.start();
					break;
		}//end switch
	}//end checkAnswer
}//end class
