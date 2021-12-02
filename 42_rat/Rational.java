// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW42 -- Rational numbers
// 2021-12-02
// time spent: 0.x hours

/*
DISCO

QCC

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
      ratio = (double)p / (double)q;
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
    ratio = (double)p / (double)q;
  }

  public void divide(Rational divisor){
    if (divisor.q != 0){
      this.p *= divisor.q;
      this.q *= divisor.p;
      ratio = (double)p / (double)q;
    }
    else{
      System.out.println("Divide by 0 error.");
    }
  }

  public void simplify(){

  }

  public void add(Rational addend){
    p = ((double)this.p * addend.q) + ((double)this.p * this.q);
    q = ((double)this.q * addend.q);
  }

  public void subtract(){
    p = ((double)this.p * addend.q) - ((double)this.p * this.q);
    q = ((double)this.q * addend.q);
  }

  public void GCD(){

  }

  public void compareTo(){

  }

  )
}
