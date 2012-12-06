package chalmers.ciu196.foodschool.Database;

import chalmers.ciu196.foodschool.R;
import android.content.Context;
import android.util.Log;

public class Backup {
	
	private static boolean debug = false;
	private static final String TAG = "Backup";
	
	public static int CURRENT_VERSION = 2;
	
	private String result="";
	
	Context myCtx=null;

	public Backup(Context ctx) {
		myCtx=ctx;
	}

    public boolean write(String filename) {
    	if (debug) Log.d(TAG,"write("+filename+",)");
    	
		try {
			String path = filename;
			DbManager manager = new DbManager(myCtx);
			manager.backup(path);
			manager.close();
			result=myCtx.getString(R.string.backup_complete);
		} catch (Exception e) {
			e.printStackTrace();
			result=myCtx.getString(R.string.backup_failed)+" "+
				e.getLocalizedMessage();
			return false;
		}
		return true;
    }
    public String getResult() {
    	return result;
    }


}
