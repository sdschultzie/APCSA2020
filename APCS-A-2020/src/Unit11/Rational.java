package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int numerator;
	private int denominator;

	//write two constructors
	public Rational() {
		setRational(1,1);
	}
	
	public Rational(int numer, int denom) {
		setRational(numer, denom);
	}


	//write a setRational method
	public void setRational (int numer, int denom){
		numerator = numer;
		denominator = denom;
	}

	//write  a set method for numerator and denominator
	public void setNumerator (int numer) {
		numerator = numer;
	}
	
	public void setDenominator (int denom) {
		denominator = denom;
	}
	
	//ACCESSORS
	//write get methods for numerator and denominator
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		
		
		reduce();
	}

	private void reduce()
	{
		int GCD = gcd(numerator, denominator);
		numerator = numerator / GCD;
		denominator = denominator / GCD;
	}

	
	private int gcd(int numOne, int numTwo)
	{
		int GCD = 1;
		
		for (int i=1; i<=numOne && i<=numTwo; i++) {
			if (numOne % i == 0 && numTwo % i == 0)
				GCD = i;
		}

		return GCD;
	}

	
	public Object clone ()
	{
		return "";
	}
	
	
	public boolean equals( Object obj)
	{


		return false;
	}

	public int compareTo(Rational other)
	{


		return -1;
	}


	//write  toString() method
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	
}