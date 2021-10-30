// https://codingbat.com/prob/p111624

public class Main {
    public static void main(String[] args) {
        System.out.println(catDog("catdog")); // true
        System.out.println(catDog("catcat")); // false
        System.out.println(catDog("1cat1cadodog")); // true
    }

    /*
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     */
    public static boolean catDog(String str) {
      int catCounter = 0;
      int dogCounter = 0;
      for (int i = 0; i < str.length(); i++){
        if (i + 3 <= str.length()){
          if ((str.substring(i, i+3).equals("cat"))){
            catCounter++;
          }
          else if ((str.substring(i, i+3).equals("dog"))){
            dogCounter++;
          }
        }
      }
      return (catCounter == dogCounter);
    }
}
