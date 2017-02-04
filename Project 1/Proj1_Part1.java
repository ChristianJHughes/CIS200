/********************************************
*<Proj1_Part1.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program calculates monthly and total 
payments on a purchase with 1% financing.> 
*********************************************/

import java.util.*;
import java.text.*;

class Proj1_Part1 {
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in); 
	DecimalFormat df = new DecimalFormat("#,##0.00");
		
		final int months = 12; 
		final double financingRate = .01; 
		
		//Get User Input.
		System.out.print("Enter the amount of the purchase: "); 
		double purchasePrice = Double.parseDouble(keyboard.nextLine()); 
		
		//Calculate Payments. 
		double monthlyPayment = ((purchasePrice*financingRate)+purchasePrice) / months; 
		double totalPayment = monthlyPayment * months;  
		
		//Print out Payment Amounts. 
		System.out.println("Your monthly payment is $" + df.format(monthlyPayment));
		System.out.println("Your total payment is $" + df.format(totalPayment));	}
}