// Dynamic Duo of Destiny -- Brian Li, Kaitlin Ho, Robert, Apple
// APCS
// HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
// 2021-10-05

/*
DISCOVERIES
 0. When we create variable richard of type BigSib, richard is able to use all of the methods associated with the class BigSib, such as setHelloMsg and greet, in the form variableName/className.method().
 1. A static method is unable to reference instance variables. That is, the method is incapable of referencing variables outside of its own class. To remedy this, remove static from the class construction.
    
UNRESOLVED QUESTIONS
 0. When creating a variable of a class type, what happens if you put something within the parentheses of the class (e.g. BigSib richard = new BigSib();)? What does that affect?
*/

public class BigSib{
 String helloMsg;
 
  public String greet(String name){
    return(helloMsg + " " + name);
  }
 
  public void setHelloMsg(String msg){
   helloMsg = msg;
  }
 
}
