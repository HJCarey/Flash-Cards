package com.example.flashcards;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class Deck {
	
	private String deckName;
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck(String name) {
		this.deckName = name;
	}
	
	public String getDeckName() {
		return deckName;
	}
	
	public void setDeckname(String newName) {
		this.deckName = newName;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(Card card) {
		this.cards.remove(card);
	}
	
	public void saveDeck(Context context) {
		File deckFile = new File(this.getDeckName());
		
		if (!deckFile.exists()) {
			try {
				deckFile.createNewFile();
				FileOutputStream fos = context.openFileOutput(this.deckName, Context.MODE_PRIVATE);
				fos.write(this.deckName.getBytes());
				fos.close();
			} catch (IOException e) {
				Log.e("Exception", "User already exists");
			}//end catch
		}//end if
	}//end saveDeck
}//end class
