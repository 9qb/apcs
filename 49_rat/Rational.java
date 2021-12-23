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

public class Rational implements Comparable{
  private int p;
  private int q;
  private double ratio;

  public Rational(){
    p = 0;
    q = 1;
    ratio = p / q;
  }

  public Rational(int x, int y){
    this();
    if (y != 0){
      p = x;
      q = y;
      ratio = (double)p / q;
    }
    else{
      System.out.println("The denominator cannot be equal to 0! Defaulting to 0/1.");
    }
  }

  public double floatValue(){
    return ratio;
  }

  public String toString(){
    return p + "/" + q;
  }

  public void multiply(Rational factor){
    this.p *= factor.p;
    this.q *= factor.q;
    ratio = (double)p / q;
  }

  public void divide(Rational divisor){
    if (divisor.q != 0){
      this.p *= divisor.q;
      this.q *= divisor.p;
      ratio = (double)p / q;
    }
    else{
      System.out.println("Divide by 0 error.");
    }
  }

  public void reduce(){
    int temp = gcd();
    p /= temp;
    q /= temp;
    ratio = (double)p / q;
  }

  public void add(Rational addend){
    int temp = this.q; // for storage
    int addendp = addend.p; // to avoid modification of parameter
    int addendq = addend.q;

    // converts rational to the same denominator
    this.p *= addend.q;
    this.q *= addend.q;
    addendp *= temp;
    addendq *= temp;
    this.p += addendp;
    ratio = (double)p / q;
  }

  public void subtract(Rational subtrahend){
    int temp = this.q; // for storage
    int subtrahendp = subtrahend.p; // to avoid modification of parameter
    int subtrahendq = subtrahend.q;

    // converts rational to the same denominator
    this.p *= subtrahend.q;
    this.q *= subtrahend.q;
    subtrahendp *= temp;
    subtrahendq *= temp;

    this.p -= subtrahendp;
    ratio = (double)p / q;
  }

  public static int gcd(int a, int b){
    if (a == b) {
      return a;
    }
    if (a == 0){
      return b;
    }
    if (b == 0){
      return a;
    }
    if (a < b) {
      return gcd(Math.abs(a), Math.abs(b - a));
    } else {
      return gcd(Math.abs(a - b), Math.abs(b));
    }
  }

  public int gcd(){
    return gcd(p, q);
  }

  public int compareTo(Object x){
    Rational temp = new Rational(p, q);
    if (x instanceof Rational){
      temp.divide((Rational)x);
      if (temp.ratio == 1){
        return 0;
      }
      else if (temp.ratio > 1){
        return 1;
      }
      else{ // temp.ratio < 1
        return -1;
      }
    }
    else{
      throw new ClassCastException("\ncompareTo() input not a Rational");
    }
  }

  public boolean equals(Object other){
    Rational temp = new Rational(p, q); // copies this Rational to temp, to avoid changing original values
    if (other instanceof Rational){
      ((Rational)other).reduce();
      temp.reduce();
      if (temp.p == ((Rational)other).p && temp.q == ((Rational)other).q){
        return true;
      }
      else{
        return false;
      }
    }
    else {
      throw new ClassCastException("\nequals() input not a Rational");
    }
  }

}
