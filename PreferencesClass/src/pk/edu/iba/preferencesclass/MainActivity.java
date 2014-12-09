package pk.edu.iba.preferencesclass;

import pk.edu.iba.preferencesclass.IbaDatabaseAdapter.IbaHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText userName;
	private EditText password;
	private Button btnSave;
	private Button btnGoToB;
	IbaDatabaseAdapter ibaHelper;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibaHelper=new IbaDatabaseAdapter(this);
      
        userName=(EditText)findViewById(R.id.txtUserName);
        password=(EditText)findViewById(R.id.txtPassword);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String user=userName.getText().toString();
				String pass=password.getText().toString();
				
				long id=ibaHelper.InsertData(user, pass);
				 if (id <0){
					 Toast.makeText(MainActivity.this,"sorry data is not inserted",Toast.LENGTH_LONG).show();
				 }else{Toast.makeText(MainActivity.this,"Data was save successfully",Toast.LENGTH_LONG).show();}
				
				
			}
		});
        btnGoToB=(Button)findViewById(R.id.btnGoToB);
        btnGoToB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Toast.makeText(MainActivity.this,"Next",Toast.LENGTH_LONG).show();
			Intent i=new Intent(MainActivity.this,ActivityB.class);
			startActivity(i);
				
			}
		});
        
    }
}
