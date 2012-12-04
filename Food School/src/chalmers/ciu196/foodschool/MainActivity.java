package chalmers.ciu196.foodschool;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
	@Override
	protected void onResume(){
		super.onResume();
		MediaPlayer mediaPlayer;
		mediaPlayer= MediaPlayer.create(this, R.raw.bg);
		Log.d("COsa","COsa");
		mediaPlayer.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}

}
