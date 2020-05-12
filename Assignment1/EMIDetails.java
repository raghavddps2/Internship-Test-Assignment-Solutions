/**
 * @author: Raghav Maheshwari
 * @date: May 12, 2020
 * @Purpose: EMIDetails class for each of the EMIDetail
 */

package Assignment1;
import java.time.LocalDate;

public class EMIDetails {
	
	//Declaring the variables
	
    private int emiNo;
    private double principalEmi;
    private double interestEmi;
    private double totalEmi;
    private LocalDate emiDate;
    private double principalRemaining;
    
    
    //Constuctor
	public EMIDetails(int emiNo, double principalEmi, double interestEmi, double totalEmi, LocalDate emiDate,
			double principalRemaining) {
		this.emiNo = emiNo;
		this.principalEmi = principalEmi;
		this.interestEmi = interestEmi;
		this.totalEmi = totalEmi;
		this.emiDate = emiDate;
		this.principalRemaining = principalRemaining;
	}

	//defining the getters.
	public int getEmiNo() {
		return emiNo;
	}
	
	public double getPrincipalEmi() {
		return principalEmi;
	}

	public double getInterestEmi() {
		return interestEmi;
	}

	public double getTotalEmi() {
		return totalEmi;
	}

	public LocalDate getEmiDate() {
		return emiDate;
	}

	public double getPrincipalRemaining() {
		return principalRemaining;
	}

       
}