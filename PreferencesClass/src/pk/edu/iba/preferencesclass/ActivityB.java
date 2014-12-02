package pk.edu.iba.preferencesclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends Activity {

	private EditText userName;
	private EditText password;
	private Button btnLoad;
	private Button btnPrevious;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		userName=(EditText)findViewById(R.id.txtUserName2);
        password=(EditText)findViewById(R.id.txtPassword2);
        btnLoad=(Button)findViewById(R.id.btnLoad);
        btnPrevious=(Button)findViewById(R.id.btnPrevious);
        btnLoad.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
        btnPrevious.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(ActivityB.this,"Previous",Toast.LENGTH_LONG).show();
				
				Intent i=new Intent(ActivityB.this,MainActivity.class);
				startActivity(i);
			}
		});
	}
}
