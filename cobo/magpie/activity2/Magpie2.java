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
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

 // Q1: when a keyword is included in another word, it generates a response
 // corresponding to the keyword, resulting in a response that doesn't make
 // sense.

public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		// responses are prioritized by ranking. the response is based on
		// which of the if statements or if-else statements is satisfied first.

		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("cat") >= 0
				|| statement.indexOf("dog") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("Mykolyk") >= 0)
		{
			response = "He sounds like a good teacher.";
		}
		else if ((statement.trim()).equals("")){
			response = "Say something, please.";
		}
		else if (statement.indexOf("like") >= 0)
		{
			response = "I like it, too.";
		}
		else if (statement.indexOf("sad") >= 0)
		{
			response = "Smile, life is beautiful.";
		}
		else if (statement.indexOf("happy") >= 0)
		{
			response = "Being happy is great.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Cool.";
		}
		else if (whichResponse == 5)
		{
			response = "Oh, really?";
		}

		return response;
	}
}
