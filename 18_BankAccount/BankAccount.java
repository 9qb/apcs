// Geese (Brian Li, Weichen Liu, Anthony Sun, Robert, Blueface, Corn)
// APCS
// Hw18 -- Bank account
// 2021-10-18


/*
DISCOVERIES
- Static is needed to use instance variables in the same class. 
- If a class is executable, then its method must be static. 
- You could use a setter method to change private variables.

QCC
- Is it possible to not use static when running a method in the same class. 


Team Geese's Latest and Greatest Q2 Response:
- When generating an instance of a class, new ClassName();, parenthesis are used, which denotes a method. 
- An object is created, which means that something returned the object when instance is created.


Team Geese's Latest and Greatest Q3 Response:
- create object
- try System.out.println(objName)
- check is valid output is given.
*/


public class BankAccount {
  private String name;
  private String password;
  private int pin;
  private int accountNumber;
  private double balance;

  // sets given account name as bank account name
  public void setName(String userName) {
    name = userName;
  }

  // sets given account password as bank account password
  public void setPassword(String userPass) {
    password = userPass;
  }

  // sets given account pin as bank account pin
  public void setPin(int pinNum) {
    pin = pinNum;
  }

  // sets given account number as bank account number
  public void setAccNum(int accNum) {
    accountNumber = accNum;
  }

  // only displays public-facing information
  public void displayAccountInfo() {
    System.out.println(name);
    System.out.println(accountNumber);
    System.out.println(balance);
  }

  // deposits money into bank account if pin is correct
  public void deposit(double amount, int userPin) {
    if (pin == userPin) {
      balance += amount;
      System.out.println("Your new balance is " + balance);
    }
    else {
      System.out.println("Invalid pin #");
    }
  }

  // deposits money into bank account if password is correct
  public void deposit(double amount, String userPass) {
    if (password == userPass) {
      balance += amount;
      System.out.println("Your new balance is " + balance);
    }
    else {
      System.out.println("Invalid password");
    }
  }

  // withdraws money from bank account if pin is correct
  public void withdraw(double amount, int userPin) {
    if (pin == userPin) {
      if (balance-amount <0) {
        System.out.println("You cannot withdraw more than " + balance+". You will be in debt and we will be angry at you.");
      }
      else {
        balance -= amount;
        System.out.println("Your new balance is " + balance);

      }
    }
    else {
      System.out.println("Invalid pin #");
    }
  }

  // withdraws money from bank account if password is correct
  public void withdraw(double amount, String userPass) {
    if (password == userPass) {
      if (balance-amount <0) {
        System.out.println("You cannot withdraw more than " + balance+". You will be in debt and we will be angry at you.");
      }
      else {
        balance -= amount;
        System.out.println("Your new balance is " + balance);

      }
    }
    else {
      System.out.println("Invalid password");
    }
  }

  public static void main(String[] args) {
    BankAccount account = new BankAccount();

    account.name = "Insecure Geese";
    account.password = "abc123qwerty!";
    account.pin = 1234;
    account.accountNumber = 100000001;
    account.balance = 10.0;

    account.displayAccountInfo();

    System.out.println("Depositing:");
    account.deposit(500,1234);
    account.deposit(200, "abc123qwerty!");

    System.out.println("Deposit attempt with wrong password:");
    account.deposit(100000,"uwusenpai");

    System.out.println("Withdrawing:");
    account.withdraw(5, 1234);
    account.withdraw(4, "abc123qwerty!");

    System.out.println("Withdraw attempt with wrong password");
    account.withdraw(5, "qwertyuiop");
  }
}
