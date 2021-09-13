import java.util.Scanner;

class Account{
    String name,aType;
    int aNum;
    double aBal;
    Account(){
      
    }
        Account(String n,int aNum,int b,String a_t){
            name=n;
            aNum=aNum;
            aBal=b;
            aType=a_t;
        }
} // end class

class create_account extends Account{
    create_account(String n,int aNum,int b,String a_t){ // pass name and account type 
            name=n;
            aNum=aNum;
            aBal=b;
            aType=a_t;
    }
   
        
    void insert(String n,int aNum,String a_t){ // input user name, account number and type 
        name=n;
        aType=a_t;
        aNum=aNum; // generate random number 
        aBal=0;
    }
    
    void displayAccountDetails(){
        System.out.println("Depositor Name :" +name);
        System.out.println("Account Number : "+aNum);
        System.out.println("Account Balance : "+aBal);
        System.out.println("Account Type : "+aType);
    }
 
        void deposit(int aNum,int money){                 
                aBal=money;    
        }
        
        double withdraw(double withd){
                aBal=aBal-withd;
                return aBal;
        }
        void calculateZakat()
        {
        	if(aBal>=20000)
        	{
        		aBal=(aBal*2.5)/100;
        		System.out.println(aBal);
        		
        	}
        }
  
} // end class 

      
public class Main {
    public static void main(String args[]){
        String user_name=null,type;
        type = null;
        int balance=0,tmp=0;
        int withd=0;
        double cb=0;
// to generate Random Account Number 
int aNumber = 0; 
aNumber = (int)((Math.random() * 9000)+1000); 

        create_account user = new create_account("user",0,0,"savings"); // initilaize -- name,aNumber,Balance,Type
    
            Scanner in = new Scanner(System.in);
            Scanner strng=new Scanner(System.in);
            int userChoice;
            boolean quit = false;

            do {
                  System.out.println("1. Create Account");
                  System.out.println("2. Deposit money");
                  System.out.println("3. Withdraw money");
                  System.out.println("4. Check balance");
                  System.out.println("5. Display Account Details");
                  System.out.println("6. Zakat");
                  System.out.println("0. to quit: \n");
                  System.out.print("Enter Your Choice : ");
                  userChoice = in.nextInt();
                  switch (userChoice) {
                      
                  case 1:
                        System.out.print("Enter your Name : ");
                        user_name=strng.nextLine(); 
                        System.out.print("Enter Accout Type : ");
                        type=in.next();
                        user.insert(user_name, aNumber, type);  // inserted 
                        System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
                        System.out.println("**************************");                       
                        user.displayAccountDetails();
                        break;
                      
                case 2: // deposit
                    System.out.print("Enter your account Number : ");
                    tmp=in.nextInt();
                 if(tmp==user.aNum){
                 System.out.print("Enter Amount Of Money : ");
                 balance=in.nextInt();
                 user.aBal=balance;
                 System.out.println("\t Successfully depositd.");
              }                
                     else
                    System.out.println("Wrong Accoount Number.");          
                   break;
                    
                  case 3: // withdraw money                      
                     System.out.print("Enter your account Number : ");
                      tmp=in.nextInt();
                      
                          if(tmp==user.aNum){                         
                             if(user.aBal==0)
                             System.out.print("Your Account is Empty.");
                             
                             else{
                             System.out.print("Enter Amout Of Money : ");   
                             withd=in.nextInt();  
                             
                             if(withd>user.aBal){
                             System.out.print("Enter Valid Amout of Money : ");
                             withd=in.nextInt();
                             }
                             else
                             cb= user.withdraw(withd);
                             System.out.println("Your Current Balance : "+cb);   
                             }
                          }
                             else
                             System.out.println("Wrong Accoount Number.");  
                        break;
     
                  case 4: // check balance 

                      System.out.print("Enter your Account Number : ");
                      tmp=in.nextInt();
                      
                             if(tmp==user.aNum){
                             System.out.println("Your Current Balance : "+user.aBal);
                             }
                             else
                             System.out.println("Wrong Accoount Number.");                         
                      break;
                      
                  case 5: // display all info 
                          
                      System.out.print("Enter your Account Number :");
                      tmp=in.nextInt();                     
                             if(tmp==user.aNum){                               
                             user.displayAccountDetails();                             
                        }else
                             System.out.println("Wrong Accoount Number.");
                             
                      break;
                      
                  case 6: //Zakat
                	  System.out.print("Enter you account number:");
                	  tmp=in.nextInt();
                	 user.calculateZakat();
                  case 0:
                        quit = true;
                        break;
                  default:
                        System.out.println("Wrong Choice.");
                        break;
                  }
                  System.out.println("\n");
            } while (!quit);
            System.out.println("Thanks !");
             
     } 
    
} 