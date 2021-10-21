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

public class StatsDriver {
	public static void main(String[] args) {
		System.out.println("Testing cases:");
		System.out.print(Stats.mean(1,2));
		System.out.println("...should be 1");
		System.out.print(Stats.mean(12.4,10.0));
		System.out.println("...should be 11.2");
		System.out.print(Stats.max(5,1));
		System.out.println("....should be 5");
		System.out.print(Stats.max(5.3,1.1));
    System.out.println("...should be 5.3");
		System.out.print(Stats.geoMean(4,9));
		System.out.println("...should be 6");
		System.out.print(Stats.geoMean(0.25,0.04));
		System.out.println("...should be 0.1");

		System.out.println("\nTesting negative numbers:");
    System.out.print(Stats.mean(-10,-20));
    System.out.println("...should be -15");
    System.out.print(Stats.mean(-17.4,-6.0));
    System.out.println("...should be -11.7");
    System.out.print(Stats.max(-50,-1));
    System.out.println("....should be -1");
    System.out.print(Stats.max(-5.3,1.1));
    System.out.println("...should be 1.1");
    System.out.print(Stats.geoMean(-40,9));
    System.out.println("...should throw error"); // reality: 0
    System.out.print(Stats.geoMean(-0.25,-0.04));
    System.out.println("...should be 0.1");

		System.out.println("\nTesting overloaded methods:");
		System.out.print(Stats.max(-10, 0, 1));
		System.out.println("...should be 1");
		System.out.print(Stats.max(0.0, 4.0, 5.23));
		System.out.println("...should be 5.23");
		System.out.print(Stats.geoMean(2, 2, 16));
		System.out.println("...should be 4");
		System.out.print(Stats.geoMean(90, 3, 0));
		System.out.println("...should be 0");
	}
}
