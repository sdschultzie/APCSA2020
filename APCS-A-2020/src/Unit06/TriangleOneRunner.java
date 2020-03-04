package Unit06;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		TriangleOne t = new TriangleOne("hippo");
		t.print();
		t.setWord("abcd");
		t.print();
		t.setWord("it");		
		t.print();
		t.setWord("a");		
		t.print();
		t.setWord("chicken");		
		t.print();
	}
}