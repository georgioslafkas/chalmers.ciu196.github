package chalmers.ciu196.foodschool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlayQuizActivity extends Activity {
	public static GameTimerBar timer; /* timer is the count down timer */
	public static CoolDownTimer cooldownTimer; /* timer that counts down to the next question */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	private static final int COOL_DOWN = 3000; /* time to next question */
	private final int NOT_FOUND = -1; /* in case a category was not found */
	public static Activity activityInstance = null; /* an instance of this activity, 
													* to be passed to the cool down timer */
	Intent goToPlayTap; /* This intent will start the tap game activity */
	public int currentFood; /* This is the current food index, used to retrieve it from the list */
	public ArrayList<Food> foods; /* The list of foods for a category */
	public Object correctAnswer = new Object(), wrongAnswer =  new Object(); /* Just indicators of wrong or right answers */
	public final int POSSIBLE_WRONG_ANSWERS = 3; /* We have three wrong answers for this game */
	private static Random randomNo = new Random();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_quiz);
		
		/* Retrieve the progress bar from the UI */
		ProgressBar quizProgBar = (ProgressBar) findViewById(R.id.progBarQuiz);
		/* Initialize the instance of this activity */
		PlayQuizActivity.activityInstance = this;
		/* Set the count down bar and the cool down timer */
		timer = new GameTimerBar(getApplicationContext(), quizProgBar, TOTAL_TIME, INTERVAL, 1);
		cooldownTimer = new CoolDownTimer(COOL_DOWN, INTERVAL, 1);
		cooldownTimer.setActivityThatUsesMe(1); /* Where this is launched */
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public void onResume()
	{
		super.onResume();
		/* Get the intent that started this activity */
		Intent startedThis = getIntent();
		
		/* Initialize the intent that will start the tap game activity */
		goToPlayTap = new Intent(this, PlayTapActivity.class);
		goToPlayTap.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		/* Retrieve the food list from the tap game, if that
		 * activity has ever been launched
		 */
		foods = (ArrayList<Food>) startedThis.getSerializableExtra("foodlist");
		
		/* Otherwise, it is the first quiz played, so create the list */
		if (foods == null)
		{
			foods = (ArrayList<Food>) makeQuestionList(PlayCategoriesActivity.categoryToPlay);
		}
		/* And put it in the extras for the tap activity to receive */
		goToPlayTap.putExtra("foodlist", foods);
		
		/* Retrieve the current food index,
		 * either from the categories activity
		 * or from the tap activity
		 */
		currentFood = startedThis.getIntExtra("currentFood", NOT_FOUND);
		/* Add it to the extras for the tap activity as well */
		goToPlayTap.putExtra("currentFood", currentFood);

		/* Load a question each time this activity runs 
		 * and set the answers */
		loadNextQuestion(foods, currentFood);
		setPossibleAnswers(PlayCategoriesActivity.categoryToPlay, foods, currentFood);

		/* Start the count down for this quiz */
		timer.start();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		/* Cancel the timers */
		timer.cancel();
		cooldownTimer.cancel();
		finish();
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		timer.cancel();
		cooldownTimer.cancel();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_quiz, menu);
		return true;
	}
	
	/* This method receives a number which indicates
	 * which category was picked. Then it uses this
	 * number to determine which category to look for
	 * foods in. It creates a list with foods
	 * from that category and then shuffles the list
	 * to randomize the order.
	 * In the end the list for that category is returned.
	 */
	public List<Food> makeQuestionList(int categoryToPlay)
	{
		int upperRange = 0; /* Size of list */
		List<Food> foods = new ArrayList<Food>(); /* list that will be returned */

		switch (categoryToPlay)
		{
			/* FRUITS */
			case 1:
				/* Set the size */
				upperRange = SimpleFoodManager.getManager().getFoodCatAt(0).getFoodsContained().size();
				/* Create the list */
				for (int i = 0; i < upperRange; i++)
				{
					/* Get a question from that category */
					Food tempFood = SimpleFoodManager.getManager().getFoodCatAt(0).getFoodsContained().get(i);					/* Add it to the list of foods */
					foods.add(tempFood);
				}
				break;
			/* VEGETABLES */
			case 2:
				upperRange = SimpleFoodManager.getManager().getFoodCatAt(1).getFoodsContained().size();
				for (int i = 0; i < upperRange; i++)
				{
					Food tempFood = SimpleFoodManager.getManager().getFoodCatAt(1).getFoodsContained().get(i);
					foods.add(tempFood);
				}
				break;
			/* MEAT */
			case 3:
				upperRange = SimpleFoodManager.getManager().getFoodCatAt(2).getFoodsContained().size();
				for (int i = 0; i < upperRange; i++)
				{
					Food tempFood = SimpleFoodManager.getManager().getFoodCatAt(2).getFoodsContained().get(i);
					foods.add(tempFood);
				}
				break;
			/* DAIRY */
			case 4:
				upperRange = SimpleFoodManager.getManager().getFoodCatAt(3).getFoodsContained().size();
				for (int i = 0; i < upperRange; i++)
				{
					Food tempFood = SimpleFoodManager.getManager().getFoodCatAt(3).getFoodsContained().get(i);
					foods.add(tempFood);
				}
				break;
			/* CEREALS */
			case 5:
				upperRange = SimpleFoodManager.getManager().getFoodCatAt(4).getFoodsContained().size();
				for (int i = 0; i < upperRange; i++)
				{
					Food tempFood = SimpleFoodManager.getManager().getFoodCatAt(4).getFoodsContained().get(i);
					foods.add(tempFood);
				}
				break;
			/* ALL */
			case 6:
				upperRange = SimpleFoodManager.getManager().getTotalFoodCount();
				for (int i = 0; i < upperRange; i++)
				{
					Food tempFood = SimpleFoodManager.FoodCollection.get(i);
					foods.add(tempFood);
				}
				break;
			default:
				break;
		}//end switch
		/* Shuffle the list */
		Collections.shuffle(foods);
		return foods;
	}//end makeQuestionList
	
	/* This method simply displays the next question in the list
	 * inside the text field that exists for that purpose.
	 * It receives the whole list of foods and an integer
	 * as an argument. That integer is the index for the question
	 * that is going to be fetched.
	 */
	public void loadNextQuestion(List<Food> foods, int currentFood)
	{
		if (currentFood < foods.size())
		{
			TextView txtQuestion = (TextView) findViewById(R.id.txtQuestion);
			txtQuestion.setText(foods.get(currentFood).getDescription());
		}
	}
	
	/* Random generator between 1-4,
	 * to use for the button images
	 */
	public int generateRandomNumber()
	{
		return randomNo.nextInt(4)+1;
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
		for (int i = 0; i < POSSIBLE_WRONG_ANSWERS; i++)
			wrongAnswerImages.add(tempFoodList.get(i).getId());
		/* Return the list with the 3 wrong images */
		return wrongAnswerImages;
	}
	
	/* This method sets which will be
	 * the button for the correct
	 * answer and sets the image for it
	 * as well as the wrong ones.
	 */
	public void setButtonAnswers(int currentFood, List<Integer> wrongAnswerImages)
	{
		ImageButton btnAnswer1 = (ImageButton) findViewById(R.id.btnAnswer1);
		ImageButton btnAnswer2 = (ImageButton) findViewById(R.id.btnAnswer2);
		ImageButton btnAnswer3 = (ImageButton) findViewById(R.id.btnAnswer3);
		ImageButton btnAnswer4 = (ImageButton) findViewById(R.id.btnAnswer4);
		
		/* Again, to avoid a NPE */
		if (currentFood < foods.size())
		{
			/* This will be the button that will hold
			 * the correct answer, just pick a random
			 * one
			 */
			int correctButton = generateRandomNumber();
			/* Find which one it is, put a "correct" tag
			 * on it for answer validation and set up both
			 * that and the other ones with the right and
			 * wrong images respectively
			 */
			switch (correctButton)
			{
				/* If button 1 is the correct answer... */
				case 1:
					btnAnswer1.setTag(correctAnswer);
					btnAnswer1.setImageResource(foods.get(currentFood).getId());
					btnAnswer2.setTag(wrongAnswer);
					btnAnswer2.setImageResource(wrongAnswerImages.get(0));
					btnAnswer3.setTag(wrongAnswer);
					btnAnswer3.setImageResource(wrongAnswerImages.get(1));
					btnAnswer4.setTag(wrongAnswer);
					btnAnswer4.setImageResource(wrongAnswerImages.get(2));
					break;
				/* If button 2 is the correct answer... */
				case 2:
					btnAnswer1.setTag(wrongAnswer);
					btnAnswer1.setImageResource(wrongAnswerImages.get(0));
					btnAnswer2.setTag(correctAnswer);
					btnAnswer2.setImageResource(foods.get(currentFood).getId());
					btnAnswer3.setTag(wrongAnswer);
					btnAnswer3.setImageResource(wrongAnswerImages.get(1));
					btnAnswer4.setTag(wrongAnswer);
					btnAnswer4.setImageResource(wrongAnswerImages.get(2));
					break;
				/* If button 3 is the correct answer... */
				case 3:
					btnAnswer1.setTag(wrongAnswer);
					btnAnswer1.setImageResource(wrongAnswerImages.get(0));
					btnAnswer2.setTag(wrongAnswer);
					btnAnswer2.setImageResource(wrongAnswerImages.get(1));
					btnAnswer3.setTag(correctAnswer);
					btnAnswer3.setImageResource(foods.get(currentFood).getId());
					btnAnswer4.setTag(wrongAnswer);
					btnAnswer4.setImageResource(wrongAnswerImages.get(2));
					break;
				/* If button 4 is the correct answer... */
				case 4:
					btnAnswer1.setTag(wrongAnswer);
					btnAnswer1.setImageResource(wrongAnswerImages.get(0));
					btnAnswer2.setTag(wrongAnswer);
					btnAnswer2.setImageResource(wrongAnswerImages.get(1));
					btnAnswer3.setTag(wrongAnswer);
					btnAnswer3.setImageResource(wrongAnswerImages.get(2));
					btnAnswer4.setTag(correctAnswer);
					btnAnswer4.setImageResource(foods.get(currentFood).getId());
					break;
			}
		}
	}
	
	/* This method sets the multiple answers
	 * on the buttons for each category. It
	 * uses the above method to do so. 
	 */
	public void setPossibleAnswers(int foodCategory, ArrayList<Food> foods, int currentFood)
	{
		/* Once again, determine which category we're in.
		 * After that, call the setButtons method
		 * to assign images to buttons etc. (see comments) */
		switch (foodCategory)
		{
			/* FRUIT */
			case 1:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			/* VEGETABLES */
			case 2:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			/* MEAT */
			case 3:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			/* DAIRY */
			case 4:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			/* CEREALS */
			case 5:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			/* ALL */
			case 6:
				setButtonAnswers(currentFood, makeWrongImageList(currentFood, foods));
				break;
			default:
				break;
		}//end switch
	}// end setPossibleAnswers

	
	/* This method checks whether the
	 * button tapped is the one
	 * that has the right answer.
	 */
	public void checkAnswer(View v)
	{
		/* Retrieve all the buttons for that layout */
		ImageButton btnAnswer1 = (ImageButton) findViewById(R.id.btnAnswer1);
		ImageButton btnAnswer2 = (ImageButton) findViewById(R.id.btnAnswer2);
		ImageButton btnAnswer3 = (ImageButton) findViewById(R.id.btnAnswer3);
		ImageButton btnAnswer4 = (ImageButton) findViewById(R.id.btnAnswer4);
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
			
			case R.id.btnAnswer1:
				if (btnAnswer1.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "You answered " + foods.get(currentFood).getName() + " correctly!!!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "No, it is " + foods.get(currentFood).getName() + ", better luck next time!", Toast.LENGTH_SHORT).show();
				goToPlayTap.putExtra("currentFood", currentFood);
				goToPlayTap.putExtra("foodlist", foods);
				timer.cancel();
				cooldownTimer.start();
				break;
			case R.id.btnAnswer2:
				if (btnAnswer2.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "You answered " + foods.get(currentFood).getName() + " correctly!!!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "No, it is " + foods.get(currentFood).getName() + ", better luck next time!", Toast.LENGTH_SHORT).show();
				goToPlayTap.putExtra("currentFood", currentFood);
				goToPlayTap.putExtra("foodlist", foods);
				timer.cancel();
				cooldownTimer.start();
				break;
			case R.id.btnAnswer3:
				if (btnAnswer3.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "You answered " + foods.get(currentFood).getName() + " correctly!!!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "No, it is " + foods.get(currentFood).getName() + ", better luck next time!", Toast.LENGTH_SHORT).show();
				goToPlayTap.putExtra("currentFood", currentFood);
				goToPlayTap.putExtra("foodlist", foods);
				timer.cancel();
				cooldownTimer.start();
				break;
			case R.id.btnAnswer4:
				if (btnAnswer4.getTag().equals(correctAnswer))
					Toast.makeText(getApplicationContext(), "You answered " + foods.get(currentFood).getName() + " correctly!!!", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(), "No, it is " + foods.get(currentFood).getName() + ", better luck next time!", Toast.LENGTH_SHORT).show();
				goToPlayTap.putExtra("currentFood", currentFood);
				goToPlayTap.putExtra("foodlist", foods);
				timer.cancel();
				cooldownTimer.start();
				break;
				default:
					Toast.makeText(getApplicationContext(), "Correct answer was "+foods.get(currentFood).getName(), Toast.LENGTH_SHORT).show();
					goToPlayTap.putExtra("currentFood", currentFood);
					goToPlayTap.putExtra("foodlist", foods);
					timer.cancel();
					cooldownTimer.start();
					break;
		}//end switch
	}//end checkAnswer
}//end class
