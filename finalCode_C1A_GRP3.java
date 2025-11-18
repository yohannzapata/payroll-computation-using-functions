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
    // SCANNER
    static Scanner sc = new Scanner(System.in);
    
    // CONSTANTS
    static final int WEEKS = 4;
    static final int REGULAR_WEEKLY_HOURS = 40;
    static final double OVERTIME_RATE_MULTIPLIER = 1.25; // 125%
    static final double MANAGER_ALLOWANCE_PER_WEEK = 5000.00;
    static final double DEPENDENT_DEDUCTION_PER_DEPENDENT = 1000.00;

    // INITIAL EMPLOYEE INFORMATION
    static String lastName, firstName, middleName, department, position;
    static double ratePerHour;
    static boolean isManager;
    static int numberOfDependents;
    
    // GLOBAL TOTALS (PER EMPLOYEE)
    static int hoursWorked;
    static double grossPay;
    static double totalDeduction;
    static double netPay;
    
    // BREAKDOWN OF DEDUCTIONS
    static double sss;
    static double pagIbig;
    static double philHealth;
    static double tax;
    static double dependentDeduction;
    static double managerAllowance;

    public static void main(String[] args) {
        String choice;
        
        do {
            System.out.println("=============================================");
            System.out.println("        PAYROLL COMPUTATION SYSTEM           ");
            System.out.println("=============================================");
            
            System.out.println();
            
            inputEmployeeInfo();
            
            System.out.println();
            
            printPayslip();

            System.out.print("\n>> Do you want to compute again? (Y/N): ");
            choice = sc.next();
            sc.nextLine();
            
            System.out.println();
        } while (choice.equalsIgnoreCase("Y"));
        
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
        
        System.out.print(">> Rate per Hour           : ₱"); 
        ratePerHour = sc.nextDouble();
        
        System.out.print(">> Is Manager (Y/N)        : ");
        isManager = sc.next().equalsIgnoreCase("Y");
        
        System.out.print(">> Number of Dependents    : ");
        numberOfDependents = sc.nextInt();
        
        sc.nextLine();
    }

    public static double computeGP() {
        hoursWorked = 0;
        grossPay = 0;
        managerAllowance = 0;
        
        for (int weekIndex = 1; weekIndex <= WEEKS; weekIndex++) {
            System.out.printf(">> Enter hours worked for week %d: ", weekIndex);
            int hoursThisWeek = sc.nextInt();
            
            int regularHours;
            int overtimeHours;
            
            if (hoursThisWeek > REGULAR_WEEKLY_HOURS) {
                regularHours = REGULAR_WEEKLY_HOURS;
                overtimeHours = hoursThisWeek - REGULAR_WEEKLY_HOURS;
            } else {
                regularHours = hoursThisWeek;
                overtimeHours = 0;
            }
            
            double weeklyRegularPay = regularHours * ratePerHour;
            double weeklyOvertimePay = overtimeHours * ratePerHour * OVERTIME_RATE_MULTIPLIER;
            double weeklyGross = weeklyRegularPay + weeklyOvertimePay;
            
            hoursWorked += hoursThisWeek;
            grossPay += weeklyGross;
        }
        
        if (isManager) {
            managerAllowance = MANAGER_ALLOWANCE_PER_WEEK * WEEKS;
            grossPay += managerAllowance;
        }
        
        return grossPay;
    }

    public static double computeDed() {
        sss = computeSSS(grossPay);
        pagIbig = computePagIBIG(grossPay);
        philHealth = computePhilHealth(hoursWorked);
        tax = computeTax(grossPay);
        dependentDeduction = numberOfDependents * DEPENDENT_DEDUCTION_PER_DEPENDENT;
        
        totalDeduction = sss + pagIbig + philHealth + tax + dependentDeduction;
        return totalDeduction;
    }

    public static double computeNP() {
        netPay = grossPay - totalDeduction;
        return netPay;
    }

    public static double computeSSS(double gp) {
        
        if (gp <= 5000) {
            return 105;
        } else if (gp <= 10000) {
            return gp * 0.05;
        } else if (gp <= 15000) {
            return gp * 0.08 + 75;
        } else {
            return gp * 0.12 + 110;
        }
    }

    public static double computePagIBIG(double gp) {
        if (gp < 5000) {
            return 100;
        } else {
            return gp * 0.03;
        }
    }

    public static double computePhilHealth(int totalHoursWorked) {
        if (totalHoursWorked >= 10) {
            return 120;
        } else {
            return 0;
        }
    }

    public static double computeTax(double gp) {
        if (gp <= 10000) {
            return gp * 0.03;
        } else if (gp <= 25000) {
            return gp * 0.08;
        } else if (gp <= 40000) {
            return gp * 0.11;
        } else {
            return gp * 0.135;
        }
    }
    
    public static void printPayslip() {
        double computedGrossPay = computeGP();
        double computedTotalDeduction = computeDed();
        double computedNetPay = computeNP();
        
        System.out.println();
        System.out.println("===============================================");
        System.out.println("             EMPLOYEE PAY SLIP                 ");
        System.out.println("===============================================");
        System.out.printf("Name             : %s, %s %s%n", lastName, firstName, middleName);
        System.out.printf("Department       : %s%n", department);
        System.out.printf("Position         : %s%n", position);
        System.out.printf("Is Manager       : %s%n", isManager ? "Yes" : "No");
        System.out.printf("Dependents       : %d%n", numberOfDependents);
        System.out.println("----------------------------------------------");
        System.out.printf("Rate per Hour    : ₱%.2f%n", ratePerHour);
        System.out.printf("Total Hours Work : %d%n", hoursWorked);
        if (isManager) {
            System.out.printf("Manager Allowance: ₱%.2f%n", managerAllowance);
        }
        System.out.println("----------------------------------------------");
        System.out.printf("Gross Pay        : ₱%.2f%n", computedGrossPay);
        System.out.printf("SSS Contribution : ₱%.2f%n", sss);
        System.out.printf("Pag-IBIG         : ₱%.2f%n", pagIbig);
        System.out.printf("PhilHealth       : ₱%.2f%n", philHealth);
        System.out.printf("Tax              : ₱%.2f%n", tax);
        System.out.printf("Dependents Ded.  : ₱%.2f%n", dependentDeduction);
        System.out.println("----------------------------------------------");
        System.out.printf("Total Deduction  : ₱%.2f%n", computedTotalDeduction);
        System.out.printf("Net Pay          : ₱%.2f%n", computedNetPay);
        System.out.println("===============================================");
    }
}
