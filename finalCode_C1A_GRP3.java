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

    public static void main(String[] args) {
        employeeInfo();
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
        /* 
            The program should display a summary or pay slip of an employee showing:
                a. Employee Information
                b. Details of the Salary Computation
                c. Gross Pay
                d. Net Pay
        */
    }
}