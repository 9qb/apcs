/*
 * Geese: Weichen Liu + Blueface, Anthony Sun + Corn, Brian Li + Robert
 * APCS
 * HW20 -- breaking other's code
 * 2021-10-19
 */

/*
 * DISCO:
 * You have to typecast numbers (ints) to short to run a method that accepts a short value.
 * If you withdraw a negative amount, you are adding money to that account.
 *
 * QCC:
 * Is it possible to typecast an int to short after taking the int in?
 * 
 * What operations are possible from BankAccount's main() but not Teller's?
   * You can change the values of the private instance variables in BankAccount but not in Teller. 
 *
 */


public class Teller {
	public static void main(String[] args) {
		BankAccount tester = new BankAccount();
		
		System.out.println("TESTING INTENDED FUNCTIONALITY.");
		System.out.println("Testing setName(\"Geese\"): " + tester.setName("Geese"));
		System.out.println("Testing setName(\"Goose\"): " + tester.setName("Goose"));
		System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing setPasswd(\"abc123\"): " + tester.setPasswd("abc123"));
                System.out.println("Testing setPasswd(\"12345\"): " + tester.setPasswd("12345"));
                System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing setPin(3333): " + tester.setPin((short) 3333));
                System.out.println("Testing setPin(9999):");
		System.out.println(tester.setPin((short) 9999));
                System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing setAcctNum(\"333\"):");
		System.out.println(tester.setAcctNum(333));
		System.out.println("Testing setAcctNum(\"123456789\"): " + tester.setAcctNum(123456789));
                System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing setBalance(300): " + tester.setBalance(300));
                System.out.println("Testing setName(-300): " + tester.setBalance(-300));
                System.out.println("The above shows intended functionality.\n");
		tester.deposit(300);
                System.out.println("Testing deposit(300)\n"+tester.toString());
                tester.deposit(500);
		System.out.println("Testing deposit(500)\n"+tester.toString());
                System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing withdraw(30): " + tester.withdraw(30.0));
                System.out.println("Testing withdraw(10000): ");
                System.out.println(tester.withdraw(10000.0));
		System.out.println("The above shows intended functionality.\n");
                System.out.println("Testing authenticate(args) with correct credentials: " + tester.authenticate(123456789,"12345"));
                System.out.println("Testing authenticate(args) with incorrect credentials: " + tester.authenticate(1223456789,"12345")); 
		System.out.println("Testing authenticate(args) with incorrect credentials: " + tester.authenticate(123456789,"12345123")); 
		System.out.println("The above shows intended functionality.\n");

		System.out.println("TESTING UNINTENDED FUNCTIONALITY - BREAKING CODE");
		System.out.println("Testing deposit(-1000). ");
		tester.deposit(-1000);
		System.out.println(tester.toString());
		System.out.println("The above shows unintended functionality. You cannot deposit a negative value.\n");
	
		System.out.println("Testing withdraw(-2000): " + tester.withdraw(-2000));
		System.out.println(tester.toString());
		System.out.println("The above shows unintended functionaltiy. You cannot withdraw a negative value.");
		/* These throw errors:
		 * tester.setPin(1000);
		 */










	}	



}
