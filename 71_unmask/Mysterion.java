public class Mystery{
  public static void algo(int[] array, int a, int b, int c){
    int v = array[c];
    swap(array, c, b);
    int s = a;
    for (int i = a; i < b; i++){
      if (array[i] < v){
        swap(array, s, i);
        s += 1;
      }
    }
    swap(array, b, s);
  }

  public static void swap(int[] array, int swap1, int swap2){
    int temp = array[swap1];
    array[swap1] = array[swap2];
    array[swap2] = temp;
  }

  public static String printArray(int[] array){
    String stringify = "[";
    for (int num : array){
      stringify += num + ", ";
    }
    stringify = stringify.substring(0, stringify.length() - 2) + "}";
    return stringify;
  }

  public static void main(String[] args){
    int[] test0 = {7,1,5,12,3};
    algo(test0, 0, 4, 2);
    System.out.println(printArray(test0));

    int[] test1 = {0,1,2,3,4};
    algo(test1, 0, 4, 2);
    System.out.println(printArray(test1));

    int[] test2 = {7,1,5,12,3};
    algo(test2, 1, 4, 2);
    System.out.println(printArray(test2));

    int[] test3 = {7,1,5,12,3};
    algo(test3, 1, 3, 2);
    System.out.println(printArray(test3));
  }

}
