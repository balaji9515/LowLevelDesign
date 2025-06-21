package ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService 
{
	private final Map<String,RateLimiter>userRateLimiter=new ConcurrentHashMap<>();
	
    
	public void registerUser(String id,RateLimiter limiter)
	{
		userRateLimiter.put(id, limiter);
	}
    
	
	public boolean allowRequest(String id)
	{
		RateLimiter limiter=userRateLimiter.get(id);
		
		return limiter.allowRequest(id);
	}
}
