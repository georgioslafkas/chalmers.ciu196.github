package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class PlayEndActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_end);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_end, menu);
		return true;
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		stopService(new Intent(this,MediaServiceB.class));
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		Intent goToPlay = new Intent(this, PlayCategoriesActivity.class);
		goToPlay.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goToPlay);
		finish();
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		Intent goToPlay = new Intent(this, PlayCategoriesActivity.class);
		goToPlay.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goToPlay);
		finish();
	}
}
