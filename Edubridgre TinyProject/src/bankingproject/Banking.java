//Name : LOKKESWARAN P
//Enrollment Number : EBEON0823817746
//Tiny project title : Banking Application
/*Description:
 * The code comprises of a basic Banking Application 
 * The code projects about account creation, account details and essential banking statements
*/
//Keywords:class,public,private,protected,static,new,void,double,if,else,switch,case,default,for,return,break,true,false,extends etc


package bankingproject;

import java.util.Scanner;
import java.util.Random;


class random //class for random number generation used as id
{ 
	public long rdno()
	{
		Random rm = new Random();
		long number = rm.nextLong();//for random number generation
		number = Math.abs(number); //converts negative number to positive number
		return number; //returns the number where the method is called
	}

}

class BankDetails extends random //class for bank details
{
	protected long accountid; 
	protected String accountnumber;
	protected String name;
	protected String acctype;
	private double balance;
	


	Scanner in = new Scanner(System.in);

	public void account() //method to collects information from user
		{
			accountid = rdno(); //calls the random method
			System.out.println("Enter the account number: ");
			accountnumber = in.next();
			System.out.println("Enter Name: ");
			name = in.next();
			System.out.println("Enter Account Type: ");
			acctype = in.next();
			System.out.println("Enter the Balance: ");
			balance=in.nextDouble();
			System.out.println("------------------------------");
		}
	
	public void Details() //method to print the collected user information
	{
		System.out.println("ACCOUNT DETAILS: ");
		System.out.println("Account ID: " + accountid);
		System.out.println("Account Number:\n "+ accountnumber.toUpperCase());
		System.out.println("Account Name:\n "+ name.toUpperCase());
		System.out.println("Account Type:\n "+ acctype.toUpperCase());
		System.out.println("Account Balance:\n "+ balance);
	}
	
	
	public void deposit(int d) //method to deposit amount
	{
		
		balance = d+balance;
		System.out.println("Amount Deposited Successfully");
		System.out.println("Balance Amount\n" + balance);
	}
	
	public void withdraw(int w) //method to withdraw amount
	{
		if(w>balance)
			System.out.println("Insufficient Balance");
		else
			{
				balance = balance-w;
				System.out.println("Collect the Cash");
				System.out.println("Balance Amount\n" + balance);
			}
	}
	
	public void statement() //method to print the account statement
	{
		System.out.println("STATEMENT: ");
		System.out.println("Account ID: " + accountid);
		System.out.println("Balance: " + balance);
	}
	
	public boolean searchaccount(String a) //method to search user account
	{
		if(accountnumber.equals(a))
		{
			return true;
		}
		else
			return false;
	}
		
}
class newaccount extends BankDetails //class for new user account creation
{
	public String newacc()
	{
		System.out.println("Welcome!");
		accountid=rdno();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Account Number: ");
		accountnumber = in.next();
		System.out.println("Enter Name: ");
		name = in.next();
		System.out.println("Enter Account Type: ");
		acctype = in.next();
		return null;
	}
	public void disp()
	{
		System.out.println("Account Created Successfully!");
		Details();
	}
}





public class Banking {
	
	public static void Info() //display the banking action
	{
		System.out.println("Press the number to choose the action\n");
		System.out.println("1. Account Details");
		System.out.println("2. Create New Account");
		System.out.println("3. Deposit Amount");
		System.out.println("4. Withdraw Amount");
		System.out.println("5. Search Account");
		System.out.println("6. Statement");
		System.out.println("7. Exit\n");
	}

	public static void main(String[] args)
	{
		
		 Scanner in = new Scanner(System.in); 
		 int choice,na,i; 
		 System.out.println("Enter the number of accounts: ");
		 na = in.nextInt();
		 
		 BankDetails bd[]=new BankDetails[na];//declaring objects as array(Array of Objects)
		 
		 for(i=0;i<na;i++)
		 {
			 bd[i]=new BankDetails();//initializing the array 
			 bd[i].account();//defines the values of user input in the array
		 }
		 
		 Info();//displays the banking action
		 System.out.println("Enter the Choice: ");
		 choice = in.nextInt(); //choice to choose action
		 
		 switch(choice) //based on user input further actions are processed and displayed
		 {
		   default:
		   {
			   System.out.println("Invalid Number");
			   break;
		   }
		   case 1: //displays account details
		   {
			   for(i=0;i<na;i++)
			   {
				   bd[i].Details();
			   }
			   break;
		   }
		   case 2: //for creating a new account
		   {
			   newaccount nac = new newaccount(); 
			   nac.newacc();
			   nac.disp();
			   break;
			   
		   }
		   
		   case 3: //for depositing the amount
		   {
			   System.out.println("Enter the amount: ");
			   int amount = in.nextInt();
			   System.out.println("Enter account number: ");
			   String accno = in.next();
			   boolean found = false;
			   for(i=0;i<na;i++)
			   {
				   found = bd[i].searchaccount(accno); //search the account with user input
				   if(found)
				   {
					   System.out.println("DEPOSIT: ");		  
					   bd[i].deposit(amount); //if the value matches calls the deposit method
					   break;
				   }  
			   }
			   if(!found)
			   {
				   System.out.println("Invalid Details");
			   }
			   break;
		   }
		   
		   case 4:
		   {
			   System.out.println("WITHDRAW");
			   System.out.println("Enter the amount: ");
			   int amount = in.nextInt();
			   System.out.println("Enter account number: ");
			   String accno = in.next();
			   boolean found = false;
			   for(i=0;i<na;i++)
			   {
				   found = bd[i].searchaccount(accno); 
				   if(found)
				   {
					   bd[i].withdraw(amount);  //if the value matches calls the withdraw method
					   break;
				   }
			   }
			   if(!found)
			   {
				   System.out.println("Invalid Details");
			   }
			   break;
		   }
		   
		   case 5:
		   {
			   System.out.println("Enter Account Number: ");
			   String accno = in.next();
			   boolean found = false;
			   for(i=0;i<na;i++)
			   {
				   found = bd[i].searchaccount(accno);
				   if(found)
				   {
					   bd[i].Details(); 
					   break;
				   }
			   }
			   if(!found)
			   {
				   System.out.println("Invalid Details");
			   }
			   break;
			   
		   }
		   
		   
		   
		   case 6:
		   {
			   System.out.println("Enter account number: ");
			   String accno = in.next();
			   boolean found = false;
			   for(i=0;i<na;i++)
			   {
				   found = bd[i].searchaccount(accno);
				   if(found)
				   {
					   bd[i].statement();
					   break;
				   }
			   }
			   if(!found)
			   {
				   System.out.println("Invalid Details");
			   }
			   break;  
		   }
		   
		   case 7:
		   {
			   System.out.println("Thank You");
			   break;
		   }
		   
		 }
	}

}
