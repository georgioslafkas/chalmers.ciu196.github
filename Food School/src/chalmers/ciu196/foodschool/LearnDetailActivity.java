package chalmers.ciu196.foodschool;

import java.util.ArrayList;

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
	
	public void loadFoodContent(int foodToShow)
	{
		ImageButton btnMainImage = (ImageButton) findViewById(R.id.btnMainFoodImg);
		TextView txtDescription = (TextView) findViewById(R.id.txtDescription);
		
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());
		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
			{
				btnMainImage.setImageResource(foodToShow);
				txtDescription.setText(currentCat.get(i).getDescription());
			}
	}
	
	public int getNextFoodIndex(int foodToShow)
	{
		int nextFood = 0;
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());

		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
			{
				nextFood = i+1;
				if (!(nextFood < currentCat.size()))
						nextFood = 0;
			}
		System.out.println("Next food index from inside getNext is "+nextFood);
		return nextFood;
	}
	
	public void goToNextFood(View v)
	{
		int nextFood = getNextFoodIndex(foodToShow);
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());
		foodToShow = currentCat.get(nextFood).getId();
		Intent showNextFood = new Intent(this, LearnDetailActivity.class);
		showNextFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		showNextFood.putExtra("food", foodToShow);
		System.out.println("Food index from inside goToNext is "+foodToShow);
		startActivity(showNextFood);
	}
	
	public int getPreviousFoodIndex(int foodToShow)
	{
		int previousFood = 0;
		ArrayList<Food> currentCat = new ArrayList<Food>(SimpleFoodManager.getManager().getFoodCatAt(LearnCategoriesActivity.categoryToLearn-1).getFoodsContained());

		for (int i = 0; i < currentCat.size(); i++)
			if (currentCat.get(i).getId() == foodToShow)
				previousFood = i-1;
		return previousFood;
	}
	
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
	
	public void goToCategories(View v)
	{
		Intent goToCategories = new Intent(this, LearnCategoriesActivity.class);
		goToCategories.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goToCategories);
	}
}//end class