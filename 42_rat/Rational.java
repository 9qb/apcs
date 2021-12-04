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

public class Rational{
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
    if (a < b) {
      return gcd(Math.abs(a), Math.abs(b - a));
    } else {
      return gcd(Math.abs(a - b), Math.abs(b));
    }
  }

  public int gcd(){
    return gcd(p, q);
  }

  public int compareTo(Rational compared){
    Rational temp = new Rational(p, q);
    temp.divide(compared);
    if (temp.ratio == 1){
      return 0;
    }
    else if (temp.ratio > 1){
      return 1;
    }
    else{
      return -1;
    }
  }

}
