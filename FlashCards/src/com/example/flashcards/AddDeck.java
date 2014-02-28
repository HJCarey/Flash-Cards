package com.example.flashcards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class AddDeck extends Activity{
	
	@SuppressLint("NewAPI")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_adddeck);
		
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
	
	public void saveDeck() {
		TextView tView;
		String testString = "empty";
		EditText deckBox	= (EditText) findViewById(R.id.adddeck_addDeck);
		String deckName 	= deckBox.getText().toString();
		Deck newDeck = new Deck(deckName);
		
		newDeck.saveDeck(this.getApplicationContext());
		
		tView = (TextView) findViewById(R.id.adddeck_testText);
		//Read name of file
		
		try {
				FileInputStream fis = openFileInput(newDeck.getDeckName());
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1) {
					testString = new String(dataArray);
				}
				fis.close();
				tView.setText(testString);
		} catch (FileNotFoundException e) {
			Log.e("Exception", "File not found.");
		} catch (IOException e) {
			Log.e("Exception", "Input exception error.");
		}
		
		
	}
}
