/**
 * @author: Raghav Maheshwari
 * @date: May 12, 2020
 * @Purpose: Class for the user to interact with the program.
 * 
 * Command Line Arguments
 * @Input: 1. Loan Amount
 *         2. No of EMI's
 * 
 * Output:
 * Entire EMIDetails. (As mentioned in the document.)
 */
package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;
public class ApplicationRunner {


    //Functions to give different details while printing
    public static LocalDate getLoanCreationDate(LoanManagement loanManagement){
        return loanManagement.getLoanCreationDate();
    }

    public static double getLoanAmount(LoanManagement loanManagement){
        return loanManagement.getLoanAmount();
    }

    public static int getNoOfEMI(LoanManagement loanManagement){
        return loanManagement.getNoOfEMI();
    }

    public static double getTotalPaybleAmount(LoanManagement loanManagement){
        return loanManagement.getTotalPaybleAmount();
    }

    public static ArrayList<EMIDetails> getEmiDetails(LoanManagement loanManagement){
        return loanManagement.getEmiDetails();
    }

    public static void printDetails(LoanManagement loanManagement){

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("1. Loan Creation Date: "+getLoanCreationDate(loanManagement));
        System.out.println("2. Principal Amount: "+getLoanAmount(loanManagement));
        System.out.println("3. No of EMI's: "+getNoOfEMI(loanManagement));
        System.out.println("4. Total Payble Amount: "+getTotalPaybleAmount(loanManagement));
        System.out.println("5. EMI Details: ");
        System.out.println();
        ArrayList<EMIDetails> emiDetails = getEmiDetails(loanManagement);
        for(EMIDetails detail: emiDetails){
            System.out.println(("EMI No: "+detail.getEmiNo()+",Principal EMI: "+df.format(detail.getPrincipalEmi())+
            ",Interest EMI: "+df.format(detail.getInterestEmi())+",Total EMI: "+df.format(detail.getTotalEmi())+", EMI Date: "+detail.getEmiDate()+
            ",Principal Remaining: "+df.format(detail.getPrincipalRemaining())));
            System.out.println();
        }
    }


    public static LoanManagement setupLoanManagement(double loanAmount,int noOfEMI,double loanInterestRate){
        LoanManagement loanManagement = new LoanManagement(loanAmount, noOfEMI, loanInterestRate);
        return loanManagement;
    }
    
    
    //Main function(Takes inputs from the user making an LoanManagement object)
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the loan amount: \t");
        double loanAmount = sc.nextDouble();
        System.out.print("Enter the no of EMI's: \t");
        int noOfEMI = sc.nextInt();
        sc.close();

        //checking for the edge case.
        if(noOfEMI <=0 | loanAmount <= 0){
            System.out.println("Both of these inputs cannot be negative and must be greater than 0.");
            System.out.println("Please try again later");
            return;
        }

        double loanInterestRate = 12.0;
        //the setupLoanManagement function simply returns the loanManagement object.
        LoanManagement loanManagement = setupLoanManagement(loanAmount,noOfEMI,loanInterestRate);
        
        //Prinitng the details for user display.
        printDetails(loanManagement);

    }
}

/**
 * OUTPUT
 * 
 * Enter the loan amount:  1000
Enter the no of EMI's:  12
1. Loan Creation Date: 2020-05-13
2. Principal Amount: 1000.0
3. No of EMI's: 12
4. Total Payble Amount: 1120.0
5. EMI Details: 

EMI No: 1,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-06-13,Principal Remaining: 1026.67

EMI No: 2,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-07-13,Principal Remaining: 933.33

EMI No: 3,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-08-13,Principal Remaining: 840.00

EMI No: 4,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-09-13,Principal Remaining: 746.67

EMI No: 5,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-10-13,Principal Remaining: 653.33

EMI No: 6,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-11-13,Principal Remaining: 560.00

EMI No: 7,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2020-12-13,Principal Remaining: 466.67

EMI No: 8,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2021-01-13,Principal Remaining: 373.33

EMI No: 9,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2021-02-13,Principal Remaining: 280.00

EMI No: 10,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2021-03-13,Principal Remaining: 186.67

EMI No: 11,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2021-04-13,Principal Remaining: 93.33

EMI No: 12,Principal EMI: 83.33,Interest EMI: 10.00,Total EMI: 93.33, EMI Date: 2021-05-13,Principal Remaining: .00
 * 
 */