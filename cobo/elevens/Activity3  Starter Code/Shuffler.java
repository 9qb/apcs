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
 * This class provides a convenient way to test shuffling methods.
 */

 import java.util.ArrayList;

public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 5;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		ArrayList<Integer> jCards = new ArrayList<>();
		ArrayList<Integer> kCards = new ArrayList<>();

		for(int i=0; i < values.length; i++){
			if(i < values.length/2){
				jCards.add(values[i]);
			}else{
				kCards.add(values[i]);
			}
		}

		int jCounter = 0;
		int kCounter = 0;

		for(int e=0; e < values.length; e++){
			if(e%2 == 0){
				values[e] = jCards.get(jCounter);
				jCounter++;
			}else{
				values[e] = kCards.get(kCounter);
				kCounter++;
			}
		}

	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] shuffle = new int[values.length];
		int j;

		for(int k = 0; k < values.length; k++){
			j = (int) (Math.random()*(values.length));
			while((values[j] == -1)){
				j = (int) (Math.random()*(values.length));
			}
			shuffle[k] = values[j];
			values[j] = -1;

		}

		for(int i=0; i<shuffle.length; i++){
			values[i] = shuffle[i];
		}
	}
}
