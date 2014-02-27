package com.example.flashcards;

import java.util.ArrayList;
import java.util.List;

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
}
