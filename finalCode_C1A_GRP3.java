/*  COPROG1 C1A Final Project: Payroll Computation Using Functions
    Group Members:
        Goza, Johann Laurenz J.
        Illana, Vince Justin A.
        Zapata, Yohann Joachim M.
*/

/*  The main class and filename are "finalCode_C1A_GRP3"
    and NOT "finalCode-C1A-GRP3", as Java does not allow
    hyphens in class names. */

import java.util.*;

public class finalCode_C1A_GRP3 {
    public static Scanner sc = new Scanner(System.in);
    public static String lastName;
    public static String firstName;
    public static String middleName;
    public static String department;
    public static String position;
    public static int ratePerHour;
    public static int hoursWorked;

    public static double grossPay;
    public static double totalDeduction;
    public static double netPay;

    public static void main(String[] args)
    {
        employeeInfo();
        summaryPaySlip();
    }

    public static void employeeInfo() {
        System.out.println("Enter Employee Information:");
        
        System.out.print("Last Name               : ");
        lastName = sc.nextLine();

        System.out.print("First Name              : ");
        firstName = sc.nextLine();

        System.out.print("Middle Name             : ");
        middleName = sc.nextLine();

        System.out.print("Department              : ");
        department = sc.nextLine();

        System.out.print("Position                : ");
        position = sc.nextLine();

        System.out.print("Rate Per Hour           : ");
        ratePerHour = sc.nextInt();

        System.out.print("Number of Hours Worked  : ");
        hoursWorked = sc.nextInt();
    }

    public static void summaryPaySlip() {
        System.out.println("Details of the Salary Computation: ");
        System.out.printf("Gross Pay: %.2f", computeGP());
        System.out.printf("%nTotal Deduction: %.2f", computeDed());
        System.out.printf("%nNet Pay: %.2f", computeNP());

    }

    // Gross Pay = Hourly Rate * Number of Hours Worked
    public static double computeGP()  {
        return ratePerHour * hoursWorked;
    }
    
    // Total Deductions = SSS + PhilHealth + Pag-IBIG
    public static double computeDed() {
        return SSSContribution() + pagIBIGContribution() + taxComputation();
    }

    // Net Pay = Gross Pay - Deductions
    public static double computeNP() {
        return computeGP() - computeDed();
    }

    public static double SSSContribution() {
        if(computeGP() <= 5000) 
            return 105;
         else if(computeGP() > 5000 && computeGP() <= 10000) 
            return computeGP() * 0.05f;
         else if(computeGP() > 10000 && computeGP() <= 15000) 
            return (computeGP() * 0.08f) + 75;
         else if(computeGP() > 15000) 
            return 110 * 0.12f;
        

        return 0;
    }   

    public static double pagIBIGContribution() {
        if(computeGP() < 5000) 
            return 100;
         else if(computeGP() > 5000) 
            return computeGP() * 0.03f;

        return 0;
    }

    public static double philHealthContribution() {
        if(hoursWorked >= 10)
            return 120;
        
        return 0;
    }

    public static double taxComputation() {
        if(computeGP() <= 10000) 
            return computeGP() * 0.03f;
         else if(computeGP() > 10000 && computeGP() <= 25000) 
            return computeGP() * 0.08f;
         else if(computeGP() > 25000 && computeGP() <= 40000) 
            return computeGP() * 0.11f;
         else if(computeGP() > 40000) 
            return computeGP() * 0.135f;
        
        return 0;
    }
}