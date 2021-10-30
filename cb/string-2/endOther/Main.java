// https://codingbat.com/prob/p126880

public class Main {
    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "abc")); // true
        System.out.println(endOther("AbC", "HiaBc")); // true
        System.out.println(endOther("abc", "abXabc")); // true
    }

    /*
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string.
     */
    public static boolean endOther(String a, String b) {
      int codeCounter = 0;
      for (int i = 0; i < str.length(); i++){
        if (i + 4 <= str.length()){
          if ((str.substring(i, i+2)).equals("co") && (str.substring(i+3, i+4)).equals("e")){
            codeCounter++;
          }
        }
      }
      return codeCounter;
    }
}
