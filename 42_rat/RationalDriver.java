// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW42 -- Rational numbers
// 2021-12-02
// time spent: 0.8 hours

/*
DISCO
- You can overload a method with a static and non-static version.

QCC
- Is there a more efficient way of adding and subtracting two rationals?
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

    // reset values
    a = new Rational();
    b = new Rational(3, 4);

    a.add(c);
    b.add(c);

    System.out.println("\nAfter adding original value by c:");
    System.out.println("a.toString(): " + a.toString());
    a.reduce();
    System.out.println("simplified a: " + a.toString());
    System.out.println("b.toString(): " + b.toString());
    b.reduce();
    System.out.println("simplified b: " + b.toString());
    System.out.println("the float value of a: " + a.floatValue());
    System.out.println("the float value of b: " + b.floatValue());

    // reset values
    a = new Rational();
    b = new Rational(3, 4);

    a.subtract(c);
    b.subtract(c);

    System.out.println("\nAfter subtracting original value by c:");
    System.out.println("a.toString(): " + a.toString());
    a.reduce();
    System.out.println("simplified a: " + a.toString());
    System.out.println("b.toString(): " + b.toString());
    b.reduce();
    System.out.println("simplified b: " + b.toString());
    System.out.println("the float value of a: " + a.floatValue());
    System.out.println("the float value of b: " + b.floatValue());

    // reset values
    a = new Rational();
    b = new Rational(3, 4);

    System.out.println("\nComparing original values:");
    System.out.println("comparing a to b: " + a.compareTo(b));
    System.out.println("comparing a to c: " + a.compareTo(c));
    System.out.println("comparing b to a: " + b.compareTo(a));
    System.out.println("comparing b to c: " + b.compareTo(c));
    System.out.println("comparing c to a: " + c.compareTo(a));
    System.out.println("comparing c to b: " + c.compareTo(b));

    System.out.println("comparing c to c: " + c.compareTo(c));
  }
}
