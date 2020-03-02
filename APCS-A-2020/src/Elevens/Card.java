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
	
	public Card(String rankIn, String suitIn, int pointValIn) 
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
	
	public String getRank() {
		return rank;
	}
	
	public int getFace()
	{
		return face;
	}
	
	public int getPointValue() {
		return pointValue;
	}


	public boolean matches(Card otherCard) {
		if (this.getSuit().equals(otherCard.getSuit()) && this.getRank().equals(otherCard.getRank()) && this.getPointValue() == otherCard.getPointValue()) 
			return true;
		else if (this.getSuit().equals(otherCard.getSuit()) && this.getFace() == otherCard.getFace())
			return true;
		else
			return false;
	}
	
	
  	//toString
	public String toString() 
	{
		if (face == 0)
			return rank + " of " + suit + " (Point Value: " + pointValue + ")";
		else
			return FACES[face] + " of " + suit;
	}

 }