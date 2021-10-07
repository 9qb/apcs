// Tiger -- Brian Li, Josiah Moltz, Jing Feng, Robert, Hedwig, Biscuit
// APCS
// HW14 -- Customize Your Creation
// 2021-10-07

/*
DISCO
 0. When we overload a method/constructor, we are able to supply different datatypes and/or a different number of arguments to methods of the same name. The method that is invoked depends on which method's parameters are satisfied by the arguments.
    
QCC
 0. Is it possible to overload main()? What would happen in that scenario?
*/

public class BigSib{
  String helloMsg;
 
  // used for defcon
  public BigSib(){
    helloMsg = "Hello";
  }

  // used for overcon
  public BigSib(String msg){
   helloMsg = msg;
  }

  // methods
  public String greet(String name){
    return(helloMsg + " " + name);
  }
 
}
