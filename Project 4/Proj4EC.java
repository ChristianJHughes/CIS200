/********************************************
*<Proj4EC.java> 
*<Christian Hughes/Section (02L)/2:30-3:20> 
*
*<This Program allows a professor to enter exam
grades from a text file for his students, and 
then outputs final grades and statistics based 
on that input.> 
*********************************************/

import java.util.*; 
import java.text.*; 
import java.io.*; 

public class Proj4EC {
	public static void main(String[] args) throws IOException {
		
	PrintWriter pw = new PrintWriter(new FileWriter("Proj4EC.txt"));
	
	Scanner keyboard = new Scanner(new File("StudentInfoECInput.txt"));
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
		
		String[][] gotSomeStudentInformation = new String[100][6];
		int q = 0;
		while (keyboard.hasNext()) { 
			StringTokenizer st = new StringTokenizer(keyboard.nextLine(), ",");
			int qq= 0;
			
			while (st.hasMoreTokens()) { 
				gotSomeStudentInformation[q][qq] = st.nextToken(); 
				qq++; 	
			}
			q++;
		}
		
		//Get Names from gotSomeStudentInformation into studentNamesFormatted. 
		for (int i = 0; i < q; i++) { 
			for (int j = 0; j < 2; j++) { 
				studentNamesFormatted[i][j] = gotSomeStudentInformation[i][j].toUpperCase();
			}	
		}
		
		//Get scores from gotSomeStudentInformation into studentScores.
		for (int i = 0; i < q; i++) { 
			for (int j = 0; j < 4; j++) { 
				studentScores[i][j] = Integer.parseInt(gotSomeStudentInformation[i][j+2]);
			}	
		}
		
		
		 
		
		
		
		
		
		
		
		
			
		
	
	
	
	double[] examPercentage = new double[(q)];
	pw.println("***Class Results***");
	
	for (int i = 0; i < q; i++) { 
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
		
		pw.println(studentNamesFormatted[i][1] + "," + studentNamesFormatted[i][0] + "\tExam Percentage: " + df.format(examPercentage[i]) + "\tFinal Grade: " + letterGrade);
				
	}
		double totalPercentageParty = 0;
		for (int i = 0; i < q; i++) {
			totalPercentageParty += examPercentage[i];
		}
		
		double totalGrades = a + b + c + d + f;
		pw.println(); 
		pw.println("Total number of Scores: " + (q));
		pw.println("\t\t\t\tTotal number of A's: " +  a);
		pw.println("\t\t\t\tTotal number of B's: " +  b);
		pw.println("\t\t\t\tTotal number of C's: " +  c);
		pw.println("\t\t\t\tTotal number of D's: " +  d);
		pw.println("\t\t\t\tTotal number of F's: " +  f);
		pw.println(); 
		pw.println("Individual grade percentages..."); 
		pw.println("\t\t\t\tA: " + df.format(a / (totalGrades) * 100) + "%"); 
		pw.println("\t\t\t\tB: " + df.format(b / (totalGrades) * 100) + "%");
		pw.println("\t\t\t\tC: " + df.format(c / (totalGrades) * 100) + "%");
		pw.println("\t\t\t\tD: " + df.format(d / (totalGrades) * 100) + "%");
		pw.println("\t\t\t\tF: " + df.format(f / (totalGrades) * 100) + "%");
		pw.println(); 
		pw.println("Average score = " + df2.format(totalPercentageParty/(q)) + "%");
		pw.close();
	
	}
}