package Unit05;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		WordsCompare w = new WordsCompare("abe", "ape");
		w.compare();
		System.out.println(w);
		
		w.setWords("giraffe", "gorilla");
		w.compare();
		System.out.println(w);
		
		w.setWords("one", "two");
		w.compare();
		System.out.println(w);
		
		w.setWords("fun", "funny");
		w.compare();
		System.out.println(w);
		
		w.setWords("123", "19");
		w.compare();
		System.out.println(w);
		
		w.setWords("193", "1910");
		w.compare();
		System.out.println(w);
		
		w.setWords("goofy", "godfather");
		w.compare();
		System.out.println(w);
		
		w.setWords("funnel", "fun");
		w.compare();
		System.out.println(w);
	}
}