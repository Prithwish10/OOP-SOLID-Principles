package srp;

public class BankService {
	public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }
    // This below code dosen't follow the SRP.
    // Because, suppose at today's date the bank supports "homeLoan", "personalLoan" and "carLoan"
    // Now say in future the bank wants to support for "goldLoad" and "studyLoan"
    // Then in that case we need to modify this code, which violates SRP.
    // So create a separate class called LoanService service, which would contain the below function. 
    // And that would follow the SRP, according to which every class should have a single responsibility/functionality to perform 
    
    /*
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
    */
    
    // The below code also violates SRP.
    // Because, say the bank supports email OTP at todays date.
    // But, in future if the bank also wants to support the otp medium as sms or whatsapp,
    // then we need to change this function, which violates SRP.
    // So create a separate class called Notification service, which would contain the below function. And that would follow the SRP, according to which every class should have a single responsibility/functionality to perform 
    
    /*public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
        if(medium.equals("mobile")){
            //write logic using twillio API
        }
    }*/
}
