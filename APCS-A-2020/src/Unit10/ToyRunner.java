package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class ToyRunner
{
	public static void main(String[] args)
	{
		Toy sry = new Toy("sorry");
		Toy GIJoe = new Toy("gi joe");
		GIJoe.setCount(5);
		
		System.out.println(sry);
		System.out.println(GIJoe);

	}
}