public class PassBy{
  public static int changeInt(int arg){
    arg += 1;
    return arg;
  }

  public static String concatenate(String arg){
    arg += "hello";
    return arg;
  }

  public static void main(String[] args){
    int test = 10;
    int refTest = test;
    changeInt(refTest);
    System.out.println(test == refTest); // if true, then Java is pass-by-reference.
                                         // if false, then Java is pass-by-value.

    String testString = "hi";
    String anotherString = testString;
    concatenate(anotherString);
    System.out.println(testString.equals(anotherString)); // if true, then Java is pass-by-reference.
                                                          // if false, then Java is pass-by-value.
  }
}
