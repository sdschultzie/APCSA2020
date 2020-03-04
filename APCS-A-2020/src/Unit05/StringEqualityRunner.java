package Unit05;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		StringEquality s = new StringEquality("hello", "goodbye");
		System.out.println(s);
		
		s.setWords("one", "two");
		System.out.println(s);
		
		s.setWords("three", "four");
		System.out.println(s);
		
		s.setWords("TCEA", "UIL");
		System.out.println(s);
		
		s.setWords("State", "Champions");
		System.out.println(s);
		
		s.setWords("ABC", "ABC");
		System.out.println(s);
		
		s.setWords("ABC", "CBA");
		System.out.println(s);
		
		s.setWords("Same", "Same");
		System.out.println(s);
	}
}