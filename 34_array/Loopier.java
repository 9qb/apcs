// Peanut Butter and Nutella -- Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS
// HW34 -- A Pirate's Life for Me
// 2021-11-12

/*
DISCO
- With arrays, you can use Array.length to get the number of indexes (indices?), as opposed to using String.length() to find the number of characters in a string.

QCC
- Is there a method that allows you to get a subarray of an array, much like how you could get a substring of a String?
- Is there a better way of implementing recursion with linSearch and freq?
- Why would you use recursion for methods like linSearch and Freq? It seems much more straightforward to accomplish the task via iteration.
*/

public class Loopier{
  public static int[] populateRandom(int[] input, int maxValue){
    for (int counter = 0; counter < input.length; counter++){
      input[counter] = (int)(Math.random() * maxValue);
    }
    return input;
  }

  public static String stringifyArray(int[] input){
    String stringForm = "{";
    for (int index : input){
      stringForm += index + ", ";
    }
    stringForm = stringForm.substring(0, stringForm.length() - 2) + "}"; // removes ", " at the end of the String and appends "}"
    return stringForm;
  }

  public static int linSearch(int[] a, int target){
    int counter = 0;
    for (int index : a){
      if (index == target){
        return counter;
      }
      counter++;
    }
    return -1;
  }

  public static int linSearchR(int[] a, int target){
    return linSearchRHelper(a, target, 0);
  }

  public static int linSearchRHelper(int[] a, int target, int counter){
    if (counter == a.length){ // checks if counter has gone out of bounds
      return -1;
    }
    else if (a[counter] == target){ // checks if index is equal to target
      return counter;
    }
    else{
      return linSearchRHelper(a, target, counter + 1); // recursive call
    }
  }

  public static int freq(int[] a, int target){
    int accumulation = 0;
    for (int index : a){
      if (index == target){
        accumulation++;
      }
    }
    return accumulation;
  }

  public static int freqRec(int[] a, int target){
    return freqRecHelper(a, target, 0, 0);
  }

  public static int freqRecHelper(int[] a, int target, int counter, int accumulator){
    if (counter == a.length){
      return accumulator;
    }
    else if (a[counter] == target){ // if index is equal to target, add 1 occurence and then continue to the next index
      return freqRecHelper(a, target, counter + 1, accumulator + 1); // recursive call
    }
    else { // if index is not equal to target, no occurence is added to total accumulator, move onto next index
      return freqRecHelper(a, target, counter + 1, accumulator);
    }
  }

  public static void main(String[] args){
    int[] monkey = new int[3];
    int[] monke = {0, 11, 4, 7, 2, 2};

    // testing populateRandom
    populateRandom(monkey, 100);

    // testing printArray
    System.out.println(stringifyArray(monkey));

    // testing linSearch
    System.out.println(linSearch(monke, 3) + " ...expecting -1");
    System.out.println(linSearch(monke, 2) + " ...expecting 4");

    // testing linSearchR
    System.out.println(linSearchR(monke, 3) + " ...expecting -1");
    System.out.println(linSearchR(monke, 2) + " ...expecting 4");

    // testing freq
    System.out.println(freq(monke, 11) + " ... expecting 1");
    System.out.println(freq(monke, 12) + " ... expecting 0");
    System.out.println(freq(monke, 2) + " ... expecting 2");

    // testing freqRec
    System.out.println(freqRec(monke, 11) + " ... expecting 1");
    System.out.println(freqRec(monke, 12) + " ... expecting 0");
    System.out.println(freqRec(monke, 2) + " ... expecting 2");
  }
}
