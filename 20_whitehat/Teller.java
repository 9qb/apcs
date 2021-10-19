public class Teller {
	public static void main(String[] args) {
		BankAccount tester = new BankAccount();
		
		System.out.println("Testing intended functionality.");
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












	}	



}
