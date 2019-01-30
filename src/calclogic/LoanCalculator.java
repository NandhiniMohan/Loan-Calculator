package calclogic;

public class LoanCalculator {
	public double[] getLoanAmount(String loantype, double irate, double lperiod, double lamt) {
		double[] itrValues = new double[3];
		if (loantype.equals("PersonalLoan")) {
			double r = (irate / 100) / 12; // monthly interest rate
			double n = 12 * lperiod;
			double payment = (lamt * r) / (1 - Math.pow(1 + r, -n));
			double interest = payment * n - lamt;
			double unpaidamt = lamt + interest;
			itrValues[0] = payment; 
			itrValues[1] = interest; 
			itrValues[2] = unpaidamt; 
	    }

		else if (loantype.equals("CarLoan")) {
			double interest = irate / 100 * lamt * lperiod;
			double payment = (lamt + interest) / (lperiod * 12);
			double unpaidamt = lamt + interest;
			itrValues[0] = payment; 
			itrValues[1] = interest; 
			itrValues[2] = unpaidamt; 
	    }
		return itrValues;
	}
}
