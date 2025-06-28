package distributedqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MessageQueue<T> {

	private BlockingQueue<T> queue = new LinkedBlockingQueue<>();
	private volatile boolean running=true;

	public void publish(T message) {
		queue.add(message);

	}

	public T suscribe() throws InterruptedException {
		return queue.poll(2,TimeUnit.SECONDS);

	}
	
	public void stop()
	{
		running=false;
	}
	
	
	public boolean isRunning()
	{
		return running;
	}

}
