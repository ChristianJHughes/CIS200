/**
* <Proj5.java>
* <Christian Hughes / Section (02L) 2:30-3:20>
*
* <This program reads WID's and test scores from a
*text file, and prints out different statistics/the
*class as a whole.>
*/

import java.util.*; 
import java.text.*; 
import java.io.*;

public class Proj5 {
	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in); 
		boolean invalid = true; 
		String fileName = "";
		int invalidCounter = 0; 
		
		while (invalid == true) {
		if (invalidCounter == 0) System.out.print("Please enter the name of the file you wish to analyze: "); 
		else System.out.print("That file does not exist. Please Enter a valid name: ");
		
		fileName = keyboard.nextLine();
		File userInput = new File(fileName);
			if (userInput.exists()) { 
				invalid = false;
			}
		invalidCounter++;	
		}
			
		String textFileContents = fileReader(fileName); 
		String[][] IDsAndQuizs = new String[50][2]; 
		String textFileSingleLine = "";
		int i = 0;
		int j = 0;
		
		StringTokenizer breakUpNewLine = new StringTokenizer(textFileContents, "\n"); 
		
		
		while (breakUpNewLine.hasMoreTokens()) { 
			textFileSingleLine = breakUpNewLine.nextToken(); 
			i = 0;
			StringTokenizer breakUpCommas = new StringTokenizer(textFileSingleLine, ",");
			while (breakUpCommas.hasMoreTokens()) { 
				IDsAndQuizs[j][i] = breakUpCommas.nextToken();
				i++;
			}
			j++;
		}
		
		double[] gradePercentage = new double[j]; 
		for (int y = 0; y < j; y++) { 
			gradePercentage[y] = (((quizGrader(IDsAndQuizs[y][1])) * 2.0) / 30.0) * 100.0;
		}
		
		printOutput(j, bubbleSort(gradePercentage, IDsAndQuizs));
		printOutputFile(j, bubbleSort(gradePercentage, IDsAndQuizs));
		
	} //End Main method.
	
	
	/**
	* (This sorts the scores from highest to lowest) 
	*
	* @param arr (An array full of the grade percentages.)
	* @param IDsAndQuizs (The contents of the text file.)
	* @return IDsAndQuizs (Outputs an array of sorted score data.)
	*/
	public static String[][] bubbleSort(double[] arr, String[][] IDsAndQuizs) {
		//series of passes (loop)
		for (int i = 0; i < arr.length-1; i++) { 
			//loop through adjacent element 
			for (int j = 0; j < arr.length-i-1; j++) {
			//compare adjacent elements 
				if (arr[j] < arr[j+1]) { 
				//swap 
				double temp = arr[j]; 
				arr[j] = arr[j+1]; 
				arr[j+1] = temp;
				
				String temp2 = IDsAndQuizs[j][0];
				IDsAndQuizs[j][0] = IDsAndQuizs[j+1][0];
				IDsAndQuizs[j+1][0] = temp2;
				
				String temp3 = IDsAndQuizs[j][1];
				IDsAndQuizs[j][1] = IDsAndQuizs[j+1][1];
				IDsAndQuizs[j+1][1] = temp3;
				}
			}
		}
		return IDsAndQuizs;
	}
	
	/**
	* (This method reads in information from the text file.) 
	*
	* @param fileName (The name of the text file.)
	* @return fileContents (The contents of the text file.)
	*/
	public static String fileReader(String fileName) throws IOException { 
		Scanner textFileContent = new Scanner(new File(fileName)); 
			String fileContents = "";
			while (textFileContent.hasNext()) {
				fileContents += textFileContent.nextLine() + "\n";
			}
			textFileContent.close();
			return fileContents;
	} //End fileReaderMethod. 
	
	/**
	* (This method returns the number correct on a single quiz.) 
	*
	* @param quizNumber (Which quiz is being graded)
	* @return totalRight (Amount of questions correct on the quiz.)
	*/
	public static int quizGrader(String quizNumber) { 
		int totalRight = 0;
		char[] quizKey = {'1', '1', '2', '2', '1', '1', '3', '2', '4', '1', '3', '5', '4', '1', '2'}; 
		for (int i = 0; i < 15; i++) { 
			if (quizKey[i] == (quizNumber.charAt(i))) {
				totalRight++;
			}
		}
		return totalRight;
	}
	
	/**
	* (This method returns the total average for the quiz) 
	*
	* @param totalPointsCorrect (The cumulative points earned.)
	* @param totalStudents (Number of students that took the quiz.)
	* @return average (Average precentage for the class.)
	*/
	public static double totalQuizAverage(int totalPointsCorrect, int totalStudents) { 
		double average = ((totalPointsCorrect * 2.0) / (totalStudents * 30.0)) * 100.0; 
		return average; 	
	}
	
	/**
	* (This method displays the required output) 
	*
	* @param j (The number of students.)
	* @param IDsandQuizs (An array of the students and thier information.)
	*/
	public static void printOutput(int j, String[][] IDsAndQuizs) { 
		DecimalFormat df = new DecimalFormat("#0.0");
		
		String letterGrade2 = "";
		int totalPointsCorrect = 0; 
		double gradePercentage = 0;
		String letterGrade = "";
		int highScore = quizGrader(IDsAndQuizs[0][1]);
		int lowScore = quizGrader(IDsAndQuizs[0][1]);
		System.out.println();
		System.out.println("Student ID\t\t# Correct\t\t% Correct\t\tGrade"); 
		for (int y = 0; y < j; y++) { 
			gradePercentage = (((quizGrader(IDsAndQuizs[y][1])) * 2.0) / 30.0) * 100.0;
			
			if (quizGrader(IDsAndQuizs[y][1]) > highScore) highScore = quizGrader(IDsAndQuizs[y][1]); 
			
			if (quizGrader(IDsAndQuizs[y][1]) < lowScore) lowScore = quizGrader(IDsAndQuizs[y][1]);
			
			if (gradePercentage >= 90) letterGrade = "A";
			else if (gradePercentage >=80) letterGrade = "B"; 
			else if (gradePercentage >= 70) letterGrade = "C"; 
			else if (gradePercentage >= 60) letterGrade = "D"; 
			else letterGrade = "F";	
			
			if ((totalQuizAverage(totalPointsCorrect,j)) >= 90) letterGrade2 = "A";
			else if ((totalQuizAverage(totalPointsCorrect,j)) >=80) letterGrade2 = "B"; 
			else if ((totalQuizAverage(totalPointsCorrect,j)) >= 70) letterGrade2 = "C"; 
			else if ((totalQuizAverage(totalPointsCorrect,j)) >= 60) letterGrade2 = "D"; 
			else letterGrade2 = "F";	
			
			System.out.println(IDsAndQuizs[y][0] + "\t\t\t" + quizGrader(IDsAndQuizs[y][1]) + "\t\t\t\t" + df.format(gradePercentage) + "%" + "\t\t\t" + letterGrade);
			
			totalPointsCorrect += quizGrader(IDsAndQuizs[y][1]);
		}
		
		
		
		System.out.println(); 
		System.out.println("Average: " + df.format(totalQuizAverage(totalPointsCorrect,j)) + "% (" + letterGrade2 + ")");
		System.out.println("High Score: " + (highScore * 2)); 
		System.out.println("Low Score: " + (lowScore * 2)); 
	}
	
	/**
	* (This method prints the results to a seperate file) 
	*
	* @param j (Students.)
	* @param IDsAndQuizs (An array of the students and thier information.)
	*/
	public static void printOutputFile(int j, String[][] IDsAndQuizs) throws IOException { 
		DecimalFormat df = new DecimalFormat("#0.0");
		PrintWriter pw = new PrintWriter(new FileWriter("Results.txt"));
		
		String letterGrade2 = "";
		int totalPointsCorrect = 0; 
		double gradePercentage = 0;
		String letterGrade = "";
		int highScore = quizGrader(IDsAndQuizs[0][1]);
		int lowScore = quizGrader(IDsAndQuizs[0][1]);
		pw.println();
		pw.println("Student ID\t\t# Correct\t\t% Correct\t\tGrade"); 
		for (int y = 0; y < j; y++) { 
			gradePercentage = (((quizGrader(IDsAndQuizs[y][1])) * 2.0) / 30.0) * 100.0;
			
			if (quizGrader(IDsAndQuizs[y][1]) > highScore) highScore = quizGrader(IDsAndQuizs[y][1]); 
			
			if (quizGrader(IDsAndQuizs[y][1]) < lowScore) lowScore = quizGrader(IDsAndQuizs[y][1]);
			
			if (gradePercentage >= 90) letterGrade = "A";
			else if (gradePercentage >=80) letterGrade = "B"; 
			else if (gradePercentage >= 70) letterGrade = "C"; 
			else if (gradePercentage >= 60) letterGrade = "D"; 
			else letterGrade = "F";	
			
			if ((totalQuizAverage(totalPointsCorrect,j)) >= 90) letterGrade2 = "A";
			else if ((totalQuizAverage(totalPointsCorrect,j)) >=80) letterGrade2 = "B"; 
			else if ((totalQuizAverage(totalPointsCorrect,j)) >= 70) letterGrade2 = "C"; 
			else if ((totalQuizAverage(totalPointsCorrect,j)) >= 60) letterGrade2 = "D"; 
			else letterGrade2 = "F";	
			
			pw.println(IDsAndQuizs[y][0] + "\t\t\t" + quizGrader(IDsAndQuizs[y][1]) + "\t\t\t" + df.format(gradePercentage) + "%" + "\t\t\t" + letterGrade);
			
			totalPointsCorrect += quizGrader(IDsAndQuizs[y][1]);
		}
		
		
		
		pw.println(); 
		pw.println("Average: " + df.format(totalQuizAverage(totalPointsCorrect,j)) + "% (" + letterGrade2 + ")");
		pw.println("High Score: " + (highScore * 2)); 
		pw.println("Low Score: " + (lowScore * 2)); 
		
		pw.close();
	}

	 
} //End Class. 