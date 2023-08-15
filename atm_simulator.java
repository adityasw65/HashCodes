import java.util.*;
class Account 
{
  Scanner sc = new Scanner(System.in);
  private float bal;
  int pin;
  public Account(int pin)
  {
    this.pin = pin;
  }
  // balance checking function
  void checkBalance()
  {
    System.out.println("Your current balance: "+bal+"\n");
  }
  // withdraw money function
  void drawMoney()
  {
    float amt;
    System.out.print("Enter your withdrawal amount: ");
    amt = sc.nextFloat();
    if(bal > amt)
    {
      bal = bal - amt;
      System.out.println("Rs. "+amt+" has debited successfully from account..!");
    }
    else 
      System.out.println("Insufficient balance...!\n");
  }
  // deposite amount 
  void depositeAmount()
  {
    float amt;
    System.out.print("Enter amount to deposite: ");
    amt = sc.nextFloat();
    bal = bal + amt;
    System.out.println("Rs. "+amt+" has credited successfully in account..!");
  }
}

class Test 
{
  public static void main(String args[])
  {
    System.out.println("\n====================== WELCOME TO ATM SIMULATOR SYSTEM ========================\n");
    Scanner sc = new Scanner(System.in);
    Account a1 = new Account(12345678);
    // Account a2 = new Account(12345679);
    // Account a3 = new Account(12345768);
    // Account a4 = new Account(12345697);
    int ch1;
    int pin;
    System.out.println("Enter your pin: ");
    pin = sc.nextInt();
    if(pin == a1.pin)
    {
      while(true)
      {
        System.out.print("\nCheck options - \n1. Check Balance\n2. Withdraw Money\n3. Deposite Money\n4.Exit\n\nSelect your choice: ");
        ch1 = sc.nextInt();
        switch(ch1)
        {
          case 1 :
            a1.checkBalance();
            break;
          case 2 :
            a1.drawMoney();
            break;
          case 3 : 
            a1.depositeAmount();
            break;
          case 4 : 
            System.out.println("******* Thank yor for visiting our ATM simulator System...! *******");
            System.exit(0);
            break;
          default : 
            System.out.println("Invalid choice selected...");
            break;
        }
      }
    }
    else 
      System.out.println("Invalid pin...!!");
  }
}




