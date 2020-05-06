package Unit05;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   String vowels = "aeiouAEIOU";
	   char c = 'o';
	   System.out.println(c == vowels.charAt(3));
	   String firstChar =  a.substring(0,1);
	   String lastChar = a.substring(a.length()-1);
	   if (vowels.contains(firstChar) || vowels.contains(lastChar)) {
		   return "yes";
	   } else {
		   return "no";
	   }
	}
}