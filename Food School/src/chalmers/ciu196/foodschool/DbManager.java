package chalmers.ciu196.foodschool;

import android.content.Context;
import android.util.Log;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;


public class DbManager {
	
	private ObjectContainer database = null;
	private String DATABASE_NAME = "FoodSchool.db4o";
	
	public DbManager(Context context){
		
		try {
				if (database == null || database.ext().isClosed()) {
					database = Db4oEmbedded.openFile(config(),db4oDBFullPath(context));
				}
			} catch (Exception ie) {
				Log.e(DbManager.class.getName(), ie.getMessage());
			}
	}
	
	// Create an instance of the configuration @return
	private EmbeddedConfiguration config() { 
		EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
		return configuration;
		}
	
	// @param ctx
	// @ return  returns the path of the database
	private String db4oDBFullPath(Context ctx) {
		return ctx.getDir("data", 0) + "/" + DATABASE_NAME;
		}
	
	// commit to database
	public void commit() {
		database.commit();
	}

	// roll-back
	public void rollBack() {
		database.rollback();
	}
	
	// close database
	public void close() {
		if (this.database != null) {
			this.database.close();
		}
	}
	
	// @return returns the database
	public ObjectContainer getDatabase() {
		return this.database;
	}
}
