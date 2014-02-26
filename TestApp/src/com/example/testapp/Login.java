package com.example.testapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class Login extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get the message from the intent
		Intent intent = getIntent();
		String loginName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	//	String loginPassword = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
		
		//Create files for user
		
		
		//Create the text view for name
		TextView textLoginName = new TextView(this);
		textLoginName.setTextSize(50);
		textLoginName.setText(loginName);

		
		//Adds ability to navigate back to the log in screen
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
	}//end onCreate

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}//end switch
		return super.onOptionsItemSelected(item);
	}//end onOptionsItemSelected

}//end class
