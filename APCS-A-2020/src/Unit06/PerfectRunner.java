package Unit06;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		Perfect p = new Perfect(496);
		System.out.println(p);
		
		p.setNumber(45);
		System.out.println(p);
		
		p.setNumber(6);
		System.out.println(p);
		
		p.setNumber(14);
		System.out.println(p);
		
		p.setNumber(8128);
		System.out.println(p);
		
		p.setNumber(1245);
		System.out.println(p);
		
		p.setNumber(33);
		System.out.println(p);
		
		p.setNumber(28);
		System.out.println(p);
		
		p.setNumber(27);
		System.out.println(p);
		
		p.setNumber(33550336);
		System.out.println(p);						
	}
}