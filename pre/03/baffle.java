/**
Brian Li
APCS
HW05 -- Summer Prework
2021-09-27
*/

public class baffle {
  public static void zoop() {
      baffle();
      System.out.print("You wugga ");
      baffle();
  }

  public static void main(String[] args) {
      System.out.print("No, I ");
      zoop();
      System.out.print("I ");
      baffle();
  }

  public static void baffle() {
      System.out.print("wug");
      ping();
  }

  public static void ping() {
      System.out.println(".");
      // baffle();
  }
}

/**
1. What is the output of the following program?
Ping displays a single period as a string (.) and ends the line. When baffle is invoked, it prints
"wug" and then invokes ping (wug.). Zoop invokes baffle, prints "You wugga ", and
invokes baffle again (wug. You wugga wug.) As a result. the output of the program
will be "No, I wug.",  newline, then "You wugga wug." There is a newline, and then "I wug."

2. Draw a stack diagram that shows the state of the program the first time ping is invoked.
main   ||| return || "No, I wug."
zoop   ||| return || "wug."
baffle ||| return || "wug."
ping   ||| return || "."

3. What happens if you invoke baffle(); at the end of the ping method?
It results in a StackOverflowError because there is an infinite loop resulting from
ping() invoking itself.
*/
