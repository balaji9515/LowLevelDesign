package ratelimiter;

import ratelimiter.algorithms.TokenBucketRateLimiter;

public class Main {

	public static void main(String[] args) throws InterruptedException 
	{
		
		RateLimiterService  limiterService=new RateLimiterService();
		
		limiterService.registerUser("1", new TokenBucketRateLimiter(1,1));
		
		for(int i=0;i<1000;i++)
		{
			System.out.println(limiterService.allowRequest("1")+" "+System.currentTimeMillis());
		   Thread.sleep(200);
		}
		
		
	}

}
