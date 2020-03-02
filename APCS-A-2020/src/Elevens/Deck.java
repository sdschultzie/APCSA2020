package Elevens;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

	public static final int NUMCARDS = 52;
	public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");

	
	private List<Card> cards;
	private int size;
	private int top;

    //make a Deck constructor
	public Deck() 
	{
	   	//refer cards to new ArrayList
		cards = new ArrayList<Card>();
	   	//set top to the top of the deck 51
		top = 51;
	   	
	   	//loop through all suits
		for (String suit : SUITS) {
	   		//loop through all faces 1 to 13
			for (int face=1; face<=13; face++){
	   			//add a new TwentyOneCard to the deck
				cards.add(new Card(suit, face));
			}
		}
		
		size = cards.size();
	}
	
	public Deck(String[] suits, String[] ranks, int[] pointVals)
	{
		cards = new ArrayList<Card>();
		
		for (String suit : suits) {
			for (String rank : ranks) {
				for (int pointVal : pointVals) {
					cards.add(new Card(suit, rank, pointVal));
				}
			}
		}
	}
		
	
   
	
    //make a dealCard() method that returns the top card 
	public Card dealCard()
	{
		return cards.get(top--);

	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
   
	
    //write a shuffle() method
	public void shuffle() 
	{
		//use Colletions.shuffle
		ArrayList<Card> shuffledDeck = new ArrayList<Card>(52);
		
		for (int i=0; i<(52/2); i+=1) {
			shuffledDeck.add(cards.get(i));
			shuffledDeck.add(cards.get(i+(52/2)));
		}
		
		cards = shuffledDeck;
		
	   	//reset the top card 
		top = 51;
	}
   
}