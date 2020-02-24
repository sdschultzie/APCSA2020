package Elevens;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
		private String suit;
		private int rank;
		private int pointValue;

  	//constructors
		public Card() {
			setCard("SPADES", 1);
		}
		
		public Card(String suitIn, int rankIn) {
			setCard(suitIn, rankIN);
		}

	// modifiers
		public void setCard(String suitIn, int rankIn){
			suit = suitIn;
			rank = rankIn;
		}


  	//accessors
		//get methods


  	//toString

 }