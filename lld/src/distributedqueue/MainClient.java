package distributedqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClient 
{
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		
		MessageBroker messageBroker=MessageBroker.getInstance();
	    MessageQueue<String> orderQueue=messageBroker.getMessageQueue(TopicName.order_satus);
		Publisher<String> publisher1=new Publisher<>(orderQueue,"Order Publisher");

		Suscriber<String> suscriber1=new Suscriber<>(orderQueue, "suscriber-1");

		executorService.execute(publisher1);
		executorService.execute(suscriber1);
		
		
	     try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     orderQueue.stop();
	     
	     executorService.shutdown();
				
	}

}
