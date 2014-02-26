package com.example.testapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.testapp.MESSAGE";
	public final static String EXTRA_MESSAGE2 = "com.example.testApp.MESSAGE2";

	TextView mTextView;
	
	@SuppressLint("NewApi")
	@Override
	//Called when the program first opens
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Layout file is defined in the project res/layout/ativity_main.xml
		setContentView(R.layout.activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	// Called when the user clicks the Login button
	public void logIn(View view) {
		Intent intent = new Intent(this, Login.class);
		EditText editText1 		= (EditText) findViewById(R.id.login_name);
		EditText editText2 		= (EditText) findViewById(R.id.login_password);
		String loginName 		= editText1.getText().toString();
		String loginPassword 	= editText2.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, loginName);
		intent.putExtra(EXTRA_MESSAGE2, loginPassword);
		startActivity(intent);
	}
	
	// Called when the user clicks the Register button
		public void register(View view) {
			Intent intent = new Intent(this, Login.class);
			EditText editText1 		= (EditText) findViewById(R.id.login_name);
			EditText editText2 		= (EditText) findViewById(R.id.login_password);
			String loginName 		= editText1.getText().toString();
			String loginPassword 	= editText2.getText().toString();
			intent.putExtra(EXTRA_MESSAGE, loginName);
			intent.putExtra(EXTRA_MESSAGE2, loginPassword);
			startActivity(intent);
		}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_search:
		//	openSearch();
			return true;
		case R.id.action_settings:
		//	openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}//end case
	}//end onOptionsItemSelected

}
