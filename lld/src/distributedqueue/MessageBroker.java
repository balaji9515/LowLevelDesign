package distributedqueue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {

	private final Map<TopicName, MessageQueue<?>> broker = new ConcurrentHashMap<>();

	private volatile static MessageBroker instance = null;

	private MessageBroker() {

	}

	public static MessageBroker getInstance() {
		if (instance == null) {
			synchronized (MessageBroker.class) {

				if (instance == null) {
					instance = new MessageBroker();
				}

			}
		}

		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> MessageQueue<T> getMessageQueue(TopicName name) {
		return (MessageQueue<T>) broker.computeIfAbsent(name, k -> new MessageQueue<>());
	}

}
