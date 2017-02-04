/********************************************
*<Proj3.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program gets user defined cordinates, 
*and writes an equation/graphs the cordinates.> 
*********************************************/

import java.util.*; 
import java.text.*;

class Proj3 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		DecimalFormat df = new DecimalFormat("#0.00"); 
		
		char shouldIStay = 'y';
		
		while (shouldIStay == 'y') {
		
			System.out.print("Enter x1: "); 
			int x1 = Integer.parseInt(keyboard.nextLine()); 
			System.out.print("Enter y1: "); 
			int y1 = Integer.parseInt(keyboard.nextLine()); 
			System.out.print("Enter x2: "); 
			int x2 = Integer.parseInt(keyboard.nextLine()); 
			System.out.print("Enter y2: "); 
			int y2 = Integer.parseInt(keyboard.nextLine()); 
		
				if (x1 == x2) { 
					System.out.println("Line between points must have a slope"); 
					System.out.println("i.e. x1 and x2 must differ");
					System.out.println(); 
					System.out.print("Run program again? (y/n) "); 
					shouldIStay = keyboard.nextLine().charAt(0);
					System.out.println();
						if (shouldIStay == 'n') { 
							System.exit(0);
						}	
				}
				else if (x1 > 9 || x2 > 9 || y1 > 9 || y2 > 9 || x2 < 0 || x1 < 0 || y1 < 0 || y2 < 0) {
					System.out.println("All points must be between (0,0) and (9,9).");
					System.out.println(); 
					System.out.print("Run program again? (y/n) "); 
					shouldIStay = keyboard.nextLine().charAt(0);
					System.out.println();
						if (shouldIStay == 'n') {
							System.exit(0);
						}
				}
				else {
					double slope = (double)(y2 - y1) / (x2 - x1); 
					double yIntercept = y1 - (slope * x1); 
		
					System.out.println();
					System.out.print("y = " + df.format(slope) + "x + " + df.format(yIntercept));
					System.out.println(); 
					
					int columns = 0;
					for (int row = 9; row >= 0; row--) { 
						if (row != 0) {
							System.out.print(row + " |"); 
						} 
						else { 
							System.out.print(row + " ");
						}
							
						for (columns = 0; columns <= 9; columns++) {
							if ((row == y1 && columns  == x1) || (row == y2 && columns == x2)) {
								System.out.print("*");
							}
							else if (row == 0) { 
								System.out.print("--");
							}
							else { 
								System.out.print("  ");
							}
						}	
						System.out.println();
						columns++;
						}
						System.out.println("   0 1 2 3 4 5 6 7 8 9");
						System.out.println(); 
						
						System.out.print("Run program again? (y/n) "); 
							shouldIStay = keyboard.nextLine().charAt(0);
								System.out.println();
									if (shouldIStay == 'n') {
										System.exit(0);
									}
					}	
										 
		}
		
	}
}