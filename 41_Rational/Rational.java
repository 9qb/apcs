public class Rational{
  public int p;
  public int q;
  public double ratio;

  public Rational(){
    p = 0;
    q = 1;
    ratio = p / q;
  }

  public Rational(int x, int y){
    p = x;
    q = y;
    ratio = p / q;
  }

  public float floatValue(){
    // return (float)(ratio + 0.5);
  }

  public String toString(){
    return p + "/" + q;
  }

  public void multiply(Rational factor){
    // this.p *= factor.p;
    // this.q *= factor.q;
    // ratio = p/q;
  }

  public void divide(Rational dividend){
    // this.p /= factor.p;
    // this.q /= factor.q;
    // ratio = p/q;
  }
}
