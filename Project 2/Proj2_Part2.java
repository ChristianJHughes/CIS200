/********************************************
*<Proj2_Part2.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program determines a users education 
*level, and outputs thier estimated salery.> 
*********************************************/

import java.util.*; 
import java.text.*;

class Proj2_Part2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		DecimalFormat df = new DecimalFormat(",###.00");
		
		final double nextDayAir = 25; 
		final double businessTwoDay = 19.25;			final double priorityUPS = 9.50; 
		final double usPostalGround = 5;
		
		System.out.print("\t1 - Next Day Air (Cost is $25.00)\n\t2 - Business Two Day (Cost $19.25)\n\t3 - Priority UPS Ground (Cost $9.50)\n\t4 - US Postal Ground (Cost $5.00)\n\n");
		System.out.print("Enter 1, 2, 3, 4 for delivery method: "); 
		int x = Integer.parseInt(keyboard.nextLine());
		if ((x == 1) || (x == 2) || (x == 3) || (x == 4)) {
		}
		else {
			System.out.println("Invalid Menu Choice. Please re-run the program and enter in a valid choice.");
		}
		
		System.out.print("\nPlease enter the number of packages you wish to ship using this method: "); 
			int numberOfPackages = Integer.parseInt(keyboard.nextLine());
			if (!((numberOfPackages) > 0)) { 
				System.out.println("Please re-run the program and enter a positive whole number.");
			}
			
		//Get the name of thier shipping preference based on user input. 
				
		if (x == 1) { 
			 	System.out.print("\nTotal cost to ship " + numberOfPackages + " package(s) " + "Next Day Air" + " is $" + df.format(nextDayAir * numberOfPackages)); 
		}
		else if (x == 2) {
				 System.out.print("\nTotal cost to ship " + numberOfPackages + " package(s) " + "Business Two Day" + " is $" + df.format(businessTwoDay * numberOfPackages));		}
		else if (x == 3) {
				System.out.print("\nTotal cost to ship " + numberOfPackages + " package(s) " + "Priority UPS Ground" + " is $" + df.format(priorityUPS * numberOfPackages));
		}
		else if (x == 4) {
				 System.out.print("\nTotal cost to ship " + numberOfPackages + " package(s) " + "US Postal Ground" + " is $" + df.format(usPostalGround * numberOfPackages));
		}
		
	}
}