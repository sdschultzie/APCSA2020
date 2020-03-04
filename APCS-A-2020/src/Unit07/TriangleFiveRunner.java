package Unit07;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFiveRunner
{
   public static void main(String args[])
   {
	   TriangleFive test = new TriangleFive('C', 4);
	   System.out.println(test);
	   
	   test.setLetter('A');
	   test.setAmount(5);
	   System.out.println(test);
	   
	   test.setLetter('B');
	   test.setAmount(7);
	   System.out.println(test);
	   
	   test.setLetter('X');
	   test.setAmount(6);
	   System.out.println(test);
	   
	   test.setLetter('Z');
	   test.setAmount(8);
	   System.out.println(test);
	   
   }
}