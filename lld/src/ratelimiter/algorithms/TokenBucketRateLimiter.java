package ratelimiter.algorithms;

import java.util.concurrent.ConcurrentHashMap;

import ratelimiter.RateLimiter;

public class TokenBucketRateLimiter implements RateLimiter {

	public int capacity;
	public long refillRate;
	public ConcurrentHashMap<String, Integer> tokens = new ConcurrentHashMap<>();
	public ConcurrentHashMap<String, Long> lastRefillTimeStamp = new ConcurrentHashMap<>();

	public TokenBucketRateLimiter(int capacity, long refillRate) {
		this.capacity = capacity;
		this.refillRate = refillRate;
	}

	@Override
	public synchronized boolean allowRequest(String id) {
		long currentTime = System.currentTimeMillis();

		lastRefillTimeStamp.putIfAbsent(id, currentTime);
		tokens.putIfAbsent(id, capacity);

		long lastRefillTime = lastRefillTimeStamp.get(id);

		long elapsedTime = (currentTime - lastRefillTime)/1000;

		if (elapsedTime > 0) {
			long newTokens = Math.min(capacity, tokens.get(id) + (elapsedTime * refillRate));

			tokens.put(id, (int) newTokens);

		}
		
		if(tokens.get(id)>0)
		{
			tokens.put(id, tokens.get(id)-1);
			return true;
		}
        return false;
	}

}
