package googledrive.observers;

public class EmailObserver implements Observer
{

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("sending message through email :"+message);

		
	}
	

}
