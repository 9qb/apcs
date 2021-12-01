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

public class Rational{
  protected int p;
  protected int q;
  protected double ratio;

  public Rational(){
    p = 0;
    q = 1;
    ratio = p / q;
  }

  public Rational(int x, int y){
    if (y != 0){
      p = x;
      q = y;
      ratio = (double)p / (double)q;
    }
    else{
      System.out.println("The denominator cannot be equal to 0! Defaulting to 0/1.");
      p = 0;
      q = 1;
      ratio = p / q;
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
    ratio = (double)p / (double)q;
  }

  public void divide(Rational divisor){
    this.p *= divisor.q;
    this.q *= divisor.p;
    ratio = (double)p / (double)q;
  }
}
