// Giant Pandas -- Brian Li, Weichen Liu, Melody Lew
// APCS
// HW09 -- BigSibs and Greetings
// 2021-10-01

/*
DISCOVERIES
 0. You can't compile Greet.java without first compiling BigSib.java, because the code of Greet.java refers to elements of BigSib.
UNRESOLVED QUESTIONS
*/

public class Greet {
    public static void main( String[] args ) {
        BigSib.greet("Flim");
        BigSib.greet("Flam");
        BigSib.greet("Kazaam");
    }
}
