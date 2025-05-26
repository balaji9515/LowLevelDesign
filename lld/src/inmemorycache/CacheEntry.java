package inmemorycache;

public class CacheEntry<V>
{
	public V value;
	
	public long ttl;
	
	
	public CacheEntry(V value,Long ttl)
	{
		this.value=value;
		this.ttl=System.currentTimeMillis()+ttl;
	}
    
	public boolean hasExpired()
	{
		return System.currentTimeMillis()>ttl;
	}
}
