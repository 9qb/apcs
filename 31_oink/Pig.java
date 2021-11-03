/***
 * Geese - Brian Li + Robert, Anthony Sun + Corn, Weichen Liu + Blueface
 * APCS
 * HW31 -- Pig Skeleton
 * 2021-11-04
 * time spent: 0.7 hrs
 *
 * DISCO:
 * - You can string together methods to accomplish a complicated task
 * - You cannot index a String, and must use substring to access indiv. letters/chars
 * 
 * QCC:
 * - Is there a more efficient way of iterating through all the indices without using a for loop?
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    return (w.indexOf(letter) > -1);
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    for (int counter = 0; counter < VOWELS.length(); counter++){
      if (hasA(VOWELS.substring(counter, counter+1), letter)) {
        return true;
      }
    }
    return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    int vowelCount = 0;
    for (int counter = 0; counter < w.length(); counter++){
      if (isAVowel(w.substring(counter, counter + 1))){
        vowelCount++;
      }
    }
    return vowelCount;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
    return (countVowels(w) > 0);
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    String accumulator = "";
    for (int counter = 0; counter < w.length(); counter++){
      if (isAVowel(w.substring(counter, counter + 1))){
        accumulator += w.substring(counter, counter + 1);
      }
    }
    return accumulator;
  }


  public static void main( String[] args )
  {
    System.out.println(hasA("very good sire", "v") + "...expecting true");
    System.out.println(hasA("tuesday", "v") + "...expecting false"); // 
    System.out.println(hasA("qwertyuiop", "Q") + "...expecting false");
    System.out.println(hasA("ASDFGHJKL", "L") + "...expecting true");
    
    System.out.println(isAVowel("a") + "...expecting true");
    System.out.println(isAVowel("b") + "...expecting false");
    
    System.out.println(countVowels("abacus") + "...expecting 3");
    System.out.println(countVowels("yesterday") + "...expecting 3");
    System.out.println(countVowels("zxcvbnm") + "...expecting 0");
    
    System.out.println(hasAVowel("yay") + "...expecting true");
    System.out.println(hasAVowel("qywtsz") + "...expecting false");
    
    System.out.println(allVowels("clap appl3 pie big") + "...expecting \"aaiei\"");
    System.out.println(allVowels("yes, its trUe, indEEd, old mAcdOnAld hAd A fArm") + "...expecting \"eieio\"");
  }//end main()

}//end class Pig

