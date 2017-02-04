/********************************************
*<Proj4.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program allows a professor to enter exam
grades for his students, and then outputs final
grades and statistics based on that input.> 
*********************************************/

import java.util.*; 
import java.text.*; 
import java.io.*; 

public class Proj4 {
	public static void main(String[] args) {
	
	Scanner keyboard = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#0.0");
	DecimalFormat df2 = new DecimalFormat("#0.00");
	
		String[] studentNames = new String[100];
		String[][] studentNamesFormatted = new String[100][2];
		int[][] studentScores = new int[100][4];
		
		
		char keepGoing = 'y';
		
		final int universalMinimum = 0; 
		final int regularExamMaximum = 50; 
		final int finalExamMaximum = 100;
		int exam = 0;
		boolean badInput;
		boolean badInputFinalExam;
		int studentCounter = 1;
		double totalTestScores;
		
		int a = 0; 
		int b = 0; 
		int c = 0; 
		int d = 0; 
		int f = 0;
		
		do { 
				badInput = true;
				System.out.print("Please enter the name of student " + studentCounter + ": "); 
				studentNames[studentCounter-1] = keyboard.nextLine();
				
				for (int j = 1; j <= 3; j++) {
					System.out.print("Please enter score for exam " + j + ": "); 
					exam = Integer.parseInt(keyboard.nextLine()); 
					badInput = true;
						
						while  (badInput == true) {
							if (exam >= universalMinimum && exam <= regularExamMaximum) { 
								studentScores[studentCounter-1][j-1] = exam;
								badInput = false;
								
								
							}
							else {
								System.out.println("\tInvalid enter 0-50 only...");
								System.out.print("\tPlease re-enter score: ");
								exam = Integer.parseInt(keyboard.nextLine());
							}	
						}
				}
				System.out.print("Please enter score for Final Exam: "); 
				exam = Integer.parseInt(keyboard.nextLine());
				badInputFinalExam = true;
					
					while (badInputFinalExam == true) { 
						if (exam >= universalMinimum && exam <= finalExamMaximum) {
							studentScores[studentCounter-1][3] = exam;
							badInputFinalExam = false;
							
						}
						else { 
							System.out.println("\tInvalid enter 0-100 only...");
							System.out.print("\tPlease re-enter score: "); 
							exam = Integer.parseInt(keyboard.nextLine());
							
						}
					}
					studentCounter++; 
					System.out.print("Do you wish to enter another? (y/n): "); 
					String keepGoingString = keyboard.nextLine();
					keepGoing = keepGoingString.charAt(0);
					System.out.println();
					
		} while (keepGoing == 'y');
	 
	//Get All of the names seperated, and toUpperCase 
	
	for (int i = 0; i < studentCounter-1; i++) {
		StringTokenizer st = new StringTokenizer(studentNames[i], " ");
		for (int j = 0; j < 2; j++) { 
			
			String name = st.nextToken();
			studentNamesFormatted[i][j] = name.toUpperCase();
			
		}	
	}
	
	
	double[] examPercentage = new double[(studentCounter-1)];
	System.out.println(); 
	System.out.println("***Class Results***");
	
	for (int i = 0; i < studentCounter-1; i++) { 
		totalTestScores= 0.0;
		
		
			totalTestScores = studentScores[i][0] + studentScores[i][1] + studentScores[i][2] + studentScores[i][3];			
		
		examPercentage[i] = (totalTestScores/250)*100;
		
		char letterGrade;
		
		if (examPercentage[i] >= 90) { 
			letterGrade = 'A'; 
			a++;
		}
		else if (examPercentage[i] >= 80) {
			letterGrade = 'B'; b++;
		}
		else if (examPercentage[i] >= 70) {
			letterGrade = 'C'; c++;
		}
		else if (examPercentage[i] >= 60) {
			letterGrade = 'D'; d++;
		}
		else {
			letterGrade = 'F'; f++;
		}
		
		System.out.println(studentNamesFormatted[i][1] + "," + studentNamesFormatted[i][0] + "\tExam Percentage: " + df.format(examPercentage[i]) + "\tFinal Grade: " + letterGrade);
				
	}
		double totalPercentageParty = 0;
		for (int i = 0; i < studentCounter - 1; i++) {
			totalPercentageParty += examPercentage[i];
		}
		
		double totalGrades = a + b + c + d + f;
		System.out.println(); 
		System.out.println("Total number of Scores: " + (studentCounter-1));
		System.out.println("\t\t\t\tTotal number of A's: " +  a);
		System.out.println("\t\t\t\tTotal number of B's: " +  b);
		System.out.println("\t\t\t\tTotal number of C's: " +  c);
		System.out.println("\t\t\t\tTotal number of D's: " +  d);
		System.out.println("\t\t\t\tTotal number of F's: " +  f);
		System.out.println(); 
		System.out.println("Individual grade percentages..."); 
		System.out.println("\t\t\t\tA: " + df.format(a / (totalGrades) * 100) + "%"); 
		System.out.println("\t\t\t\tB: " + df.format(b / (totalGrades) * 100) + "%");
		System.out.println("\t\t\t\tC: " + df.format(c / (totalGrades) * 100) + "%");
		System.out.println("\t\t\t\tD: " + df.format(d / (totalGrades) * 100) + "%");
		System.out.println("\t\t\t\tF: " + df.format(f / (totalGrades) * 100) + "%");
		System.out.println(); 
		System.out.println("Average score = " + df2.format(totalPercentageParty/(studentCounter-1)) + "%");
		
	
	}
}