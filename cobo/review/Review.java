import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();


  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        // System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  // ===========================================================================

  // activity 2.1
  public static double totalSentiment(String fileName){
    double totalSentimentVal = 0;
    String temp = "";
    String review = textToString(fileName);
    review += " ";
    while (review.length() > 0 && review.indexOf(" ") > -1){
      // System.out.println(review);
      temp = removePunctuation(review.substring(0, review.indexOf(" ")));
      totalSentimentVal += sentimentVal(temp);
      // System.out.println("index of space: " + review.indexOf(" "));
      review = review.substring(review.indexOf(" ") + 1);
    }
    return totalSentimentVal;
  }

  // activity 2.3
  public static int starRating(String fileName){
    double temp = totalSentiment(fileName);
    if (temp < 0){
      return 1;
    }
    else if (temp < 3){
      return 2;
    }
    else if (temp < 6){
      return 3;
    }
    else if (temp < 9){
      return 4;
    }
    else{
      return 5;
    }
  }

  // activity 3.4 & 4.4
  public static String fakeReview(String fileName){
    String original = textToString(fileName);
    original += " ";
    String altered = "";
    String nextWord = "";
    String storedPunctuation = "";
    String temp = "";

    while (original.length() > 0 && original.indexOf(" ") > -1){
      nextWord = original.substring(0, original.indexOf(" "));
      storedPunctuation = getPunctuation(nextWord);
      if (nextWord.indexOf("*") == -1){
        temp = removePunctuation(nextWord);
        nextWord = temp;
      }
      if (nextWord.indexOf("*") != -1){
        if (sentimentVal(nextWord.substring(1)) > 0){
          nextWord = randomPositiveAdj();
        }
        else{
          nextWord = randomNegativeAdj();
        }
      }
      altered += nextWord + storedPunctuation;
      altered += " ";
      original = original.substring(original.indexOf(" ") + 1);
    }

    altered.trim();
    return altered;
  }

  // tests code, as instructed by student guide
  public static void main(String[] args){
    // activity 1.2
    System.out.println(sentimentVal("poopy"));
    System.out.println(sentimentVal("abandoned"));
    System.out.println(sentimentVal("hello"));
    System.out.println(sentimentVal("later"));

    // activity 2.2
    System.out.println(totalSentiment("SimpleReview.txt"));
    System.out.println(totalSentiment("McDonaldsReview.txt"));

    // activity 2.5
    System.out.println(starRating("SimpleReview.txt"));
    System.out.println(starRating("McDonaldsReview.txt"));

    // testing fakeReview
    System.out.println(fakeReview("SimpleReview.txt"));
  }
}
