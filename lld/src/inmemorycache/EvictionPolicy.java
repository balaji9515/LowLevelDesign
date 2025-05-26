package inmemorycache;

public interface EvictionPolicy<K> {
	void onGet(K key);

	void onPut(K key);

	K evict();

}
