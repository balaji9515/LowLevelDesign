package distributedqueue;

public class Publisher<T> implements Runnable
{
	private MessageQueue<T> messageQueue;
	
	private String name;

	public Publisher(MessageQueue<T> messageQueue, String name) {
		this.messageQueue = messageQueue;
		this.name = name;
	}

    
	public void publish(T message)
	{  
		System.out.println(name+" publishing "+message);
		messageQueue.publish(message);
	}

	@Override
	public void run() 
	{
		
		for(int i=0;i<5;i++)
		{  
			@SuppressWarnings("unchecked")
			T a=(T)(name+" "+"i");
			publish(a);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) 
			{
				System.out.println("exception occured "+name+" "+e.getMessage());
			}
		}	
	}

}
