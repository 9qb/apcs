// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW41 -- Rational numbers
// 2021-12-01
// time spent: 0.6 hours

/*
DISCO
- Instance variables with a protected visibility are still able to interact laterally (that is, they can interact with classes of the same type).

QCC
- Doubles are more precise than floats, so why do floats even exist?
*/

public class RationalDriver{
  public static void main(String args[]){
    Rational a = new Rational(5, 0);
    Rational b = new Rational(3, 4);
    Rational c = new Rational(4, 2);

    System.out.println("a.toString(): " + a.toString());
    System.out.println("b.toString(): " + b.toString());
    System.out.println("c.toString(): " + c.toString());

    System.out.println("the float value of a: " + a.floatValue());
    System.out.println("the float value of b: " + b.floatValue());
    System.out.println("the float value of c: " + c.floatValue());

    a.multiply(c);
    b.multiply(c);

    System.out.println("\nAfter multiplying by c:");
    System.out.println("a.toString(): " + a.toString());
    System.out.println("b.toString(): " + b.toString());
    System.out.println("the float value of a: " + a.floatValue());
    System.out.println("the float value of b: " + b.floatValue());

    // reset values
    a = new Rational();
    b = new Rational(3, 4);

    a.divide(c);
    b.divide(c);

    System.out.println("\nAfter dividing original value by c:");
    System.out.println("a.toString(): " + a.toString());
    System.out.println("b.toString(): " + b.toString());
    System.out.println("the float value of a: " + a.floatValue());
    System.out.println("the float value of b: " + b.floatValue());
  }
}
