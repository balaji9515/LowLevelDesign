package ratelimiter;

public interface RateLimiter 
{
	public boolean allowRequest(String id);
	
}
