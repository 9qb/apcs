// Brian Li + Robert
// APCS pd07
// HW63 -- CoBo Lab #2
// 2022-02-10
// time spent: 1.3 hours

public class OpenEnded{
  public static String reverso(String phrase){
    String reversedPhrase = "";
    String nextWord = "";
    phrase += " ";
    while(phrase.length() > 0 && phrase.indexOf(" ") > -1){
      nextWord = phrase.substring(0, phrase.indexOf(" "));
      reversedPhrase += reverseWord(nextWord) + " ";
      phrase = phrase.substring(phrase.indexOf(" ") + 1);
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
