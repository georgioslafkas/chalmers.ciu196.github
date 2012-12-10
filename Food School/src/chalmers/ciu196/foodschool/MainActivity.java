package chalmers.ciu196.foodschool;



import chalmers.ciu196.foodschool.Database.DbManager;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private MediaPlayer mediaPlayer;
	private DbManager databaseManager;
	
	// Database related variables =============================================

    //Close database before exiting the application
	
   @Override
   protected void onPause() {
         super.onDestroy();
         dbManager().close();
         databaseManager = null;
     }
	
	// End of Database related variables ======================================
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	// DATABASE related code ==================================================
		
		
		
	// End of database related code ===========================================

	}
	
	// DATABASE related code ==================================================
	private DbManager dbManager() {
		if (databaseManager == null) {
			databaseManager = new DbManager(this);
			databaseManager.database();
		}
		return databaseManager;
	}
	// End of database related code ===========================================
	
	@Override
	protected void onResume(){
		super.onResume();
		mediaPlayer= MediaPlayer.create(this, R.raw.foodschoolbso1);

		Log.d("COsa","COsa");
		/* Start playing music when this activity starts. */
		mediaPlayer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		/* Stop playing music when this activity stops. */
		mediaPlayer.stop();
	}
	

	/* Learn button click listener, takes you to the food
	 * categories, which displays the grid with all the food
	 * types.
	 */
	public void startLearnActivity(View v)
	{
		
		Intent startLearn = new Intent(this, LearnCategoriesActivity.class);
		startLearn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startLearn);
		//finish();
	}
	
	/* Play button click listener, takes you to the food
	 * categories, which displays the grid with all the food
	 * types.
	 */
	public void startPlayActivity(View v)
	{
		Intent startPlay = new Intent(this, PlayCategoriesActivity.class);
		startPlay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(startPlay);
		//finish();
	}
}
