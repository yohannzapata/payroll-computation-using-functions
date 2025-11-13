/*
    COPROG1 C1A FINAL PROJECT
    PAYROLL COMPUTATION USING FUNCTIONS

    Group Members:
        Goza, Johann Laurenz J.
        Illana, Vince Justin A.
        Zapata, Yohann Joachim M.
*/

import java.util.*;

public class finalCode_C1A_GRP3 {
    static Scanner sc = new Scanner(System.in);

    static String lastName, firstName, middleName, department, position;
    static double ratePerHour;
    static int hoursWorked;

    // TODO: add variable for number of dependents?
    // TODO: add variable for overtime hours?????

    public static void main(String[] args) {
        do {
            System.out.println("=============================================");
            System.out.println("        PAYROLL COMPUTATION SYSTEM           ");
            System.out.println("=============================================");
            System.out.println();
            
            inputEmployeeInfo();
            System.out.println();
            printPayslip();

            System.out.print("\n>> Do you want to compute again? (Y/N): ");
        } while (sc.next().equalsIgnoreCase("Y"));
        
        System.out.println();
        System.out.println("=============================================");
        System.out.println("   Thank you for using the Payroll System!   ");
        System.out.println("=============================================");
    }

    
    public static void inputEmployeeInfo() {
        System.out.println("-------- Enter Employee Information --------");
        System.out.print(">> Last Name               : ");
        lastName = sc.nextLine();
        System.out.print(">> First Name              : ");
        firstName = sc.nextLine();
        System.out.print(">> Middle Name             : ");
        middleName = sc.nextLine();
        System.out.print(">> Department              : ");
        department = sc.nextLine();
        System.out.print(">> Position                : ");
        position = sc.nextLine();
        System.out.print(">> Rate per Hour           : ");
        ratePerHour = sc.nextDouble();
        System.out.print(">> Hours Worked            : ");
        hoursWorked = sc.nextInt();

        // TODO: ask user for number of dependents
        // TODO: weekly hours to monthly conversion??
    }

    public static double computeGP() {
        // TODO: overtime computation
        // TODO: 4 weeks per month in computation
        return ratePerHour * hoursWorked;
    }

    public static double computeDed() {
        // TODO: include dependent deduction
        double totalDeduction = computeSSS(computeGP()) + computePagIBIG(computeGP()) + computePhilHealth() + computeTax(computeGP());
        // TODO: add deduction that lines up with the project requirements
        return totalDeduction;
    }

    public static double computeNP() {
        // TODO: need manager allowance
        // TODO: need deductions and overtime properly setup
        return computeGP() - computeDed();
    }

    public static double computeSSS(double gp) {
        if(gp <= 5000) return 105;
        else if(gp <= 5000) return gp * 0.05f;
        else if(gp <= 15000) return gp * 0.08 + 75;
        else return gp * 0.12 + 110;
    }

    public static double computePagIBIG(double gp) {
        if (gp < 5000) return 100;
        else return gp * 0.03f;
    }

    public static double computePhilHealth() {
        // TODO: double check logic if it fits project requirements 
        if(hoursWorked >= 10) return 120;
        else return 0;
    }

    public static double computeTax(double gp) {
        if (gp <= 10000) return gp * 0.03;
        else if (gp <= 25000) return gp * 0.08;
        else if (gp <= 40000) return gp * 0.11;
        else return gp * 0.135;
    }

    public static void printPayslip() {
        System.out.println("===============================================");
        System.out.println("             EMPLOYEE PAY SLIP                 ");
        System.out.println("===============================================");
        System.out.printf("Name             : %s, %s %s%n", lastName, firstName, middleName);
        System.out.printf("Department       : %s%n", department);
        System.out.printf("Position         : %s%n", position);
        System.out.println("----------------------------------------------");
        System.out.printf("Gross Pay        : %.2f%n", computeGP());
        System.out.printf("SSS Contribution : %.2f%n", computeSSS(computeGP()));
        System.out.printf("Pag-IBIG         : %.2f%n", computePagIBIG(computeGP()));
        System.out.printf("PhilHealth       : %.2f%n", computePhilHealth());
        System.out.printf("Tax              : %.2f%n", computeTax(computeGP()));
        System.out.println("----------------------------------------------");
        System.out.printf("Total Deduction  : %.2f%n", computeDed());
        System.out.printf("Net Pay          : %.2f%n", computeNP());
        System.out.println("==============================================");
        // TODO: display manager allowance??
        // TODO: display dependent deduction here
    }
}
