/**
Brian Li
APCS
HW05 -- Summer Prework
2021-09-27
*/

public class Time{
  public static void main(String[] args){
    int hour = 9;
    int minute = 41;
    int second = 58;
    final int SECONDS_PER_MINUTE = 60;
    final int SECONDS_PER_HOUR = 3600;
    final int SECONDS_PER_DAY = 86400;

    // number of seconds since midnight
    int secsSinceMidnight = (hour * SECONDS_PER_HOUR) + (minute * SECONDS_PER_MINUTE)
    + second;
    System.out.print("The number of seconds since midnight: ");
    System.out.println(secsSinceMidnight);

    // number of seconds remaining in the day
    System.out.print("The number of seconds remaining in the day: ");
    System.out.println(SECONDS_PER_DAY - secsSinceMidnight);

    // percentage of the day that has passed
    System.out.printf("The percentage of the day that has passed: %.2f \n", secsSinceMidnight * 100.0
    / SECONDS_PER_DAY);

    // elapsed time
    int hour_Original = hour;
    int minute_Original = minute;
    int second_Original = second;
    hour = 12;
    minute = 11;
    second = 20;
    int secsSinceMidnight_Updated = (hour * SECONDS_PER_HOUR) + (minute * SECONDS_PER_MINUTE)
    + second;
    System.out.print("The elapsed time since this program was written: ");
    System.out.print(secsSinceMidnight_Updated - secsSinceMidnight);
    System.out.println(" seconds.");

  }
}
