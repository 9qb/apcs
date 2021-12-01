public class RationalDriver{
  public static void main(String args[]){
    Rational first = new Rational();
    System.out.println(first.toString());

    Rational second = new Rational(3, 4);
    System.out.println(second.toString());

    System.out.println(second.floatValue());
    // System.out.println(second.multiply(first));
    System.out.println();
    System.out.println();
  }
}
