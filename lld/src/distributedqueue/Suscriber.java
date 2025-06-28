package distributedqueue;

public class Suscriber<T> implements Runnable{
	private MessageQueue<T> messageQueue;

	private String name;

	public Suscriber(MessageQueue<T> messageQueue, String name) {
		this.messageQueue = messageQueue;
		this.name = name;
	}

	public void publish(T message) {
		System.out.println(name + " publishing " + message);
		messageQueue.publish(message);
	}

	@Override
	public void run() {
		
		while(messageQueue.isRunning())
		{
			try {
				T message=messageQueue.suscribe();
				
				if(null!=message)
				{
					System.out.println(name+" "+"consumed "+message);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		System.out.println(name+" stopped graceflly");
		
	}

	

}
