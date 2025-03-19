package googledrive.observers;

public class SmsObserver  implements Observer{

	@Override
	public void update(String message) {
		
		System.out.println("sending message through sms :"+message);
		
	}

}
