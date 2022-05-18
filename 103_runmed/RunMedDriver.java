/*
(P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW103 -- Erica's Friends, Hugo, and The One in the Middle
2022-05-19r
Time Spent: 0.5 hrs + classtime

DISCO
1) Heaps can be used for keeping track of the median

QCC
1) Since heaps are good at keep track at min/max, could they potentially be useful in creating a sorted collection?

ALGO
(The same algo as the one on the board during class)

a. if next val < root of maxheap, add to maxheap
   else add to minheap

b. balance heaps (so that size difference < 2)
   (remove from larger heap, add to smaller heap)

c. at any time find med by:
    a) heap sizes equal: med is mean of roots
    b) heap sizes !equal: med is root of larger heap
*/

/**
   driver file for testing class RunMed

   (RunMed provides for calculating a running median
   of a stream of input ints)

   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java

   to feed numbers manually:
   $ java RunMed

   to feed in prepared set:
   $ java RunMed < input.nums
   (input.nums provided; must be in same dir)

   -------------------------
   Clyde "Thluffy" Sinclair
   APCS
   2018-05-17
*/

import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {

    RunMed r = new RunMed();

    int n;
    double median;
    int count = 0;
    Scanner sc = new Scanner( System.in );

    while( sc.hasNextInt() ) {
      try {
        n = sc.nextInt();
        System.out.print("read " + n + "\n");

        count++;
        System.out.print("this many ints have been seen: " + count + "\n");

        r.add(n);
        median = r.getMedian();
        System.out.print("median is now " + median + "\n");
      } catch (Exception e) {
        System.err.println("BOOP! probs w yer input:\n"+e);
      }
    }

  }//end main

}//end class
