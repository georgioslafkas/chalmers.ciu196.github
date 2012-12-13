package chalmers.ciu196.foodschool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayQuizActivity extends Activity {
	public static GameTimerBar timer; /* timer is the count down timer */
	public static CoolDownTimer cooldownTimer; /* timer that counts down to the next question */
	private static final int TOTAL_TIME = 10000; /* 10 seconds count down */
	private static final int INTERVAL = 500;	/* 0.5 second interval */
	private static final int COOL_DOWN = 3000; /* time to next question */
	private final int NOT_FOUND = 0; /* in case a category was not found */
	public static Activity activityInstance = null; /* an instance of this activity, 
													* to be passed to the cool down timer */
	
	public int categoryToPlay = -1;
	public LinkedList<Food> foods; /* the list of foods for a category */
	public Object correctAnswer = new Object(), wrongAnswer =  new Object(); /* a pointer to the correct answer for a question */
	public final int POSSIBLE_ANSWERS_NUMBER = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_quiz);
		
		/* Retrieve the progress bar from the UI */
		ProgressBar quizProgBar = (ProgressBar) findViewById(R.id.progBarQuiz);
		/* Initialize the instance of this activity */
		PlayQuizActivity.activityInstance = this;
		/* Set the count down bar and the cool down timer */
		timer = new GameTimerBar(getApplicationContext(), quizProgBar, TOTAL_TIME, INTERVAL);
		cooldownTimer = new CoolDownTimer(COOL_DOWN, INTERVAL);
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		/* Get the intent that started this activity */
		Intent startedThis = getIntent();
		/* Retrieve which category was tapped, by reading the
		 * information that was sent with, NOT_FOUND if it's not set
		 */
		/* SHOULD BE USED TO LOAD THE foods FOR THIS CATEGORY */
		categoryToPlay = startedThis.getIntExtra("category", NOT_FOUND);
		/* Create a list with all the foods for that category */
		foods = (LinkedList<Food>) makeQuestionList(categoryToPlay);
		/* Load the first question the first time this activity runs */
		loadNextQuestion(foods, 0);
		setPossibleAnswers(categoryToPlay, foods, 0);
		/* Start the count down */
		timer.start();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		/* Cancel the timers */
		timer.cancel();
		cooldownTimer.cancel();
	}
	
	@Override
	public void onStop()
	{
		super.onStop();
		timer.cancel();
		cooldownTimer.cancel();
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
		List<Food> foods = new LinkedList<Food>(); /* list that will be returned */

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
		else
		{
			//This should take you to the other game activity
		}
	}
	
	/* Random generator between 1-4,
	 * to use for the button images
	 */
	public int generateRandomNumber()
	{
		Random randomNo = new Random();
		return randomNo.nextInt(4)+1;
	}
	
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
					btnAnswer2.setImageResource(wrongAnswerImages.get(1));
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
		/* If the current food index is bigger then the
		 * number of foods for that category, you finished
		 * that quiz!
		 */
		else
		{
			/* Just print something for now */
			System.out.println("finished here, go to next activity");
		}
	}
	
	/* This method sets the multiple answers
	 * on the buttons. It is responsible for
	 * choosing which button will have the correct
	 * answer, setting the image for that and the other
	 * buttons. In the end it also returns the correct
	 * answer in the form of an object, for validating
	 * the user's response.
	 */
	public Object setPossibleAnswers(int foodCategory, LinkedList<Food> foods, int currentFood)
	{
		/* Declare and initialize a list with the images
		 * for the wrong answers.
		 */
		List<Integer> wrongAnswerImages = new LinkedList<Integer>();
		
		/* Put every image of a wrong answer in 
		 * the list, so that we can use it later
		 * with the buttons that are not the correct
		 * answer.
		 */
		for (int i = 0; i < foods.size(); i++)
		{
			/* Avoid NullPointerException by checking whether
			 * the current food index is smaller then the number
			 * of foods in the list for the current category
			 */
			if (currentFood < foods.size())
			{
				/* If the id of a food is not the same as the id of
				 * the food that is the correct answer,
				 * add it to the list of wrong answer images. */
				if (foods.get(i).getId() != foods.get(currentFood).getId())
					wrongAnswerImages.add(foods.get(i).getId());
			}
			/* Otherwise just print something for now */
			else
				System.out.println("Done here!!!");
		}
		
		/* Randomize the order of the wrong images */
		Collections.shuffle(wrongAnswerImages);
		
		/* Once again, determine which category we're in.
		 * After that, call the setButtons method
		 * to assign images to buttons etc. (see comments) */
		switch (foodCategory)
		{
			/* FRUIT */
			case 1:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			/* VEGETABLES */
			case 2:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			/* MEAT */
			case 3:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			/* DAIRY */
			case 4:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			/* CEREALS */
			case 5:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			/* ALL */
			case 6:
				setButtonAnswers(currentFood, wrongAnswerImages);
				break;
			default:
				break;
		}//end switch
		return correctAnswer;
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
		/* See which was tapped and then 
		 * find out whether it is the one
		 * with the "correct" tag. If it is,
		 * give feedback to the user. Afterwards
		 * it should take them to the next question
		 * or activity.
		 * */
		switch (v.getId())
		{
			case R.id.btnAnswer1:
				if (btnAnswer1.getTag().equals(correctAnswer))
					System.out.println("You answered correctly!!!");
				else
					System.out.println("You answered wrong...");
				break;
			case R.id.btnAnswer2:
				if (btnAnswer2.getTag().equals(correctAnswer))
					System.out.println("You answered correctly!!!");
				else
					System.out.println("You answered wrong...");
				break;
			case R.id.btnAnswer3:
				if (btnAnswer3.getTag().equals(correctAnswer))
					System.out.println("You answered correctly!!!");
				else
					System.out.println("You answered wrong...");
				break;
			case R.id.btnAnswer4:
				if (btnAnswer4.getTag().equals(correctAnswer))
					System.out.println("You answered correctly!!!");
				else
					System.out.println("You answered wrong...");
				break;
		}//end switch
	}//end checkAnswer
}//end class
