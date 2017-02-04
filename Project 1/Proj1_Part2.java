/********************************************
*<Proj1_Part2.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program calculates sale tax and total 
cost of purchasing a new car.> 
*********************************************/

import java.util.*;
import java.text.*;

class Proj1_Part2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("##,##0.00");
		
		final double taxRate = .075; 
		
		//Get User's Name.
		System.out.print("Please enter your first name: ");
		String name = keyboard.nextLine();
		
		//Get Car Price.
		System.out.print("Enter the price of your car: "); 
		double carPrice = Double.parseDouble(keyboard.nextLine());
		
		//Calculate Sales Tax and Total Price.
		double salesTax = carPrice * taxRate;
		double totalPrice = carPrice + salesTax; 
		
		//Output Information to User. 
		System.out.println(name + ",");
		System.out.println(" The sales tax on your purchase is $" + df.format(salesTax)); 
		System.out.println(" making the total owed $" + df.format(totalPrice));
	}
}