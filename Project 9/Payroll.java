/**
* (The Payroll class creates objects containing Employee
* names, numbers, payrate, and number of hours worked) 
*
* @author (Christian Hughes)
* @version (Project Number 9)
*/

import java.text.*;

public class Payroll
{
	DecimalFormat df = new DecimalFormat("$,##0.00");
	
   private String name;          // Employee name
   private int idNumber;         // ID number
   private double payRate;       // Hourly pay rate
   private double hoursWorked;   // Number of hours worked

   /**
      The constructor initializes an object with the
      employee's name and ID number.
      @param n The employee's name.
      @param i The employee's ID number.
   */

   public Payroll(String n, int i)
   {
      name = n;
      idNumber = i;
   }

   /**
      The setName sets the employee's name.
      @param n The employee's name.
   */

   public void setName(String n)
   {
      name = n;
   }

   /**
      The setIdNumber sets the employee's ID number.
      @param i The employee's ID number.
   */
   
   public void setIdNumber(int i)
   {
      idNumber = i;
   }

   /**
      The setPayRate sets the employee's pay rate.
      @param p The employee's pay rate.
   */
   
   public void setPayRate(double p)
   {
      payRate = p;
   }

   /**
      The setHoursWorked sets the number of hours worked.
      @param h The number of hours worked.
   */

   public void setHoursWorked(double h)
   {
      hoursWorked = h;
   }

   /**
      The getName returns the employee's name.
      @return The employee's name.
   */

   public String getName()
   {
      return name;
   }

   /**
      The getIdNumber returns the employee's ID number.
      @return The employee's ID number.
   */
   
   public int getIdNumber()
   {
      return idNumber;
   }

   /**
      The getPayRate returns the employee's pay rate.
      @return The employee's pay rate.
   */

   public double getPayRate()
   {
      return payRate;
   }

   /**
      The getHoursWorked returns the hours worked by the
      employee.
      @return The hours worked.
   */


   public double getHoursWorked()
   {
      return hoursWorked;
   }

   /**
      The getGrossPay returns the employee's gross pay.
      @return The employee's gross pay.
   */

   public double getGrossPay()
   {
      return hoursWorked * payRate;
   }
	
	/**
	* (This method returns a string containing formatted employee payroll data.) 
	*
	* @return (a formatted string containing payroll data) 
	*/
	public String toString() { 
		return ("\n" + "Employee Name: " + name + "\n" + "ID Number: " + idNumber + "\n" + "Total Pay for the Week: " + df.format(getGrossPay()) + "\n");
	}
}
