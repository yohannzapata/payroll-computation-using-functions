import java.util.*;

public class Main
{
    public static Scanner sc = new Scanner(System.in);

    public static String last_name;
    public static String first_name;
    public static String middle_name;
    public static String department;
    public static String position;
    public static int rate_per_hour;
    public static int num_of_hours_worked;

    public static void main(String[] args)
    {
        employee_info();
    }

    public static void employee_info() {
        System.out.println("Enter Employee Information:");
        System.out.print("Last Name               : ");
        last_name = sc.nextLine();

        System.out.print("First Name              : ");
        first_name = sc.nextLine();

        System.out.print("Middle Name             : ");
        middle_name = sc.nextLine();

        System.out.print("Department              : ");
        department = sc.nextLine();

        System.out.print("Position                : ");
        position = sc.nextLine();

        System.out.print("Rate Per Hour           : ");
        rate_per_hour = sc.nextInt();

        System.out.print("Number of Hours Worked  : ");
        num_of_hours_worked = sc.nextInt();
    }

    public static void summary_pay_slip() {
        /* 
            The program should display a summary or pay slip of an employee showing:
                a. Employee Information
                b. Details of the Salary Computation
                c. Gross Pay
                d. Net Pay
        */

    }
}