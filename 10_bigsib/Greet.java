// Giant Pandas -- Brian Li, Weichen Liu, Melody Lew, Robert, Blueface, Ollie
// APCS
// HW09 -- BigSibs and Greetings
// 2021-10-01

/*
DISCOVERIES
 0. You can't compile Greet.java without first compiling BigSib.java, because the code of Greet.java refers to elements of BigSib. If BigSib.class is not present, compiling Greet.java will also compile BigSib.java.
 1. Since Greet.java and BigSib.java are located within the same directory, no import is needed. You can utilize methods from different classes in the form of <class name>.<method name>
 2. Due to BigSib.java not having a main() method, running its compiled class will return an error.
      Error: Main method not found in class BigSib, please define the main method as:
         public static void main(String[] args)
      or a JavaFX application class must extend javafx.application.Application
 3. If you remove a dependency for Greet.java (that is, BigSib.class,) and attempt to run Greet.class, you will get an error message:
      Exception in thread "main" java.lang.NoClassDefFoundError: Big Sib
              at Greet.main(Greet.java:14)
      Caused by: java.lang.ClassNotFoundException: BigSib
      ...
    To fix this error, you must compile BigSib.java or re-compile Greet.java.
    
UNRESOLVED QUESTIONS
 0. What is a JavaFX application? What is javafx.application.Application?
*/

public class Greet {
    public static void main( String[] args ) {
        BigSib.greet("Flim");
        BigSib.greet("Flam");
        BigSib.greet("Kazaam");
    }
}
