package com.yunionyun.mcp.mcclient;

public class Cache<T> {
	
	private class CacheNode<T> {
		private String key;
		private T value;
		private long lastHit;
		
		private void save(String key, T value) {
			this.key = key;
			this.value = value;
			this.lastHit = System.currentTimeMillis();
		}
		
		private T getValue() {
			this.lastHit = System.currentTimeMillis();
			return this.value;
		}
	}
	
	private CacheNode<T>[] table;
	
	public Cache(int size) {
		int bitlen = Utils.bitLength(size);
		int nSize = 1<<bitlen;
		this.table = new CacheNode[nSize];
		for (int i = 0; i < this.table.length; i ++) {
			this.table[i] = new CacheNode<T>();
		}
	}
	
	private static final String[] ALGORITHMS = new String[] {"MD5", "SHA-256", "SHA-512"};

	private CacheNode<T> find(String key) {
		long earliest = System.currentTimeMillis();
		int earliestIndex = -1;
		for (String alg: ALGORITHMS) {
			long hash = Utils.hash(key, alg);
			int index = (int)(hash % (long)this.table.length);
			CacheNode<T> node = this.table[index];
			if (node.key != null && node.key.equals(key)) { // find!
				return node;
			}else {
				if (earliest > node.lastHit) {
					earliest = node.lastHit;
					earliestIndex = index;
				}
			}
		}
		return this.table[earliestIndex];
	}
	
	public synchronized void set(String key, T value) {
		assert(key != null && key.length() > 0);
		CacheNode<T> node = this.find(key);
		node.save(key, value);
	}
	
	public synchronized T get(String key) {
		assert(key != null && key.length() > 0);
		CacheNode<T> node = this.find(key);
		if (node.key != null && node.key.equals(key)) {
			return node.getValue();
		}
		return null;
	}
}
