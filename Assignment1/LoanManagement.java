/**
 * @author: Raghav Maheshwari
 * @date: May 12, 2020
 * @Purpose: LoanManagement class for calculating the EMI's.
 */

package Assignment1;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanManagement{

	//Defining the variables.

    private double loanAmount;
    private int noOfEMI;
    private LocalDate loanCreationDate;
    private double loanInterestRate;
    private double loanInterest;
    private ArrayList<EMIDetails> emiDetails;
    private double totalPaybleAmount;

	//Constructor
    public LoanManagement(double loanAmount,int noOfEMI,double loanInterestRate){
        this.loanAmount = loanAmount;
        this.noOfEMI = noOfEMI;
        this.loanInterestRate = loanInterestRate;
        this.loanCreationDate = LocalDate.now();
        this.loanInterest = (loanInterestRate*loanAmount)/100;
        this.totalPaybleAmount = loanAmount + (loanInterestRate*loanAmount)/100;
        this.emiDetails = this.emiCalculation();
    }

	// EmiCalculation function, returns an ArrayList of EMIDetails objects.
    public ArrayList<EMIDetails> emiCalculation(){

        double principalEmi = loanAmount/noOfEMI;
        double interestEmi = loanInterest/noOfEMI;
        double totalEmi = principalEmi+interestEmi;
        ArrayList<EMIDetails> emiDetails = new ArrayList<EMIDetails>();
        for(int i=1;i<=noOfEMI;i++){
			int emiNo = i;
            LocalDate emiDate = LocalDate.now().plusMonths(emiNo);
            double principalRemaining = totalPaybleAmount-(totalEmi*i);
            EMIDetails detail = new EMIDetails(emiNo, principalEmi, interestEmi, totalEmi, emiDate, principalRemaining);
			emiDetails.add(detail);
        }

        return emiDetails;

    }


	//Defining the getters for the class.
    public double getLoanAmount() {
		return loanAmount;
	}


	public int getNoOfEMI() {
		return noOfEMI;
	}


	public LocalDate getLoanCreationDate() {
		return loanCreationDate;
	}


	public double getLoanInterestRate() {
		return loanInterestRate;
	}


	public double getLoanInterest() {
		return loanInterest;
	}


	public ArrayList<EMIDetails> getEmiDetails() {
		return emiDetails;
	}


	public double getTotalPaybleAmount() {
		return totalPaybleAmount;
	}


}