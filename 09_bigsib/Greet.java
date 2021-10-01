// Giant Pandas -- Brian Li, Weichen Liu, Melody Lew
// APCS
// HW09 -- BigSibs and Greetings
// 2021-10-01

/*
DISCOVERIES
 0. You can't compile Greet.java without first compiling BigSib.java, because the code of Greet.java refers to elements of BigSib. If BigSib.class is not present, compiling Greet.java will also compile BigSib.java.
UNRESOLVED QUESTIONS
 1. Since Greet.java and BigSib.java are located within the same directory, no import is needed. You can utilize methods from different classes in the form of <class name>.<method name>
*/

public class Greet {
    public static void main( String[] args ) {
        BigSib.greet("Flim");
        BigSib.greet("Flam");
        BigSib.greet("Kazaam");
    }
}
