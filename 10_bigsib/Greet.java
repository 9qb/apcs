// Giant Pandas -- Brian Li, Weichen Liu, Melody Lew, Robert, Blueface, Ollie
// APCS
// HW10 -- Refactor Big Sib One
// 2021-10-04

/*
DISCOVERIES
 0. By changing the "void" in a method to "String", we are indicating what type of value we want this method to return. If it returns void, then nothing will be returned in the event that this method is called. 
    
UNRESOLVED QUESTIONS
 0. In the case that we are returning a String, like "17", and want to turn it into an integer, how would we do that?
*/

public class Greet {
    public static void main( String[] args ){
        System.out.println( BigSib.greet("Crosby") );
        System.out.println( BigSib.greet("Stills") );
        System.out.println( BigSib.greet("Nash") );
    }
}
