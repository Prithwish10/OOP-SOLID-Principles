package srp;

//This class is following SRP, because it has only one responsibility and that is to send Notification.
public class NotificationService {
	public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
        if(medium.equals("mobile")){
            //write logic using twillio API
        }
    }
}
