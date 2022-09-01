package srp;

// This class is following SRP, because it has only one responsibility and that is to get the Loan interest info.
public class LoanService {
	public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }
}
