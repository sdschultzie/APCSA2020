package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		int[] a1 = {7,1,5,3,11,5,6,7,8,9,10,12345,11};
		int[] a2 = {11,9,8,7,6,5,4,3,2,1,-99,7};
		int[] a3 = {10,20,30,40,5,41,31,20,11,7};
		int[] a4 = {32767,70,4,5,6,7};
		int[] a5 = {2,7,11,21,5,7};
		int[] a6 = {7,255,11,255,100,3,2};
		int[] a7 = {9,11,11,11,7,1000,3};
		int[] a8 = {7,7,7,11,2,7,7,11,11,2};
		int[] a9 = {2,4,6,8,8};

		System.out.println(RayOddToEven.go(a1));
		System.out.println(RayOddToEven.go(a2));
		System.out.println(RayOddToEven.go(a3));
		System.out.println(RayOddToEven.go(a4));
		System.out.println(RayOddToEven.go(a5));
		System.out.println(RayOddToEven.go(a6));
		System.out.println(RayOddToEven.go(a7));
		System.out.println(RayOddToEven.go(a8));
		System.out.println(RayOddToEven.go(a9));

	}
}