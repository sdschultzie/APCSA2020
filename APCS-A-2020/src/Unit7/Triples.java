package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		int i = 1;
		
		while (i < a && i < b && i < c)
		{
			if (a%i == 0 && b%i == 0 && c%i == 0) {
				max = i;
				i++;
			} else {
				i++;
			}
		}
		return max;
	}
	
	private boolean pythagoreanCheck(int a, int b, int c)
	{
		return a*a + b*b == c*c;
	}
	
	private boolean oddEvenCheck(int a, int b, int c)
	{
		if (c%2 != 0) {
			if ((a%2 != 0 && b%2 == 0) || (a%2 == 0 && b%2 != 0))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	

	public String toString()
	{
		String output="";
		
		for (int i=1; i<number; i++) {
			for (int j=i; j<number; j++) {
				for (int k=1; k<number; k++) {
					if (greatestCommonFactor(i,j,k) <= 1 && pythagoreanCheck(i,j,k) && oddEvenCheck(i,j,k)) {
						output += i + " " + j + " " + k + "\n";
					}
				}
			}
		}
		return output+"\n";
	}
}