/**
* <Mortgage.java>
* <Christian Hughes / Lab Friday/11:30>
*
* <The Mortgage class contains multiple methods for accepting,
* calculating on, and desplaying loan information. The methods 
* present are most often used in the accompanying MortgageApp 
* class.> 
*/

import java.util.*;
import java.text.*;

public class Mortgage {
	
	private double interestRate; 
	private double loanTerm; 
	private double loanAmount; 
	Random rand = new Random(); 
	int accountNumber;
	
	Scanner keyboard = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat(",##0.00");
	
	public Mortgage() {
		accountNumber = (rand.nextInt(9001)+100);
	}
	
	public Mortgage(double passInterestRate, double passLoanTerm, double passLoanAmount) { 
		interestRate = passInterestRate; 
		loanTerm = passLoanTerm;
		loanAmount = passLoanAmount;
		accountNumber = (rand.nextInt(9001)+100);
	}
	
	
	/**
	* (Stores the loan amount entered my the user.) 
	*/
	public void storeLoanAmount() { 
		
		//Read in User Input
		System.out.print("Enter loan amount without $ or commas (Ex: 120000): ");
		double userInput = Double.parseDouble(keyboard.nextLine()); 
		
		//Validate User Input, and Store it
		boolean badInput; 
		
		do {
			if (userInput >= 50000 && userInput <= 1000000) { 
				badInput = false;
				loanAmount = userInput;	
				
			}
			else {
				badInput = true;
				System.out.println("\t\tValid Loan Amounts are $50,000 - $1,000,000");
				System.out.print("\t\tPlease Re-Enter Loan Amount Without $ or Commas (Ex: 120000): ");
				userInput = Double.parseDouble(keyboard.nextLine());
			}	
		} while (badInput == true);
		System.out.println();
	}
	
	/**
	* (Stores the loan term length entered my the user.) 
	*/
	public void storeTerm() {
		//Read in User Input
		System.out.print("Enter number of years for the loan (5-50): ");
		double userInput = Double.parseDouble(keyboard.nextLine()); 
				
		//Validate User Input, and Store it
		boolean badInput; 
				
		do {
			if (userInput >= 5 && userInput <= 50) { 
				badInput = false;
				loanTerm = userInput;	
				
			}
			else {
				badInput = true;
				System.out.println("\t\tValid Loan Terms are 5-50");
				System.out.print("\t\tPlease Re-Enter Valid Number of Years: ");
				userInput = Double.parseDouble(keyboard.nextLine());
			}	
		} while (badInput == true);
		
		System.out.println(); 
	}
	
	/**
	* (Stores the loan interest amount entered my the user.) 
	*/ 
	public void storeInterestRate() { 
		//Read in User Input
		System.out.print("Enter yearly interest rate (Ex: 8.25): ");
		double userInput = Double.parseDouble(keyboard.nextLine()); 
			
		//Validate User Input, and Store it
		boolean badInput; 
				
		do {
			if (userInput >= 1 && userInput <= 9) { 
				badInput = false;
				interestRate = userInput;	
				
			}
			else {
				badInput = true;
				System.out.println("\t\tValid Interest Rates are 1% - 9%");
				System.out.print("\t\tPlease Re-Enter Valid Yearly Interest Rate (Ex: 8.25): ");
				userInput = Double.parseDouble(keyboard.nextLine());
			}	
		} while (badInput == true);
		
		System.out.println(); 	
	}
	
	/**
	* (Calculates the monthly loan payment.)
	*
	* @return (Returns the monthly loan payment.) 
	*/ 
	private double calcMonthlyPayment() { 
		double totalMonths = loanTerm * 12;
		double monthlyPayment = loanAmount * ((((interestRate*.01 / 12) * (Math.pow((1+(interestRate*.01 / 12)),totalMonths))) / ((Math.pow((1+(interestRate*.01 / 12)),totalMonths))-1)));
		return monthlyPayment;	
	}
	
	/**
	* (Calculates the total amount paid over the entire lifespan of the loan.)
	*
	* @return (Returns the total amount paid as a double.) 
	*/ 
	private double calcTotalPayment() { 
		double totalMonths = loanTerm * 12; 
		double totalPayment = calcMonthlyPayment() * totalMonths; 
		return totalPayment;	
	}
	
	/**
	* (Outputs Loan information as a string. The string is not printed.)
	*
	* @return (Returns a string of the Account Number, the monthly payment, and the total payment; these are all on different lines.) 
	*/ 
	public String toString() { 
		String finalString = "Account Number: " + accountNumber + "\nThe Monthly Payment is $" + df.format(calcMonthlyPayment()) + "\nThe Total Payment is $" + df.format(calcTotalPayment()) + "\n"; 
		return finalString;
	} 
	
}