package googledrive.observers;

import java.util.ArrayList;
import java.util.List;

public class FileAddObservable implements Observable
{   
	
    private List<Observer>observers=new ArrayList<>();
    
    public  void addObserver(Observer observer)
    {
    	observers.add(observer);
    }
    
    public void removeObserver(Observer observer)
    {
    	observers.remove(observer);
    }
	
	
	@Override
	public void notifyObservers(String message) 
	{
		// TODO Auto-generated method stub
		
		for(Observer o:observers)
		{
			o.update(message);
		}
		
	}

}
