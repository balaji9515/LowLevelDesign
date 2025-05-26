package inmemorycache;

import java.util.LinkedHashSet;

public class LRUCacheEvictionPolicy<K> implements EvictionPolicy<K>  
{
      
	public LinkedHashSet<K>orderSet=new LinkedHashSet<K>();
	 
	@Override
	public void onGet(K key) {
		
		orderSet.remove(key);
		orderSet.add(key);	
	}

	@Override
	public void onPut(K key) 
	{
		orderSet.remove(key);
		orderSet.add(key);
		
	}

	@Override
	public K evict() 
	{
		 K key=orderSet.iterator().next();
		 orderSet.remove(key);
		 return key;
	}
   
}
