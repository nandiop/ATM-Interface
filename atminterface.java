import java.util.Scanner;
class program2 
{
    public static String transation[]=new String[10];
    public static int transactioncount;
    public static void atminterface()
    {
        Scanner sc=new Scanner(System.in);
        int x,pin,entry;
        pin = 12345;
        System.out.println("Welcome to SBI ATM Machine!");
        System.out.println("Please enter your atm pin.");
        entry = sc.nextInt();
        if (pin != entry)
        {
            System.out.println("Incorrect pin.");
            System.out.println("Please enter your atm pin:");
            entry = sc.nextInt();
        }
        else
        {
        System.out.println("Correct pin.");
        }
       
        System.out.println("..............WELCOME MR.SURANJAN NANDI..............");
        System.out.println("Press 1 to start transaction:");
        x=sc.nextInt();
        int  Withdraw=0, Deposit=0, Transfer=0,   Balance;
        Balance=100000;
        String account_holder="";
        while(x==1)
        {

            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Transfer");
            System.out.println("Choose 4 for Transaction history");
            System.out.println("Choose 5 for Quit");  
            System.out.println("Choose any of the above operations:");
            
            int choice = sc.nextInt();  
            switch(choice)
            
            {
                case 1:
                System.out.println("Enter money to be withdrawn:");
                Withdraw = sc.nextInt();   
                if (Balance>=Withdraw)
                {
                    Balance=Balance-Withdraw;
                    System.out.println("Please collect your money!");
                    transactionupdate("Withdrawal:"+Withdraw);
                }
                else 
                {
                    System.out.println("Insufficient Balance.");
                }
                System.out.println("Remaining balance:"+Balance+"");
                
                break;

                case 2:
                System.out.println("Enter amount of money to be deposited:");
                Deposit = sc.nextInt();
                Balance=Deposit+Balance;
                System.out.println("Your money has been depositted sucessfully.");
                System.out.println("Remaining balance:"+Balance+"");
                transactionupdate("Deposit:"+Deposit);
                
                break;

                case 3:
                System.out.println("Enter amount of money to be transfered:");
                Transfer = sc.nextInt();
                
                if (Balance>=Transfer)
                {
                    System.out.println("Enter the account holder name:");
                    account_holder = sc.next();
                    Balance=Balance-Transfer;
                    System.out.println("Amount transfered to:"+account_holder+"");
                    transactionupdate("Transfer:"+Transfer);
                }
                else 
                {
                    System.out.println("Amount is not transfered due to insufficient balance:"); 
                }
                System.out.println("Remaining balance:"+Balance+"");
                
                
                break;

                case 4:
                for(int i=0;i<transactioncount;i++)
                {
                    System.out.println(transation[i]);
                }
             
                break;

                case 5:
                System.exit(0);
            }
            System.out.println("Press 1 to continue transaction and 0 to end transaction:");
            x=sc.nextInt();
        }
        sc.close();
    }
    public static void transactionupdate(String x)
    {
        transation[transactioncount]=x;
        transactioncount++;
    }
    public static void main(String[] args)
    {
        atminterface();
    }   
}
