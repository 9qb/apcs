// Team (P)BNJ - Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// HW91 -- Deque the Halls
// 2022-04-13
// time spent: 0.1 hrs + class time

public class MRKPirateBae {
  public static void main (String[] args) {
    PBNJ<Comparable> test1 = new PBNJ();

    System.out.println("\nTesting add methods");
    System.out.println(test1.add("Brian Li"));
    System.out.println(test1.add("PBNJ"));
    test1.addFirst("Nakib Abedin");
    test1.addLast("Jefford Shau");
    System.out.println(test1);

    System.out.println("\nTesting peek methods");
    System.out.println(test1.peek());
    System.out.println(test1.peekFirst());
    System.out.println(test1.peekLast());

    System.out.println("\nTesting remove methods");
    System.out.println(test1.remove());
    System.out.println(test1);
    System.out.println(test1.removeFirst());
    System.out.println(test1);
    System.out.println(test1.removeLast());
    System.out.println(test1);

    System.out.println("\nTesting other methods");
    System.out.println(test1.isEmpty());
    System.out.println(test1.size());
    System.out.println(test1.contains("PBNJ"));
    System.out.println(test1.contains("Jefford Shau"));
    test1.clear();
    System.out.println(test1);
    System.out.println(test1.isEmpty());
  }




}
