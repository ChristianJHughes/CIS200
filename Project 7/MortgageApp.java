/**
* <MortgageApp.java>
* <Christian Hughes / Lab Friday/11:30>
*
* <This class contains no methods beyond main. The programs allows
* a banker to input loan information, and then subsequently recieve 
* infomrmation about loan payments. Up to 10 different loans can be 
* calculated per execution.> 
*/

import java.util.*; 
import java.text.*;

public class MortgageApp { 
	public static void main(String[] args) { 
		
		Scanner keyboard = new Scanner(System.in);
		Mortgage[] bankInfo = new Mortgage[10];
		int counter = 0;
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Please choose from the following choices below: "); 
			System.out.println("\t\t1) Promotional Loan ($100,000 @ 5.5% for 15 years)"); 
			System.out.println("\t\t2) Unique Loan (enter in loan values)");
			System.out.println("\t\t3) Quit (Exit the program)"); 
		 
			System.out.println();
			System.out.print("\t\tPlease enter your selection (1-3): "); 
			int userInput = Integer.parseInt(keyboard.nextLine());
			boolean badInput;
		
			do { 
				if (userInput == 1 || userInput == 2 || userInput == 3) { 
					badInput = false;
				}
				else { 
					System.out.print("\t\t\t\tInvalid Choice. Please Select 1, 2, or 3: "); 
					userInput = Integer.parseInt(keyboard.nextLine());
					badInput = true;
				}	
		
			
			} while (badInput == true);
		
			System.out.println();
		
			if (userInput == 1) { 
				System.out.println("PROMOTIONAL LOAN....:");
				
				bankInfo[i] = new Mortgage(5.5, 15, 100000); 
				//The toString() method calls the calc methods, so there is no reason to do it in main.
				System.out.print(bankInfo[i].toString());
				System.out.println();
				System.out.println();
				counter++;
				
			}
			else if (userInput == 2) { 
				bankInfo[i] = new Mortgage();
				bankInfo[i].storeLoanAmount();
				bankInfo[i].storeInterestRate(); 
				bankInfo[i].storeTerm();
				System.out.print("UNIQUE LOAN...:\n" + bankInfo[i].toString() + "\n\n");
				counter++;	
			}	
			else {
				i = 10;
				System.out.println("PROGRAM COMPLETE...Contents of Array:");
				System.out.println();
			}
		}
		
		//Print out the contents of the array
		for (int i = 0; i < counter; i++) { 
			System.out.println(bankInfo[i]); 
			System.out.println();
		}
		
	}	
}