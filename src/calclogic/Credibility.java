package calclogic;

public class Credibility {
	int credibility =0;
	public int getCredibility(String loantype, String bankname)
	{
	if (loantype.equals("PersonalLoan")) {
		if (bankname.equals("CitiBank")) {
			
			credibility = 4;

		} else if (bankname.equals("SBI")) {
			
			credibility = 2;
			
		} else if (bankname.equals("IndianBank")) {
			
			credibility = 3;
		}
	} else if (loantype.equals("CarLoan")) {
		if (bankname.equals("CitiBank")) {
			
			credibility = 4;
		} else if (bankname.equals("SBI")) {
			
			credibility = 2;
			
		} else if (bankname.equals("IndianBank")) {
			
			credibility = 3;
		}
	}
	return credibility;
	}
}
