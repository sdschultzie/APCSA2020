package Unit06;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
    private String sentence;
    private char lookFor;

	public LetterRemover()
	{
		setRemover("hello chris", 'h');
	}

	public LetterRemover(String s, char c)
	{
		setRemover(s, c);
	}
	
	
	public void setRemover(String s, char c)
	{
		sentence = s;
		lookFor = c;
	}

	public String removeLetters()
	{
		String cleaned=sentence;
		
		while (cleaned.indexOf(lookFor) >= 0) {
			int index = cleaned.indexOf(lookFor);
			cleaned = cleaned.substring(0,index) + cleaned.substring(index+1);
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor;
	}
}