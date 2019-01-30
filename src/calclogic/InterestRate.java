package calclogic;

public class InterestRate {
double irate = 0.0;
	public double getInterestRate(String loantype, String bankname)
	{
		if (loantype.equals("PersonalLoan")) {
			if (bankname.equals("CitiBank")) {
				// System.out.println("inside citi");
				irate = 14.99;
				

			} else if (bankname.equals("SBI")) {
				irate = 11.75;
				
			} else if (bankname.equals("IndianBank")) {
				irate = 17.5;
				
			}
		} else if (loantype.equals("CarLoan")) {
			if (bankname.equals("CitiBank")) {
				
				irate = 12.75;
				
			} else if (bankname.equals("SBI")) {
				irate = 10.65;
				
			} else if (bankname.equals("IndianBank")) {
				irate = 9.40;
				
			}
		}
		return irate;

	}

}
