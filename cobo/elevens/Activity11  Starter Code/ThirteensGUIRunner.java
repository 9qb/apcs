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
 * This is a class that plays the GUI version of the Thirteens game.
 * See accompanying documents for a description of how Thirteens is played.
 */
public class ThirteensGUIRunner {

	/**
	 * Plays the GUI version of Thirteens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new ThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
