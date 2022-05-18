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

import java.util.NoSuchElementException;

public class RunMed{
  private ALHeapMax lilVals;
  private ALHeapMin bigVals;

  public RunMed(){
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  public double getMedian(){
    if (lilVals.isEmpty() && bigVals.isEmpty()){ throw new NoSuchElementException("no elements found"); }
    else{
      if (lilVals.size() > bigVals.size()){
        return lilVals.peekMax() * 1.0;
      }
      else if (lilVals.size() < bigVals.size()){
        return bigVals.peekMin() * 1.0;
      }
      else{ // lilVals & bigVals have same size, so take avg of the two roots
        return (lilVals.peekMax() + bigVals.peekMin()) / 2.0;
      }
    }

  }

  public void add(Integer newVal){
    // if lilVals empty, add to it
    if (lilVals.isEmpty()){
      lilVals.add(newVal);
      return;
    }

    // if newVal < root of maxheap, add to maxheap
    if (newVal < lilVals.peekMax()){
      lilVals.add(newVal);
    }
    // else, add to minheap
    else{
      bigVals.add(newVal);
    }

    balanceHeaps();
  }

  public void balanceHeaps(){
    // if size difference >= 2, we need to do some balancing
    if (Math.abs(lilVals.size() - bigVals.size()) >= 2){
      if (lilVals.size() > bigVals.size()){ // balance by adding to bigVals
        bigVals.add(lilVals.removeMax());
      }
      else if (lilVals.size() < bigVals.size()){
        lilVals.add(bigVals.removeMin()); // balance by adding to lilVals
      }
    }
  }

}
