package com.example.testapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Register extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get the message from the intent
		Intent intent = getIntent();
		String loginName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		String loginPassword = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
		String combinedInfo = loginName + ", " + loginPassword;
		
		//Create files for user
		File userFile = new File(loginName);

		//If the user already has a registered name, as in a file already exists, don't create a second one
		if (!userFile.exists()) {
			try {
				userFile.createNewFile();
				writeToFile(combinedInfo, loginName);
			} catch (IOException e) {
				Log.e("Exception", "User already exists");
			}
		}
		
		//Create the text view for name
		setContentView(R.layout.activity_register);
		TextView textTest = (TextView) findViewById(R.id.register_name);
		textTest.setTextSize(50);
		textTest.setText(readFromFile(loginName));

		
		//Adds ability to navigate back to the log in screen
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
	}//end onCreate
	
	private String readFromFile(String fileName) {
		String ret = "";
		
		try {
			InputStream inputStream = openFileInput(fileName);
			
			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();
				
				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}
				
				inputStream.close();
				ret = stringBuilder.toString();
			}//end if
		} catch (FileNotFoundException e) {
			Log.e("Error", "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e("Error", "Can not read file: " + e.toString());
		}
		
		return ret;
	}
	
	private void writeToFile(String data, String fileName) {
		try {
			OutputStreamWriter outputStream = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
			outputStream.write(data);
			outputStream.close();
		} catch (Exception e) {
			Log.e("Exception", "File write failed: "+ e.toString());
		}
	}
	
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
