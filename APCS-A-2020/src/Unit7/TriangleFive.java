package Unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter('A');
		setAmount('1');
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		char originalLetter = letter;
		
		for (int i=0; i<amount; i++) {
			for(int j=0; j<amount-i; j++) {
				for (int k=amount; k>j; k--) {
					output += letter;
				}
				if (letter == 'Z')
					letter = 'A';
				else
					letter += 1;
				output += " ";
			}
			letter = originalLetter;
			output += "\n";
		}
		
		return output;
	}
}