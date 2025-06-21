package ratelimiter.algorithms;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ratelimiter.RateLimiter;

public class FixedWindowRateLimiter implements RateLimiter {
	private long windowSize;
	private long windowStart;
	private long maxRequests;
	private final Map<String, Integer> requestsCount = new ConcurrentHashMap<>();

	public FixedWindowRateLimiter(long windowSize, long maxRequests) {
		this.windowSize = windowSize;
		this.maxRequests = maxRequests;
		this.windowStart = System.currentTimeMillis();
	}

	@Override
	public synchronized boolean allowRequest(String id) {
		// TODO Auto-generated method stub

		long currentTimeMilliSecs = System.currentTimeMillis();
		if ((currentTimeMilliSecs - windowStart) > windowSize) {
			requestsCount.remove(id);
			windowStart = currentTimeMilliSecs;
		}

		requestsCount.put(id, requestsCount.getOrDefault(id, 0) + 1);

		return requestsCount.get(id) <= maxRequests;
	}

}
