// Geese: Weichen Liu + Blueface, Anthony Sun + Corn, Brian Li + Robert
// APCS
// HW21 -- Building Drivers and Stat Methods
// 2021-10-21

/*
DISCO:
- When trying to convert values from one type to another (e.g. double to int), you will get an error stating incompatible types if there is a change in precision.

QCC:
- How would you go about changing a double to an int WITHOUT typecasting? Due to the differeces in precision, it doesn't seem like there is a clean method of doing so.
- With the method geoMean() that returns an int, we saw that it returns 0 when we would expect an error or NaN (such as when taking the square root of a negative value). We believe that this is a result of an int not being able to store NaN as a data value, resulting in it returning 0, instead.
*/

// skeleton taken from closet

public class Stats {

  public static int mean(int a, int b) {
	int x= (a+b)/2;
  	return x;
  }

  public static double mean(double a, double b) {
	return (a+b)/2.0;
  }

  public static int max(int a, int b) {
	if (a > b) {
		return a;
	}
	return b;
  }

  public static double max(double a, double b) {
	if (a > b) {
		return a;
	}
	return b;
  }

  public static int geoMean(int a, int b) {
	   int x = (int) Math.sqrt(a*b);
     return x;
  }

  public static double geoMean(double a, double b) {
	return Math.sqrt(a*b);
  }

  public static int max(int a, int b, int c) {
	int max = a;
	if (b > a) {
		max = b;
	}
	if (c > max) {
		max = c;
	}
	return max;
  }

  public static double max(double a, double b, double c) {
	double max = a;
        if (b > a) {
                max = b;
        }
        if (c > max) {
                max = c;
        }
        return max;
  }

  public static int geoMean(int a, int b, int c) {
	int x = (int) Math.cbrt(a*b*c);
 	return x;
  }

  public static double geoMean(double a, double b, double c) {
	return Math.cbrt(a*b*c);
  }


  //main method for testing functionality
  public static void main( String[] args ) {
	System.out.println("ran");
  }

}//end class
