package Unit07;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		String playing = "y";
		 
		//add in a do while loop after you get the basics up and running
		while (playing.equals("y")) 
		{
			System.out.print("\ntype in your weapon [R,P,S] :: ");
			//read in the player value
			String player = keyboard.next();
		
			RockPaperScissors game = new RockPaperScissors(player);		
			System.out.println(game);
			
			System.out.print("\nDo you want to play again? y/n ");
			playing = keyboard.next();
			
		}
	}
}



