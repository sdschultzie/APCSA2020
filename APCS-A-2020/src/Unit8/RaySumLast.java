package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int lastNum = ray[ray.length-1];
		int sum = 0;
		
		for (int num : ray) {
			if (num > lastNum)
				sum += num;
		}
		
		if (sum == 0)
			return -1;
		else 
			return sum;
	}
}