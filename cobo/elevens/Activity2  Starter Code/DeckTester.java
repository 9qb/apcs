//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//L07 - But These Go Up To Eleven
//2022-03-20
//time spent: 2.0 hr + class time

/*
DISCO
- Use "" or  \ before a space character to traverse through a dir with spaces in its name.

QCC
- Why would we want to use List<> var = new ArrayList() instead of ArrayList<> var = new ArrayList()?
*//**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = {"Eight", "Seven", "Eight"};
		String[] suits = {"Hearts", "Diamonds", "Spades"};
		int[] values = {8, 7, 8};
		Deck deck = new Deck(ranks, suits, values);

		System.out.println(deck.isEmpty());
		System.out.println(deck.size());
		deck.deal();
		deck.deal();
		deck.deal();
		System.out.println(deck.isEmpty());
		System.out.println(deck.size());

	}
}
