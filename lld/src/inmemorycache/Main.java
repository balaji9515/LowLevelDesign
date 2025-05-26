package inmemorycache;

public class Main 
{
	
	public static void main(String Args[]) throws InterruptedException
	{   
		
		LRUCacheEvictionPolicy<Integer> evictionPolicy=new LRUCacheEvictionPolicy<Integer>();
	   InMemoryCache<Integer,Object> cache=new InMemoryCache<Integer,Object>(3,evictionPolicy);
	    
	   
	   CacheEntry<Object> cacheEntry1=new CacheEntry<>("balaji",(long) 3000);
	   cache.putIntoCache(1,cacheEntry1);
	   
	   CacheEntry<Object>cacheEntry2=new CacheEntry<Object>("sai",(long)2000);
	   
	   cache.putIntoCache(2,cacheEntry2);
	   
	   cache.putIntoCache(3, new CacheEntry<>("Balu",(long)4000));
	   
	   System.out.println(cache.getFormCache(1));
	   Thread.sleep(2500); 
	   System.out.println(cache.getFormCache(2));
	   System.out.println(cache.getFormCache(1));
	   
	      
	   
	}

}
