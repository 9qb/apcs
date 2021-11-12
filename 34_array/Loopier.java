// Peanut Butter and Nutella -- Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS
// HW34 -- A Pirate's Life for Me
// 2021-11-12

public class Loopier{
  public static int[] populateRandom(int[] input){
    for (int counter = 0; counter < input.length; counter++){
      input[counter] = (int)(Math.random() * 100);
    }
    return input;
  }

  public static String printArray(int[] input){
    String stringForm = "{";
    for (int counter = 0; counter < input.length - 1; counter++){
      stringForm += input[counter] + ", ";
    }

    stringForm += input[input.length - 1] + "}";
    return stringForm;
  }

  public static int linSearch(int[] a, int target){
    for (int counter = 0; counter < a.length; counter++){
      if (a[counter] == target){
        return counter;
      }
    }
    return -1;
  }

  // public static int linSearchR(int[] a, int target){
  //
  // }

  public static void main(String[] args){
    int[] monkey = new int[3];
    int[] monke = {0, 11, 4, 7, 2, 2};

    // testing populateRandom
    populateRandom(monkey);

    // testing printArray
    System.out.println(printArray(monkey));

    // testing linSearch
    System.out.println(linSearch(monke, 3));
    System.out.println(linSearch(monke, 2));
  }
}
