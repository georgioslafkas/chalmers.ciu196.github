package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LearnDetailActivity extends Activity {

	private final int NOT_FOUND = -1;
	int foodToShow;
	Intent startedThis;
	
	private MediaPlayer mediaPlayer = new MediaPlayer();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_detail);

	}


	public void onResume()
	{
		super.onResume();
		
		startedThis = getIntent();
		foodToShow = startedThis.getIntExtra("food", NOT_FOUND);
		System.out.println("Food to show inside on create is "+foodToShow);
		loadFoodContent(foodToShow);
		System.out.println(foodToShow);
		//getNextFoodIndex(foodToShow);
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		mediaPlayer.release();
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		mediaPlayer.release();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_learn_detail, menu);
		return true;
	}
	/* Home button listener */
	public void goHome(View v)
	{
		Intent goHome = new Intent(this, MainActivity.class);
		goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goHome);
	}
	
	/* This method loads the necessary content
	 * for a food, to the detail activity GUI
	 * elements (images, text fields)
	 */
	public void loadFoodContent(int foodToShow)
	{
		ImageButton btnMainImage = (ImageButton) findViewById(R.id.btnMainFoodImg);
		ImageButton btnImage1 = (ImageButton) findViewById(R.id.btnImage1);
		ImageButton btnImage2 = (ImageButton) findViewById(R.id.btnImage2);
		ImageButton btnImage3 = (ImageButton) findViewById(R.id.btnImage3);
		ImageButton btnImage4 = (ImageButton) findViewById(R.id.btnImage4);
		TextView txtDescription = (TextView) findViewById(R.id.txtDescription);
		
		/* Obtain a copy of the current category's food list */
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());
		/* Scan that copy, compare id's and when
		 * you find the one we're interested in
		 * load it's content to the GUI elements
		 */
		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
			{
				btnMainImage.setImageResource(foodToShow);
				txtDescription.setText(currentCat.get(i).getDescription());
				/* Check the number of images for each food and set accordingly */
				if (currentCat.get(i).getImage_ids().size() >= 4)
				{
					btnImage1.setImageResource(currentCat.get(i).getImage_ids().get(0));
					btnImage2.setImageResource(currentCat.get(i).getImage_ids().get(1));
					btnImage3.setImageResource(currentCat.get(i).getImage_ids().get(2));
					btnImage4.setImageResource(currentCat.get(i).getImage_ids().get(3));
				}
				else if (currentCat.get(i).getImage_ids().size() == 3)
				{
					btnImage1.setImageResource(currentCat.get(i).getImage_ids().get(0));
					btnImage2.setImageResource(currentCat.get(i).getImage_ids().get(1));
					btnImage3.setImageResource(currentCat.get(i).getImage_ids().get(2));
					btnImage4.setVisibility(View.GONE);
				}
				else if (currentCat.get(i).getImage_ids().size() == 2)
				{
					btnImage1.setImageResource(currentCat.get(i).getImage_ids().get(0));
					btnImage2.setImageResource(currentCat.get(i).getImage_ids().get(1));
					btnImage3.setImageResource(View.GONE);
					btnImage4.setImageResource(View.GONE);
				}
					
			}
	}
	
	/* This method works similar to the one
	 * in LearnFoodActivity. Instead of reading
	 * the name of the food however, it retrieves
	 * the description.
	 */
	public void playFoodDescription(int foodId)
	{
		int descriptionToPlay = 0;
		ArrayList<Food> tempFoods = SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained();
		for (int i = 0; i < tempFoods.size(); i++)
		{
			if (tempFoods.get(i).getId() == foodId)
				descriptionToPlay = tempFoods.get(i).getSound_ids().get(1);
		}
		mediaPlayer = MediaPlayer.create(this, descriptionToPlay);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener()
		{

			public void onCompletion(MediaPlayer mediaPlayer) {
				mediaPlayer.release();
			}
		});
		mediaPlayer.start();
	}
	
	/* Used as a handler for the readDescription button.
	 * Simply invokes playFoodDescription() with the right
	 * argument (current food id).
	 */
	public void playDescription(View v)
	{
		playFoodDescription(foodToShow);
	}
	
	/* This method returns the index of the next
	 * food in the grid, to be used in the next
	 * button handler
	 */
	public int getNextFoodIndex(int foodToShow)
	{
		int nextFood = 0;
		/* Copy of the current category's list of foods */
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());

		/* Scan it, when you find the food we're interested in,
		 * increment the nextIndex to point to the next food.
		 * If it goes out of bounds, set it to 0 (circulates the list)
		 */
		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
			{
				nextFood = i+1;
				if (!(nextFood < currentCat.size()))
						nextFood = 0;
			}
		/* Return the index */
		return nextFood;
	}
	
	/* This method uses the nextFood index from above to
	 * actually show the details of the next food.
	 * It restarts the current activity with a different
	 * food as the selected one.
	 */
	public void goToNextFood(View v)
	{
		int nextFood = getNextFoodIndex(foodToShow);
		/* Copy of the current category's list of foods */
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());
		/* Take the id of the next food */
		foodToShow = currentCat.get(nextFood).getId();
		/* Start the activity again with the next food as extra info */
		Intent showNextFood = new Intent(this, LearnDetailActivity.class);
		showNextFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		showNextFood.putExtra("food", foodToShow);
		startActivity(showNextFood);
	}
	
	/* Same as above, but for the previous food index */
	public int getPreviousFoodIndex(int foodToShow)
	{
		int previousFood = 0;
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());

		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
				previousFood = i-1;
		return previousFood;
	}
	
	/* Same as goToNextFood, but with previousFood index.
	 * Only difference, if you go back from the first food,
	 * it takes you to the food categories grid.
	 */
	public void goToPreviousFood(View v)
	{
		Intent showPreviousFood;
		int previousFood = getPreviousFoodIndex(foodToShow);
		if (previousFood < 0)
			showPreviousFood = new Intent(this, LearnFoodActivity.class);
		else
		{
			ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());
			showPreviousFood = new Intent(this, LearnDetailActivity.class);
			foodToShow = currentCat.get(previousFood).getId();
			showPreviousFood.putExtra("food", foodToShow);
		}
		showPreviousFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(showPreviousFood);
	}
	
	/* Takes you back to the grid with foods from that category */
	public void goToFoods(View v)
	{
		Intent goToCategories = new Intent(this, LearnFoodActivity.class);
		goToCategories.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goToCategories);
	}
}//end class
