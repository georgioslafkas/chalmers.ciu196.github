package chalmers.ciu196.foodschool;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaServiceA extends Service {
	MediaPlayer player;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate(){
		player=MediaPlayer.create(this, R.raw.foodschoolbso1);
		player.setLooping(true);
	}
	
	@Override
	public void onDestroy(){
		player.stop();
	}
	
	@Override
	public void onStart(Intent inten, int startid){
		player.start();
	}

}
