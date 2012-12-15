package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class LearnFoodActivity extends Activity {
	private final int NOT_FOUND = 0;
	private int foodToShow = -1;
	/* These variables represent the category of food
	 * the user can choose to learn about */
	private final int FRUITS = 1,
					  VEGETABLES = 2,
					  MEAT = 3,
					  DAIRY = 4,
					  CEREALS = 5;
	Intent startDetailFood;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_food);

		/* Get the intent that started this activity */
		Intent startedThis = getIntent();
		
		/* Take references to all the buttons */
		ImageButton btn1_1 = (ImageButton) findViewById(R.id.btn1_1);
		ImageButton btn1_2 = (ImageButton) findViewById(R.id.btn1_2);
		ImageButton btn1_3 = (ImageButton) findViewById(R.id.btn1_3);
		ImageButton btn1_4 = (ImageButton) findViewById(R.id.btn1_4);
		ImageButton btn2_1 = (ImageButton) findViewById(R.id.btn2_1);
		ImageButton btn2_2 = (ImageButton) findViewById(R.id.btn2_2);
		ImageButton btn2_3 = (ImageButton) findViewById(R.id.btn2_3);
		ImageButton btn2_4 = (ImageButton) findViewById(R.id.btn2_4);
		ImageButton btn3_1 = (ImageButton) findViewById(R.id.btn3_1);
		ImageButton btn3_2 = (ImageButton) findViewById(R.id.btn3_2);
		ImageButton btn3_3 = (ImageButton) findViewById(R.id.btn3_3);
		ImageButton btn3_4 = (ImageButton) findViewById(R.id.btn3_4);
		/* Depending on which button was tapped
		 * show the grid with the appropriate
		 * images
		 */
		switch (LearnCategoriesActivity.categoryToLearn)
		{
			/* FRUITS */
			case 1:
				btn1_1.setImageResource(R.drawable.img_fruits_apple);
				btn1_2.setImageResource(R.drawable.img_fruits_banana);
				btn1_3.setImageResource(R.drawable.img_fruits_cherry);
				btn1_4.setImageResource(R.drawable.img_fruits_grapes);
				btn2_1.setImageResource(R.drawable.img_fruits_lemon);
				btn2_2.setImageResource(R.drawable.img_fruits_lime);
				btn2_3.setImageResource(R.drawable.img_fruits_orange);
				btn2_4.setImageResource(R.drawable.img_fruits_peach);
				btn3_1.setImageResource(R.drawable.img_fruits_pear);
				btn3_2.setImageResource(R.drawable.img_fruits_pineapple);
				btn3_3.setImageResource(R.drawable.img_fruits_strawberries);
				btn3_4.setImageResource(R.drawable.img_fruits_watermelon);
				break;
			/* VEGETABLES */
			case 2:
				btn1_1.setImageResource(R.drawable.img_vegetables_broccoli);
				btn1_2.setImageResource(R.drawable.img_vegetables_cabbage);
				btn1_3.setImageResource(R.drawable.img_vegetables_carrot);
				btn1_4.setImageResource(R.drawable.img_vegetables_cucumber);
				btn2_1.setImageResource(R.drawable.img_vegetables_eggplant);
				btn2_2.setImageResource(R.drawable.img_vegetables_green_peas);
				btn2_3.setImageResource(R.drawable.img_vegetables_lettuce);
				btn2_4.setImageResource(R.drawable.img_vegetables_mushrooms);
				btn3_1.setImageResource(R.drawable.img_vegetables_onion);
				btn3_2.setImageResource(R.drawable.img_vegetables_pepper);
				btn3_3.setImageResource(R.drawable.img_vegetables_potato);
				btn3_4.setImageResource(R.drawable.img_vegetables_tomato);
				break;
			/* MEAT */
			case 3:
				btn1_1.setImageResource(R.drawable.img_protein_beef);
				btn1_2.setImageResource(R.drawable.img_protein_chicken);
				btn1_3.setImageResource(R.drawable.img_protein_fish);
				btn1_4.setImageResource(R.drawable.img_protein_pork);
				btn2_1.setImageResource(R.drawable.img_protein_sausage);
				btn2_2.setImageResource(R.drawable.img_protein_egg);
				/* Hide unnecessary buttons */
				btn2_3.setVisibility(View.GONE);
				btn2_4.setVisibility(View.GONE);
				btn3_1.setVisibility(View.GONE);
				btn3_2.setVisibility(View.GONE);
				btn3_3.setVisibility(View.GONE);
				btn3_4.setVisibility(View.GONE);
				break;
			/* DAIRY */
			case 4:
				btn1_1.setImageResource(R.drawable.img_dairy_butter);
				btn1_2.setImageResource(R.drawable.img_dairy_cheese);
				btn1_3.setImageResource(R.drawable.img_dairy_milk);
				btn1_4.setImageResource(R.drawable.img_dairy_yogurt);
				btn2_1.setVisibility(View.GONE);
				btn2_2.setVisibility(View.GONE);
				btn2_3.setVisibility(View.GONE);
				btn2_4.setVisibility(View.GONE);
				btn3_1.setVisibility(View.GONE);
				btn3_2.setVisibility(View.GONE);
				btn3_3.setVisibility(View.GONE);
				btn3_4.setVisibility(View.GONE);
				break;
			/* CEREALS */
			case 5:
				btn1_1.setImageResource(R.drawable.img_cereals_bread);
				btn1_2.setImageResource(R.drawable.img_cereals_corn);
				btn1_3.setImageResource(R.drawable.img_cereals_pasta);
				btn1_4.setImageResource(R.drawable.img_cereals_rice);
				btn2_1.setImageResource(R.drawable.img_cereals_wheat);
				btn2_2.setVisibility(View.GONE);
				btn2_3.setVisibility(View.GONE);
				btn2_4.setVisibility(View.GONE);
				btn3_1.setVisibility(View.GONE);
				btn3_2.setVisibility(View.GONE);
				btn3_3.setVisibility(View.GONE);
				btn3_4.setVisibility(View.GONE);
				break;
			/* NOT FOUND, DEFAULT */
			default:
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_learn_food, menu);
		return true;
	}

	
	/* Click handler that takes you to the detail
	 * activity for a specific food.
	 * NOTE: This should send extra info in order to
	 * start the activity with the proper content,
	 * e.g. tapping "Apple" should bring the 
	 * information on apples etc.
	 */
	public void startDetailActivity(int foodToShow)
	{
		startDetailFood = new Intent(this, LearnDetailActivity.class);
		startDetailFood.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startDetailFood.putExtra("food", foodToShow);
		startActivity(startDetailFood);
		//finish();
	}
	
	/* Home button listener */
	public void goHome(View v)
	{
		Intent goHome = new Intent(this, MainActivity.class);
		goHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goHome);
	}
	
	public void pickFoodToShow(View v)
	{
		switch (LearnCategoriesActivity.categoryToLearn)
		{
			case FRUITS:
				pickFoodFromFruits(v);
				break;
			case VEGETABLES:
				pickFoodFromVegetables(v);
				break;
			case MEAT:
				pickFoodFromMeat(v);
				break;
			case DAIRY:
				pickFoodFromDairy(v);
				break;
			case CEREALS:
				pickFoodFromCereal(v);
				break;
			default:
				break;
		}
		startDetailActivity(foodToShow);
	}
	
	/* Fruit button listener */
	public void pickFoodFromFruits(View v)
	{
		switch (v.getId())
		{
			case R.id.btn1_1:
				foodToShow = R.drawable.img_fruits_apple;
				break;
			case R.id.btn1_2:
				foodToShow = R.drawable.img_fruits_banana;
				break;
			case R.id.btn1_3:
				foodToShow = R.drawable.img_fruits_cherry;
				break;
			case R.id.btn1_4:
				foodToShow = R.drawable.img_fruits_grapes;
				break;
			case R.id.btn2_1:
				foodToShow = R.drawable.img_fruits_lemon;
				break;
			case R.id.btn2_2:
				foodToShow = R.drawable.img_fruits_lime;
				break;
			case R.id.btn2_3:
				foodToShow = R.drawable.img_fruits_orange;
				break;
			case R.id.btn2_4:
				foodToShow = R.drawable.img_fruits_peach;
				break;
			case R.id.btn3_1:
				foodToShow = R.drawable.img_fruits_pear;
				break;
			case R.id.btn3_2:
				foodToShow = R.drawable.img_fruits_pineapple;
				break;
			case R.id.btn3_3:
				foodToShow = R.drawable.img_fruits_strawberries;
				break;
			case R.id.btn3_4:
				foodToShow = R.drawable.img_fruits_watermelon;
				break;
			default:
				break;
		}
	}
	
	/* Vegetable button listener */
	public void pickFoodFromVegetables(View v)
	{
		switch (v.getId())
		{
			case R.id.btn1_1:
				foodToShow = R.drawable.img_vegetables_broccoli;
				break;
			case R.id.btn1_2:
				foodToShow = R.drawable.img_vegetables_cabbage;
				break;
			case R.id.btn1_3:
				foodToShow = R.drawable.img_vegetables_carrot;
				break;
			case R.id.btn1_4:
				foodToShow = R.drawable.img_vegetables_cucumber;
				break;
			case R.id.btn2_1:
				foodToShow = R.drawable.img_vegetables_eggplant;
				break;
			case R.id.btn2_2:
				foodToShow = R.drawable.img_vegetables_green_peas;
				break;
			case R.id.btn2_3:
				foodToShow = R.drawable.img_vegetables_lettuce;
				break;
			case R.id.btn2_4:
				foodToShow = R.drawable.img_vegetables_mushrooms;
				break;
			case R.id.btn3_1:
				foodToShow = R.drawable.img_vegetables_onion;
				break;
			case R.id.btn3_2:
				foodToShow = R.drawable.img_vegetables_pepper;
				break;
			case R.id.btn3_3:
				foodToShow = R.drawable.img_vegetables_potato;
				break;
			case R.id.btn3_4:
				foodToShow = R.drawable.img_vegetables_tomato;
				break;
			default:
				break;
		}
	}

	/* Meat button listener */
	public void pickFoodFromMeat(View v)
	{
		switch (v.getId())
		{
			case R.id.btn1_1:
				foodToShow = R.drawable.img_protein_beef;
				break;
			case R.id.btn1_2:
				foodToShow = R.drawable.img_protein_chicken;
				break;
			case R.id.btn1_3:
				foodToShow = R.drawable.img_protein_fish;
				break;
			case R.id.btn1_4:
				foodToShow = R.drawable.img_protein_pork;
				break;
			case R.id.btn2_1:
				foodToShow = R.drawable.img_protein_sausage;
				break;
			case R.id.btn2_2:
				foodToShow = R.drawable.img_protein_egg;
				break;
			default:
				break;
		}
	}

	/* Dairy button listener */
	public void pickFoodFromDairy(View v)
	{
		switch (v.getId())
		{
			case R.id.btn1_1:
				foodToShow = R.drawable.img_dairy_butter;
				break;
			case R.id.btn1_2:
				foodToShow = R.drawable.img_dairy_milk;
				break;
			case R.id.btn1_3:
				foodToShow = R.drawable.img_dairy_cheese;
				break;
			case R.id.btn1_4:
				foodToShow = R.drawable.img_dairy_yogurt;
				break;
			default:
				break;
		}
	}

	/* Cereals button listener */
	public void pickFoodFromCereal(View v)
	{
		switch (v.getId())
		{
			case R.id.btn1_1:
				foodToShow = R.drawable.img_cereals_bread;
				break;
			case R.id.btn1_2:
				foodToShow = R.drawable.img_cereals_corn;
				break;
			case R.id.btn1_3:
				foodToShow = R.drawable.img_cereals_pasta;
				break;
			case R.id.btn1_4:
				foodToShow = R.drawable.img_cereals_rice;
				break;
			case R.id.btn2_1:
				foodToShow = R.drawable.img_cereals_wheat;
				break;
			default:
				break;
		}
	}

	public void goToCategories(View v)
	{
		Intent goToCategories = new Intent(this, LearnCategoriesActivity.class);
		goToCategories.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goToCategories);
	}
}//end class
