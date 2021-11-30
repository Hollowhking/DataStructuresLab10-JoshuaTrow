package main;

import java.util.*;

public abstract class Hashtable<T> {
    protected int capacity = 0;
    protected List<String> keys = null;
    private List<T> values = null;

    private int probeCount = 0;

    public int getProbeCount() {
        return this.probeCount;
    }
    
    public void addProbe (int x) {
    	this.probeCount+=x;
    }

    public void resetProbeCount() {
        this.probeCount = 0;
    }

    public Hashtable(int capacity) {
        this.keys = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            this.keys.add(null);
        }
        this.values = new ArrayList<T>();
        for (int i = 0; i < capacity; i++) {
            this.values.add(null);
        }
        this.capacity = capacity;
    }

    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % capacity;
    }

    public abstract int rehash(int previousHash);

    public void insert(String key, T value) {
        // YOUR CODE GOES HERE
    	int ind = hash(key);
    	for (int i = 0; i < this.capacity; i++) {
    		if (this.keys.get(ind)==null) {
    			this.addProbe(1);
	    		this.keys.set(ind,key);
	    		this.values.set(ind,value);
	    		break;
	    	}
	    	else {
	    		ind = rehash(ind);
	    		this.addProbe(1);
	    	}
    	}
    }
}