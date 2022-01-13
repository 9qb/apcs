// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW56 -- Turing Training Wheels
// 2022-01-12
// time spent: 1.0 hours

/*
DISCO:
- The else-if statement that is utilized is the one with greater priority.
- trim() gets rid of leading and lagging whitespace.
QCC:
- Is there a way to refactor the code so that it isn't so "long"?
*/

/**
 * A program to allow students to try out different
 * String methods.
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";

		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);

		int hePosition = sample.indexOf("he");
		int overloadPosition = sample.indexOf("he", 3);
		System.out.println("sample.indexOf(\"he\") = " + hePosition);
		System.out.println("sample.indexOf(\"he\", 3) = " + overloadPosition);
	}

}
