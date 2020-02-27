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
	private String rank;
	private int face;
	private int pointValue;

  	//constructors
	public Card(String suitIn, int faceIn) 
	{
		setCard(suitIn, faceIn);
	}
	
	public Card(String suitIn, String rankIn, int pointValIn) 
	{
		setSuit(suitIn);
		setRank(rankIn);
		setPointValue(pointValIn);
	}

	
	// modifiers
	public void setCard(String suitIn, int faceIn)
	{
		suit = suitIn;
		face = faceIn;
	}
	
	public void setSuit(String suitIn)
	{
		suit = suitIn;
	}
	
	public void setFace(int faceIn)
	{
		face = faceIn;
	}
	
	public void setRank(String rankIn)
	{
		rank = rankIn;
	}
	
	public void setPointValue(int pointValIn) {
		pointValue = pointValIn;
	}

	
  	//accessors
	public String getSuit() 
	{
		return this.suit;
	}
	
	public int getFace()
	{
		return face;
	}


  	//toString
	public String toString() 
	{
		return FACES[face] + " of " + suit;
	}

 }