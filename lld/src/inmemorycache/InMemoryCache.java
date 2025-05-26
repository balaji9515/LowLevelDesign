package inmemorycache;

import java.util.HashMap;

public class InMemoryCache<K,V> 
{
    private int capacity;
    private HashMap<K,CacheEntry<V>>cache=new HashMap<>();
    private EvictionPolicy<K>evictionPolicy;
    
    public InMemoryCache(int cap,EvictionPolicy<K>evictionPolicy)
    {
    	this.capacity=cap;
    	this.evictionPolicy=evictionPolicy;
    }
    
    void putIntoCache(K key,CacheEntry<V>value)
    {
    	if(cache.containsKey(key))
    	{
    		cache.put(key,value);
    		evictionPolicy.onPut(key);
    		return;
    	}
    	
    	cache.put(key, value);	
    	evictionPolicy.onPut(key);
    	if(cache.size()>capacity)
    	{
    		K evict=evictionPolicy.evict();   		
    		cache.remove(evict);
    	}  	   	
    }
    
     public V getFormCache(K k)
     {
    	  CacheEntry<V>cacheEntry=cache.get(k);
    	  
    	  if(cacheEntry==null)
    	  {
    		  return null;
    	  }
    	  
    	  if(cacheEntry.hasExpired())
    	  {
    		  cache.remove(k);
    		  return null;
     	  }
    	  
    	  evictionPolicy.onGet(k);
    	  
    	  return cacheEntry.value;
     }
     
     
    
}
