package pk.edu.iba.preferencesclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.Toast;

public class IbaDatabaseAdapter{
IbaHelper helper;

public IbaDatabaseAdapter(Context context) {
	helper=new IbaHelper(context);
}
public long InsertData(String name,String password){
	SQLiteDatabase db= helper.getWritableDatabase();
	
	ContentValues contentvalues=new ContentValues();
	contentvalues.put(IbaHelper.NAME,name);
	contentvalues.put(IbaHelper.PASSWORD,password );
	long id=db.insert(IbaHelper.TABLE_NAME, null, contentvalues);
	
	return id;
}


 static class IbaHelper extends SQLiteOpenHelper {
private static final  String DATABASE_NAME="iba.db";
private static final String TABLE_NAME="NASRTABLE";
private static final String UID="_id";
private static final String NAME="Name";
//private static final String ADDRESS="Address";
private static final String PASSWORD="password";
private static final String AGE="age";
private static final int DATABASE_VERSION=5;
private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(200));";

private Context context;
	public IbaHelper(Context context) {
		super(context,DATABASE_NAME,null ,DATABASE_VERSION);
		 this.context=context;
		// TODO Auto-generated constructor stub
		 Toast.makeText(context, "Constructor is called",Toast.LENGTH_LONG ).show();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	//String query="CREATE TABLE "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255));";
	//	String CREATE="CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255));";
	//	db.execSQL("CREATE TABLE NASRTABLE("+" INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255));");
       try {
		db.execSQL(CREATE_TABLE);
		Toast.makeText(context, "OnCreate() is called",Toast.LENGTH_LONG ).show();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
		
	}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	try {
		//db.execSQL("DROP TABLE IF EXISTS NASRTABLE");
		db.execSQL(DROP_TABLE);
		onCreate(db);
		Toast.makeText(context, "OnUpgrade() is called",Toast.LENGTH_LONG ).show();
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

}

}

