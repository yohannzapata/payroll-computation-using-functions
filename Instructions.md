# Final Project Description: Payroll Computation Using Functions
**Course:** COPROG1  

---

## REQUIREMENTS

- You are tasked to create a program that will compute for the salary of an employee for a month.  
- The user must input the number of hours worked per week by the employee. Assume that there are four (4) weeks in a month.  
- Save the program as **finalCode-<section>-<GroupNo>.java**.  
  - Example: `finalCode-c1a-GRP1.java`  
- **YOU MUST USE FUNCTIONS IN YOUR SOLUTION.**  
- The program should be based on the following requirements:  

---

### Computation and Deductions
1. An employee works for a regular of 40 hours a week. Beyond that is considered overtime.  
   - Example: If an employee worked for 48 hours in that week, he has an 8-hour overtime and is entitled to overtime pay.  
2. The overtime rate is **125%** of the rate per hour of an employee.  
   - Overtime pay = number of overtime hours × overtime rate per hour.  
3. **Gross pay** is the salary without deductions.  
   - Calculated as (rate per hour × regular number of hours worked) + overtime pay.  
4. Each employee is entitled to several benefits such as **SSS**, **Pag-IBIG**, and **PhilHealth**, which are deducted from the gross pay.  

---

### SSS Contribution
5. The SSS contribution is computed as follows:  

| Gross Pay (GP) | SSS Computation |
|----------------|----------------|
| GP ≤ 5,000 | Php 105.00 |
| 5,001 – 10,000 | 5% of the gross pay |
| 10,001 – 15,000 | 8% of the gross pay + P75 |
| > 15,000 | 12% of the gross pay + P110 |

---

### Pag-IBIG Contribution
6. Pag-IBIG contribution is fixed to **P100.00** for gross pay less than 5,000.00 pesos.  
   - If GP > 5,000, the contribution is **3% of the GP.**  

---

### PhilHealth Contribution
7. PhilHealth is **P120.00**.  
   - If the number of hours worked is **less than 10**, the deduction is **zero.**  

---

### Tax Computation
8. For tax, refer to the table below:  

| Gross Pay (GP) | Tax Computation |
|----------------|----------------|
| GP ≤ 10,000 | 3% of the GP |
| 10,000 – 25,000 | 8% of the GP |
| 25,001 – 40,000 | 11% of the GP |
| > 40,000 | 13.5% of the GP |

---

### Other Allowances and Deductions
9. If the employee is a **manager**, he is given a **P5,000.00 transport allowance per week.**  
10. If the employee has a dependent, a **deduction of P1,000.00** is imposed for each dependent.  
11. **Net salary** = gross pay – total deductions.  

---

### Employee Information and Output
12. The program should accept the following employee information:  
    - Last Name  
    - First Name  
    - Middle Name  
    - Department  
    - Position  
    - Rate per hour  
    - Number of hours worked  
13. The program should display a **summary or pay slip** of an employee showing:  
    - a. Employee Information  
    - b. Details of the Salary Computation  
    - c. Gross Pay  
    - d. Net Pay  
14. There should be an **option to run the program again or exit.**

---

### Required Functions
15. The following functions are required:  
    - **computeGP** – computes the gross pay of an employee  
    - **computeDed** – computes the total deductions of an employee  
    - **computeNP** – computes the net pay of an employee  
    - All of these functions must **return a value** to the calling function.  

---

### Documentation
16. The program documentation should include:  
    - **a. Description of the Program** – brief description and basic structure of the program.  
    - **b. Program Design** – IPO chart and flowchart for the problem.  
    - **c. Program Inventory** – list of all variables and functions used with a brief description of each.  
    - **d. Sample Output** – several screenshots when running the program (no explanation needed).  
17. Save the document as **finalDocu-<section>-<GroupNo>**.  
    - Convert it into **PDF** and submit it to the link provided in Canvas.  

---

### Grading Criteria
18. Your project will be graded according to the following criteria:  

**Documentation – 30 Points**  
- Flowchart (15)  
- Completeness (10)  
- Organization (5)  

**Program – 50 Points**  
- Functionality (25)  
- Completeness of the Requirements (10)  
- Implementation of Functions (15)  

**TOTAL – 80 Points**
