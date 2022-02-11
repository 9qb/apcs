// Team Team: Brian Li, Justin Mohabir, Neil Lin; Ducks: Robert, Hans, Hatch
// APCS pd07
// L06 -- Read/Review/Expand
// 2022-02-11
// time spent: 1.3 hours

public class OpenEnded{
  public static String reverso(String phrase){ // reverses each word in a phrase
    String reversedPhrase = "";
    String nextWord = "";
    phrase += " ";
    while(phrase.length() > 0 && phrase.indexOf(" ") > -1){
      nextWord = phrase.substring(0, phrase.indexOf(" ")); // finds next word
      reversedPhrase += reverseWord(nextWord) + " "; // adds reversed word to reversedPhrase
      phrase = phrase.substring(phrase.indexOf(" ") + 1); // removes nextWord from phrase
    }
    return reversedPhrase;
  }

  public static String reverseWord(String word){
    String reversed = "";
    for (int i = word.length() - 1; i > -1; i--){
      reversed += word.substring(i, i+1);
    }
    return reversed;
  }

  public static void main(String[] args){
    System.out.println(reverso("Hello world"));
  }
}
