/********************************************
*<Proj2_Part1.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program determines a users education 
*level, and outputs thier estimated salery.> 
*********************************************/

/*********************************************************************************************
*CITATION: 
*<"Earnings and Unemployment Rates by Educational Attainment." U.S. Bureau of Labor Statistics. 
*U.S. Bureau of Labor Statistics, n.d. Web. 04 Feb. 2014.> 
*********************************************************************************************/

import java.util.*; 
import java.text.*;

class Proj2_Part1 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		DecimalFormat df = new DecimalFormat(",###");
		
		final int noDegree = 24492; 
		final int highSchool = 33904;
		final int bachelor = 55432;
		final int master = 67600; 
		final int doctoral = 84448; 
		
		String finalStatement = "Based on 2012 Bureau of Labor Statistics, with your education level...\nAverage salary is $";
		
		System.out.println("\t1 = No Degree");
		System.out.println("\t2 = High School Degree");
		System.out.println("\t3 = Bachelor Degree"); 
		System.out.println("\t4 = Master Degree"); 
		System.out.println("\t5 = Doctorate Degree\n");
		
		System.out.print("Enter the number that corresponds to your degree: ");
		int userInput = Integer.parseInt(keyboard.nextLine()); 
		
		switch (userInput) { 
			case 1: 
				System.out.println("\n" + finalStatement + df.format(noDegree)); 
				break;
			case 2: 
				System.out.println("\n" + finalStatement + df.format(highSchool)); 
				break;
			case 3: 
				System.out.println("\n" + finalStatement + df.format(bachelor)); 
				break; 
			case 4: 
				System.out.println("\n" + finalStatement + df.format(master)); 
				break;
			case 5: 
				System.out.println("\n" + finalStatement + df.format(master)); 
				break;
			default: 
				System.out.print("\nYou entered an invalid menu choice.\nPlease re-run the program and enter in a valid choice."); 
				break;
		}
		
	}
}