package distributedqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {

	private int id;
	private List<Message> messageList;
	private Map<Suscriber, AtomicInteger> offsets;

	public Partition(int id) {
		this.id = id;
		this.messageList = Collections.synchronizedList(new ArrayList<>());
		this.offsets = new ConcurrentHashMap<>();
	}

	public int getId() {
		return id;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public Map<Suscriber, AtomicInteger> getOffsets() {
		return offsets;
	}

}
