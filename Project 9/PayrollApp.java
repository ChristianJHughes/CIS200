/**
* (The PayrollApp handles the printing and calculating of 
* employee payroll data.) 
*
* @author (Christian Hughes)
* @version (Project Number 9)
*/

import java.util.*; 
import java.text.*;

public class PayrollApp {
	
	
		/**
		* (The main method handles all input and the majority of validation.) 
		*
		*/
		public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 
		
		ArrayList<Payroll> onARoll = new ArrayList<Payroll>();
		System.out.println("***WELCOME TO THE PAYROLL SYSTEM OF THE FUTURE***");
		String name = "";
		int IDNumber = 0; 
		double payRate = 0;
		double hours = 0;
		double grossPay = 0;
		String keepGoing = "";
		boolean badInput = true;
		
		do { 
			System.out.println();
			System.out.print("Please Enter the Employee's Name: "); 
			name = keyboard.nextLine();
		while (badInput == true) {
			try {
				if (name.equals("")) { 
					throw new Exception("\tINVALID *Please Enter a Valid Name*: ");
				}
				badInput = false;
			} 
			catch (Exception e) { 
				System.out.print(e.getMessage());
				name = keyboard.nextLine();
			}	
		}
		
		System.out.print("Please Enter the Employee's ID number: "); 
		badInput = true;
		while (badInput == true) {
			try {
				IDNumber = Integer.parseInt(keyboard.nextLine()); 
				badInput = false;
			} 
			catch (NumberFormatException e) { 
				System.out.print("\tINVALID *Please Enter a Valid ID Number (Integer)*: ");
			}
		}
		
		System.out.print("What is the Empolyee's Hourly Payrate?: "); 
		badInput = true; 
		while (badInput == true) { 
			try {
				payRate = Double.parseDouble(keyboard.nextLine());
				badInput = false;
			}
			catch (NumberFormatException e) { 
				System.out.print("\tINVALID *Please Enter a Valid Payrate (Numbers Only)*: ");
			}
		}
		
		System.out.print("How Many Hours Did The Employee Work?: "); 
		badInput = true;
		while (badInput == true) { 
			try {
				hours = Double.parseDouble(keyboard.nextLine());
				badInput = false;
			}
			catch (NumberFormatException e) { 
				System.out.print("\tINVALID *Please Enter a Valid Number of Hours*: ");
			}
		}
		
		Payroll temp = new Payroll(name, IDNumber);
		temp.setPayRate(payRate);
		temp.setHoursWorked(hours);
		
		onARoll.add(temp);
		
		System.out.print("\nWould You Like to Add Another PayRoll ((Y)es/(N)o)?: ");
		badInput = true;
		while (badInput == true) {
			try{
				keepGoing = keyboard.nextLine();
				if (keepGoing.charAt(0) != 'y' && keepGoing.charAt(0) != 'Y' && keepGoing.charAt(0) != 'n' & keepGoing.charAt(0) != 'N') { 
					throw new Exception("\tINVALID *Please Enter 'Y' for Yes, or 'N' for No*: ");
				} 
				badInput = false;
			}
			catch (Exception e) { 
				System.out.print(e.getMessage());
			}
		}
			
		} while (keepGoing.charAt(0) != 'n' && keepGoing.charAt(0) != 'N');
		
		System.out.print(printList(onARoll));
		System.out.println("******************************************************");
		int empNum = deleteEmp(onARoll);
		System.out.println("\nYou Have Successfully Removed Employee Number " + empNum + " From the Payroll.");
		System.out.println("Here Are the remaining Employee(s): ");
		System.out.print(printList(onARoll));
		System.out.println("******************************************************");
		lastEmp(onARoll);
	}
	
	
	/**
	* (This method creates a string with the data for all of the employees.) 
	*
	* @param (temp is an ArrayList<Payroll> that is used to store the employee data)
	* @return (total is a String containing all of the employees) 
	*/
	public static String printList(ArrayList<Payroll> temp) { 
		Iterator<Payroll> iter = temp.iterator();
		String total = "";
		while (iter.hasNext()) { 
			Payroll current = iter.next();
			total += current.toString();
		}
		return total;
	}
	
	/**
	* (This method prompts the user for the ID Number of an employee that they wish
	* to remove.) 
	*
	* @param (temp is an ArrayList<Payroll> that is used to store the employee data)
	* @return (lookNumber is an integer that represents the ID Number of the employee that was deleted.) 
	*/
	public static int deleteEmp(ArrayList<Payroll> temp) { 
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please Enter the ID Number of an Employee That You Wish to Remove: ");
		boolean badInput = true;
		int lookNumber = 0;
		while (badInput == true) {
			try {
				lookNumber = Integer.parseInt(keyboard.nextLine());
				badInput = false;
			} 
			catch (NumberFormatException e) { 
				System.out.print("\tINVALID NUMBER *Please Enter a Valid ID Number (Integer)*: ");
			}
		}
		
		boolean remove = false;
		while (remove == false) {
			int counter = 0;
			badInput = true;
			Iterator<Payroll> it = temp.iterator();
			while (it.hasNext()) { 
				Payroll current = it.next();
				int booty = current.getIdNumber();
				if (lookNumber == booty) { 
					temp.remove(counter);
					remove = true;
					break;
				}
				counter ++;
			}	
			if (remove == false) {
				System.out.print("\tID NUMBER NOT FOUND *Please Enter a Valid ID Number*: ");
				while (badInput == true) {
					try {
						lookNumber = Integer.parseInt(keyboard.nextLine());
						badInput = false;
					} 
					catch (NumberFormatException e) { 
						System.out.print("\tINVALID NUMBER *Please Enter a Valid ID Number (Integer)*: ");
					}
				}
			}
		}	
		return lookNumber;
	}
	
	/**
	* (This method deals with taking in the data for a final employee at
	* the end of the program. It is optional for the user to choose to do this.) 
	*
	* @param (temp is an ArrayList<Payroll> that is used to store the employee data)
	*/
	public static void lastEmp(ArrayList<Payroll> onARoll) { 
		boolean badInput;
		Scanner keyboard = new Scanner(System.in);
		String keepGoing = "";
		System.out.print("\nWould You Like to Add Another Employee ((Y)es/(N)o)?: ");
			badInput = true;
			while (badInput == true) {
				try{
					keepGoing = keyboard.nextLine();
					if (keepGoing.charAt(0) != 'y' && keepGoing.charAt(0) != 'Y' && keepGoing.charAt(0) != 'n' & keepGoing.charAt(0) != 'N') { 
						throw new Exception("\tINVALID *Please Enter 'Y' for Yes, or 'N' for No*: ");
					} 
					badInput = false;
				}
				catch (Exception e) { 
					System.out.print(e.getMessage());
				}
			}
			if (keepGoing.charAt(0) != 'n' && keepGoing.charAt(0) != 'N') { 
				
			int IDNumber = 0; 
				double payRate = 0;
				double hours = 0;
				double grossPay = 0;
				keepGoing = "";
				badInput = true;
				String name = "";
				
				
					System.out.println();
					System.out.print("Please Enter the Employee's Name: "); 
					name = keyboard.nextLine();
				while (badInput == true) {
					try {
						if (name.equals("")) { 
							throw new Exception("\tINVALID *Please Enter a Valid Name*: ");
						}
						badInput = false;
					} 
					catch (Exception e) { 
						System.out.print(e.getMessage());
						name = keyboard.nextLine();
					}	
				}
				
				System.out.print("Please Enter the Employee's ID number: "); 
				badInput = true;
				while (badInput == true) {
					try {
						IDNumber = Integer.parseInt(keyboard.nextLine()); 
						badInput = false;
					} 
					catch (NumberFormatException e) { 
						System.out.print("\tINVALID *Please Enter a Valid ID Number (Integer)*: ");
					}
				}
				
				System.out.print("What is the Empolyee's Hourly Payrate?: "); 
				badInput = true; 
				while (badInput == true) { 
					try {
						payRate = Double.parseDouble(keyboard.nextLine());
						badInput = false;
					}
					catch (NumberFormatException e) { 
						System.out.print("\tINVALID *Please Enter a Valid Payrate (Numbers Only)*: ");
					}
				}
				
				System.out.print("How Many Hours Did The Employee Work?: "); 
				badInput = true;
				while (badInput == true) { 
					try {
						hours = Double.parseDouble(keyboard.nextLine());
						badInput = false;
					}
					catch (NumberFormatException e) { 
						System.out.print("\tINVALID *Please Enter a Valid Number of Hours*: ");
					}
				}
				
				Payroll temp = new Payroll(name, IDNumber);
				temp.setPayRate(payRate);
				temp.setHoursWorked(hours);
				
				onARoll.add(temp);
				}
				System.out.println("\n**********FINAL PAYROLL**********");
				for (int i = 0; i < onARoll.size(); i++) {
					System.out.print(onARoll.get(i).toString());
				}
				System.out.println("******************************************************");
				System.out.println();
				System.out.println("Thank You. Have a Nice Day.");
			
	}		
}