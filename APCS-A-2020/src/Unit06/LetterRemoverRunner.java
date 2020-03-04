package Unit06;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		//add test cases	
		LetterRemover l = new LetterRemover("I am Sam I am", 'a');
		System.out.println(l);
		System.out.println(l.removeLetters());
		
		l.setRemover("ssssssssxssssesssssesss", 's');
		System.out.println(l);
		System.out.println(l.removeLetters());
		
		l.setRemover("qwertyqwertyqwerty", 'a');
		System.out.println(l);
		System.out.println(l.removeLetters());
		
		l.setRemover("abababababa", 'b');
		System.out.println(l);
		System.out.println(l.removeLetters());
		
		l.setRemover("abaababababa", 'x');
		System.out.println(l);
		System.out.println(l.removeLetters());
											
	}
}