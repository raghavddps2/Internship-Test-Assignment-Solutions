/**
 * @author: Raghav Maheshwari
 * @date: May 12, 2020
 * @Purpose: Class for the user to interact with the program.
 */
package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ApplicationRunner {

    //Function to printDetails() of the loan EMI's.
    public static void printDetails(LoanManagement loanManagement){

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("1. Loan Creation Date: "+loanManagement.getLoanCreationDate());
        System.out.println("2. Principal Amount: "+loanManagement.getLoanAmount());
        System.out.println("3. No of EMI's: "+loanManagement.getNoOfEMI());
        System.out.println("4. Total Payble Amount: "+loanManagement.getTotalPaybleAmount());
        System.out.println("5. EMI Details: ");
        System.out.println();
        ArrayList<EMIDetails> emiDetails = loanManagement.getEmiDetails();
        for(EMIDetails detail: emiDetails){
            System.out.println(("EMI No: "+detail.getEmiNo()+",Principal EMI: "+df.format(detail.getPrincipalEmi())+
            ",Interest EMI: "+df.format(detail.getInterestEmi())+",Total EMI: "+df.format(detail.getTotalEmi())+", EMI Date: "+detail.getEmiDate()+
            ",Principal Remaining: "+df.format(detail.getPrincipalRemaining())));
            System.out.println();
        }
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
        LoanManagement loanManagement = new LoanManagement(loanAmount, noOfEMI, loanInterestRate);
        System.out.println("\n*************Loan Details***************\n");
        printDetails(loanManagement);

    }
}