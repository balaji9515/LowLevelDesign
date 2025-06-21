package ratelimiter.algorithms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ratelimiter.RateLimiter;

public class SlidingWindowRateLimiter implements RateLimiter{
	
	private Long windowSize;
	private int maxRequests;
	private Map<String,Deque<Long>>logRequests=new ConcurrentHashMap<>();
	
	public SlidingWindowRateLimiter(long windowSize, int maxRequests)
	{
		this.windowSize=windowSize;
		this.maxRequests=maxRequests;
	}

	@Override
	public synchronized boolean allowRequest(String id) {
		// TODO Auto-generated method stub
		
		long currentTimeMillisecs=System.currentTimeMillis();
		logRequests.putIfAbsent(id, new LinkedList<Long>());
		Deque<Long>timeStamps=logRequests.get(id);
		
		while(!timeStamps.isEmpty() && currentTimeMillisecs-timeStamps.peek()>windowSize)
		{
			timeStamps.poll();
		}
		if(timeStamps.size()<maxRequests)
		{
			timeStamps.offer(currentTimeMillisecs);
			return true;
		}
		return false;
	}

}
