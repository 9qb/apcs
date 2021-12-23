// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW49 -- Rational Standards Compliance
// 2021-12-22
// time spent: 0.5 hours

/*
DISCO
- You can create your own error messages using throw
- instanceof checks if an object is or isn't a certain class.

QCC
- Does instanceof return true if you check if a subclass is an instanceof a superclass?
*/

public class Driver{
  public static void main(String args[]){
    Rational a = new Rational(5, 0);
    Rational b = new Rational(3, 4);
    Rational c = new Rational(4, 2);
    Rational d = new Rational(6, 8);

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
    System.out.println("comparing b to d: " + b.compareTo(d));
    System.out.println("comparing d to b: " + d.compareTo(b));

    System.out.println("comparing c to c: " + c.compareTo(c));


    System.out.println("\nTesting for equal values:");
    System.out.println("comparing a to b: " + a.equals(b)); //false
    System.out.println("comparing a to c: " + a.equals(c)); //false
    System.out.println("comparing b to a: " + b.equals(a)); //false
    System.out.println("comparing b to c: " + b.equals(c)); //false
    System.out.println("comparing c to a: " + c.equals(a)); //false
    System.out.println("comparing c to b: " + c.equals(b)); //false
    System.out.println("comparing b to d: " + b.equals(d)); //true
    System.out.println("comparing d to b: " + d.equals(b)); //true

    System.out.println("comparing c to c: " + c.equals(c)); //true
    System.out.println("comparing c to int: " + c.equals(18)); //error
  }
}
