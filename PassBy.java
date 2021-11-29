public class PassBy{
  public static void main(String[] args){
    int test = 10;
    int refTest = test;
    refTest += 1;
    System.out.println(test == refTest); // if true, then Java is pass-by-reference.
                                         // if false, then Java is pass-by-value.

    String testString = "hi";
    String anotherString = testString;
    anotherString += "hello";
    System.out.println(testString.equals(anotherString)); // if true, then Java is pass-by-reference.
                                                          // if false, then Java is pass-by-value.
  }
}
